package com.example.CallCenter.Empresa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaRepository implements EmpresaDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmpresaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        cargarEmpresaInicial();
    }

    @Override
    public void registrarEmpresa(Empresa empresa) {
        int nuevoId = obtenerSiguienteId();
        String num = String.format("%02d", nuevoId);
        String estado = tieneTexto(empresa.getEstado()) ? empresa.getEstado() : "activo";

        jdbcTemplate.update("""
                INSERT INTO empresas (id, nombre, telefono, correo, usuario, contrasenia, estado)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """,
                nuevoId,
                empresa.getNombre(),
                empresa.getTelefono(),
                empresa.getCorreo(),
                "empresa" + num,
                "emp" + num,
                estado);
        empresa.setId(nuevoId);
        empresa.setUsuario("empresa" + num);
        empresa.setContrasenia("emp" + num);
        empresa.setEstado(estado);
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return jdbcTemplate.query("SELECT * FROM empresas ORDER BY id", this::mapEmpresa);
    }

    @Override
    public Empresa obtenerEmpresaPorId(int id) {
        List<Empresa> empresas = jdbcTemplate.query("SELECT * FROM empresas WHERE id = ?", this::mapEmpresa, id);
        return empresas.stream().findFirst().orElse(null);
    }

    @Override
    public void actualizarEmpresa(Empresa empresa) {
        Empresa actual = obtenerEmpresaPorId(empresa.getId());
        if (actual == null) {
            return;
        }
        String estado = tieneTexto(empresa.getEstado()) ? empresa.getEstado() : actual.getEstado();
        jdbcTemplate.update("""
                UPDATE empresas
                SET nombre = ?, telefono = ?, correo = ?, estado = ?
                WHERE id = ?
                """,
                empresa.getNombre(),
                empresa.getTelefono(),
                empresa.getCorreo(),
                estado,
                empresa.getId());
        empresa.setUsuario(actual.getUsuario());
        empresa.setContrasenia(actual.getContrasenia());
        empresa.setEstado(estado);
    }

    @Override
    public void eliminarEmpresa(int id) {
        jdbcTemplate.update("UPDATE empresas SET estado = 'borrado' WHERE id = ?", id);
    }

    @Override
    public Empresa obtenerPorCredenciales(String usuario, String contrasenia) {
        List<Empresa> empresas = jdbcTemplate.query("""
                SELECT * FROM empresas
                WHERE LOWER(usuario) = LOWER(?) AND contrasenia = ?
                """, this::mapEmpresa, usuario, contrasenia);
        return empresas.stream().findFirst().orElse(null);
    }

    private void cargarEmpresaInicial() {
        Integer total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM empresas", Integer.class);
        if (total != null && total == 0) {
            jdbcTemplate.update("""
                    INSERT INTO empresas (id, nombre, telefono, correo, usuario, contrasenia, estado)
                    VALUES (1, 'Empresa Demo', '900000001', 'demo@empresa.com', 'empresa01', 'emp01', 'activo')
                    """);
        }
    }

    private int obtenerSiguienteId() {
        Integer siguiente = jdbcTemplate.queryForObject("SELECT COALESCE(MAX(id), 0) + 1 FROM empresas", Integer.class);
        return siguiente == null ? 1 : siguiente;
    }

    private Empresa mapEmpresa(ResultSet rs, int rowNum) throws SQLException {
        Empresa empresa = new Empresa(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("correo"));
        empresa.setUsuario(rs.getString("usuario"));
        empresa.setContrasenia(rs.getString("contrasenia"));
        empresa.setEstado(rs.getString("estado"));
        return empresa;
    }

    private boolean tieneTexto(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }
}
