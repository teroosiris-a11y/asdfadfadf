package com.example.CallCenter.agente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AgenteRepository implements AgenteDAO {

    private final JdbcTemplate jdbcTemplate;

    public AgenteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        cargarAgentesIniciales();
    }

    @Override
    public List<Agente> listarAgentes() {
        return jdbcTemplate.query("SELECT * FROM agentes ORDER BY id_agente", this::mapAgente);
    }

    @Override
    public Agente obtenerAgentePorId(int id_agente) {
        List<Agente> agentes = jdbcTemplate.query("SELECT * FROM agentes WHERE id_agente = ?", this::mapAgente, id_agente);
        return agentes.stream().findFirst().orElse(null);
    }

    @Override
    public void crearAgente(Agente agente) {
        int nuevoId = obtenerSiguienteId();
        agente.setId_agente(nuevoId);
        agente.setUsuario_agente("agente0" + nuevoId);
        agente.setContrasenia_agente("age0" + nuevoId);
        agente.setId_empresa(1);
        jdbcTemplate.update("""
                INSERT INTO agentes (id_agente, nombre_agente, telefono_agente, usuario_agente, contrasenia_agente, id_empresa)
                VALUES (?, ?, ?, ?, ?, ?)
                """,
                agente.getId_agente(),
                agente.getNombre_agente(),
                agente.getTelefono_agente(),
                agente.getUsuario_agente(),
                agente.getContrasenia_agente(),
                agente.getId_empresa());
    }

    @Override
    public void actualizarAgente(Agente agente) {
        Agente actual = obtenerAgentePorId(agente.getId_agente());
        if (actual == null) {
            return;
        }
        jdbcTemplate.update("""
                UPDATE agentes
                SET nombre_agente = ?, telefono_agente = ?
                WHERE id_agente = ?
                """,
                agente.getNombre_agente(),
                agente.getTelefono_agente(),
                agente.getId_agente());
        agente.setUsuario_agente(actual.getUsuario_agente());
        agente.setContrasenia_agente(actual.getContrasenia_agente());
        agente.setId_empresa(actual.getId_empresa());
    }

    @Override
    public void eliminarAgente(int id_agente) {
        jdbcTemplate.update("DELETE FROM agentes WHERE id_agente = ?", id_agente);
    }

    private void cargarAgentesIniciales() {
        Integer total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM agentes", Integer.class);
        if (total != null && total == 0) {
            jdbcTemplate.batchUpdate("""
                    INSERT INTO agentes (id_agente, nombre_agente, telefono_agente, usuario_agente, contrasenia_agente, id_empresa)
                    VALUES (?, ?, ?, ?, ?, ?)
                    """, List.of(
                    new Object[] {1, "Carlos García", "987654321", "agente01", "age01", 1},
                    new Object[] {2, "Ana Mendoza", "912345678", "agente02", "age02", 1},
                    new Object[] {3, "Luis Quispe", "923456789", "agente03", "age03", 1},
                    new Object[] {4, "María Flores", "934567890", "agente04", "age04", 1},
                    new Object[] {5, "Roberto Vargas", "945678901", "agente05", "age05", 1}
            ));
        }
    }

    private int obtenerSiguienteId() {
        Integer siguiente = jdbcTemplate.queryForObject("SELECT COALESCE(MAX(id_agente), 0) + 1 FROM agentes", Integer.class);
        return siguiente == null ? 1 : siguiente;
    }

    private Agente mapAgente(ResultSet rs, int rowNum) throws SQLException {
        return new Agente(
                rs.getInt("id_agente"),
                rs.getString("nombre_agente"),
                rs.getString("telefono_agente"),
                rs.getString("usuario_agente"),
                rs.getString("contrasenia_agente"),
                rs.getInt("id_empresa"));
    }
}
