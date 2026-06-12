package com.example.CallCenter.llamada;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.CallCenter.tipificacion.Tipificacion;
import com.example.CallCenter.tipificacion.TipificacionDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LlamadaRepository implements LlamadaDAO {

    private final JdbcTemplate jdbcTemplate;
    private final TipificacionDAO tipificacionDAO;

    public LlamadaRepository(JdbcTemplate jdbcTemplate, TipificacionDAO tipificacionDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.tipificacionDAO = tipificacionDAO;
        cargarLlamadasIniciales();
    }

    @Override
    public List<Llamada> listarLlamadas() {
        return jdbcTemplate.query("SELECT * FROM llamadas ORDER BY id_llamada", this::mapLlamada);
    }

    @Override
    public Llamada obtenerLlamadaPorId(int id_llamada) {
        List<Llamada> llamadas = jdbcTemplate.query("SELECT * FROM llamadas WHERE id_llamada = ?", this::mapLlamada, id_llamada);
        return llamadas.stream().findFirst().orElse(null);
    }

    @Override
    public void crearLlamada(Llamada llamada) {
        int nuevoId = obtenerSiguienteId();
        llamada.setId_llamada(nuevoId);
        llamada.setId_agente(1);
        llamada.setFecha_llamada(LocalDate.now().toString());
        llamada.setHora(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        asignarMotivo(llamada);
        jdbcTemplate.update("""
                INSERT INTO llamadas (id_llamada, nombre_cliente, telefono_cliente, fecha_llamada, hora, id_agente, id_tipo, motivo_tipo)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """,
                llamada.getId_llamada(),
                llamada.getNombre_cliente(),
                llamada.getTelefono_cliente(),
                llamada.getFecha_llamada(),
                llamada.getHora(),
                llamada.getId_agente(),
                llamada.getId_tipo(),
                llamada.getMotivo_tipo());
    }

    @Override
    public void actualizarLlamada(Llamada llamada) {
        Llamada actual = obtenerLlamadaPorId(llamada.getId_llamada());
        if (actual == null) {
            return;
        }
        asignarMotivo(llamada);
        llamada.setFecha_llamada(actual.getFecha_llamada());
        llamada.setHora(actual.getHora());
        llamada.setId_agente(actual.getId_agente());
        jdbcTemplate.update("""
                UPDATE llamadas
                SET nombre_cliente = ?, telefono_cliente = ?, id_tipo = ?, motivo_tipo = ?
                WHERE id_llamada = ?
                """,
                llamada.getNombre_cliente(),
                llamada.getTelefono_cliente(),
                llamada.getId_tipo(),
                llamada.getMotivo_tipo(),
                llamada.getId_llamada());
    }

    @Override
    public void eliminarLlamada(int id_llamada) {
        jdbcTemplate.update("DELETE FROM llamadas WHERE id_llamada = ?", id_llamada);
    }

    private void cargarLlamadasIniciales() {
        Integer total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM llamadas", Integer.class);
        if (total != null && total == 0) {
            jdbcTemplate.batchUpdate("""
                    INSERT INTO llamadas (id_llamada, nombre_cliente, telefono_cliente, fecha_llamada, hora, id_agente, id_tipo, motivo_tipo)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                    """, List.of(
                    new Object[] {1, "Maria Lopez", "987654321", "2026-05-01", "09:10", 1, 1, "Consulta"},
                    new Object[] {2, "Carlos Perez", "923456781", "2026-05-02", "10:25", 1, 2, "Reclamo"},
                    new Object[] {3, "Ana Torres", "934567812", "2026-05-03", "11:40", 1, 3, "Venta"},
                    new Object[] {4, "Luis Ramirez", "945678123", "2026-05-04", "13:15", 1, 4, "Soporte"},
                    new Object[] {5, "Rosa Garcia", "956781234", "2026-05-05", "15:05", 1, 5, "Otros"}
            ));
        }
    }

    private int obtenerSiguienteId() {
        Integer siguiente = jdbcTemplate.queryForObject("SELECT COALESCE(MAX(id_llamada), 0) + 1 FROM llamadas", Integer.class);
        return siguiente == null ? 1 : siguiente;
    }

    private void asignarMotivo(Llamada llamada) {
        Integer idTipo = llamada.getId_tipo();
        if (idTipo == null) {
            return;
        }
        Tipificacion tip = tipificacionDAO.obtenerTipificacionPorId(idTipo);
        if (tip != null) {
            llamada.setMotivo_tipo(tip.getMotivo_tipo());
        }
    }

    private Llamada mapLlamada(ResultSet rs, int rowNum) throws SQLException {
        return new Llamada(
                rs.getInt("id_llamada"),
                rs.getString("nombre_cliente"),
                rs.getString("telefono_cliente"),
                rs.getString("fecha_llamada"),
                rs.getString("hora"),
                rs.getInt("id_agente"),
                rs.getInt("id_tipo"),
                rs.getString("motivo_tipo"));
    }
}
