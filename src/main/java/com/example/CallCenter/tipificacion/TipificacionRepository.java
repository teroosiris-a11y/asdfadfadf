package com.example.CallCenter.tipificacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TipificacionRepository implements TipificacionDAO {

    private final JdbcTemplate jdbcTemplate;

    public TipificacionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        cargarTipificacionesIniciales();
    }

    @Override
    public List<Tipificacion> listarTipificaciones() {
        return jdbcTemplate.query("SELECT * FROM tipificaciones ORDER BY id_tipo", this::mapTipificacion);
    }

    @Override
    public List<String> listarTiposLlamada() {
        return jdbcTemplate.queryForList("SELECT motivo_tipo FROM tipificaciones ORDER BY id_tipo", String.class);
    }

    @Override
    public Tipificacion obtenerTipificacionPorId(int id_tipo) {
        List<Tipificacion> tipificaciones = jdbcTemplate.query(
                "SELECT * FROM tipificaciones WHERE id_tipo = ?",
                this::mapTipificacion,
                id_tipo);
        return tipificaciones.stream().findFirst().orElse(null);
    }

    @Override
    public void crearTipificacion(Tipificacion tipificacion) {
        int nuevoId = obtenerSiguienteId();
        tipificacion.setId_tipo(nuevoId);
        tipificacion.setId_empresa(1);
        jdbcTemplate.update("""
                INSERT INTO tipificaciones (id_tipo, motivo_tipo, descripcion_tipo, id_empresa)
                VALUES (?, ?, ?, ?)
                """,
                tipificacion.getId_tipo(),
                tipificacion.getMotivo_tipo(),
                tipificacion.getDescripcion_tipo(),
                tipificacion.getId_empresa());
    }

    @Override
    public void actualizarTipificacion(Tipificacion tipificacion) {
        Tipificacion actual = obtenerTipificacionPorId(tipificacion.getId_tipo());
        if (actual == null) {
            return;
        }
        jdbcTemplate.update("""
                UPDATE tipificaciones
                SET motivo_tipo = ?, descripcion_tipo = ?
                WHERE id_tipo = ?
                """,
                tipificacion.getMotivo_tipo(),
                tipificacion.getDescripcion_tipo(),
                tipificacion.getId_tipo());
        tipificacion.setId_empresa(actual.getId_empresa());
    }

    @Override
    public void eliminarTipificacion(int id_tipo) {
        jdbcTemplate.update("DELETE FROM tipificaciones WHERE id_tipo = ?", id_tipo);
    }

    private void cargarTipificacionesIniciales() {
        Integer total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tipificaciones", Integer.class);
        if (total != null && total == 0) {
            jdbcTemplate.batchUpdate("""
                    INSERT INTO tipificaciones (id_tipo, motivo_tipo, descripcion_tipo, id_empresa)
                    VALUES (?, ?, ?, ?)
                    """, List.of(
                    new Object[] {1, "Consulta", "El cliente solicita información general.", 1},
                    new Object[] {2, "Reclamo", "El cliente presenta una queja formal.", 1},
                    new Object[] {3, "Venta", "El cliente adquiere un producto o servicio.", 1},
                    new Object[] {4, "Soporte", "El cliente necesita asistencia técnica.", 1},
                    new Object[] {5, "Otros", "Casos que no encajan en las categorías anteriores.", 1}
            ));
        }
    }

    private int obtenerSiguienteId() {
        Integer siguiente = jdbcTemplate.queryForObject("SELECT COALESCE(MAX(id_tipo), 0) + 1 FROM tipificaciones", Integer.class);
        return siguiente == null ? 1 : siguiente;
    }

    private Tipificacion mapTipificacion(ResultSet rs, int rowNum) throws SQLException {
        return new Tipificacion(
                rs.getInt("id_tipo"),
                rs.getString("motivo_tipo"),
                rs.getString("descripcion_tipo"),
                rs.getInt("id_empresa"));
    }
}
