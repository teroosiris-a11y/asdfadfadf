package com.example.CallCenter.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioSistemaRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioSistemaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UsuarioSistema obtenerPorCredenciales(String usuario, String contrasenia) {
        List<UsuarioSistema> usuarios = jdbcTemplate.query("""
                SELECT u.id, u.usuario, u.contrasenia, r.nombre AS rol,
                       u.id_empresa, u.id_agente, u.estado
                FROM usuarios_sistema u
                INNER JOIN roles r ON r.id = u.rol_id
                WHERE LOWER(u.usuario) = LOWER(?) AND u.contrasenia = ?
                """, this::mapUsuarioSistema, usuario, contrasenia);
        return usuarios.stream().findFirst().orElse(null);
    }

    public void asegurarRol(String nombre, String descripcion) {
        Integer total = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM roles WHERE LOWER(nombre) = LOWER(?)",
                Integer.class,
                nombre);
        if (total == null || total == 0) {
            jdbcTemplate.update("INSERT INTO roles (nombre, descripcion) VALUES (?, ?)", nombre, descripcion);
        }
    }

    public void asegurarUsuario(String usuario, String contrasenia, String rol, Integer idEmpresa, Integer idAgente, String estado) {
        Integer total = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM usuarios_sistema WHERE LOWER(usuario) = LOWER(?)",
                Integer.class,
                usuario);
        if (total != null && total > 0) {
            return;
        }

        Integer rolId = jdbcTemplate.queryForObject(
                "SELECT id FROM roles WHERE LOWER(nombre) = LOWER(?)",
                Integer.class,
                rol);
        jdbcTemplate.update("""
                INSERT INTO usuarios_sistema (usuario, contrasenia, rol_id, id_empresa, id_agente, estado)
                VALUES (?, ?, ?, ?, ?, ?)
                """, usuario, contrasenia, rolId, idEmpresa, idAgente, estado);
    }

    private UsuarioSistema mapUsuarioSistema(ResultSet rs, int rowNum) throws SQLException {
        return new UsuarioSistema(
                rs.getInt("id"),
                rs.getString("usuario"),
                rs.getString("contrasenia"),
                rs.getString("rol"),
                obtenerEnteroNullable(rs, "id_empresa"),
                obtenerEnteroNullable(rs, "id_agente"),
                rs.getString("estado"));
    }

    private Integer obtenerEnteroNullable(ResultSet rs, String columna) throws SQLException {
        int valor = rs.getInt(columna);
        return rs.wasNull() ? null : valor;
    }
}
