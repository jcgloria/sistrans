package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Evento;

public class DAOEvento {
	
	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOEvento() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<Evento> getEventos() throws SQLException, Exception {
		ArrayList<Evento> eventos = new ArrayList<Evento>();

		String sql = String.format("SELECT * FROM %1$s.EVENTOS WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			eventos.add(convertResultSetToEvento(rs));
		}
		return eventos;
	}

	public Evento findEventoById(Long id) throws SQLException, Exception {
		Evento evento = null;

		String sql = String.format("SELECT * FROM %1$s.EVENTOS WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			evento = convertResultSetToEvento(rs);
		}

		return evento;
	}

	public void addEvento(Evento evento) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.EVENTOS (ID, NOMBRE, FECHA_INICIO, FECHA_FINAL) VALUES (%2$s, '%3$s', '%4$s', '%5$s')",
				USUARIO, evento.getId(), evento.getNombre(), evento.getFechaInicio(), evento.getFechaFinal());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateEvento(Evento evento) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.EVENTOS ", USUARIO));
		sql.append(String.format("SET NOMBRE = '%1$s', FECHA_INICIO = '%2$s', FECHA_FINAL = '%3$s' ", evento.getNombre(),
				evento.getFechaInicio(), evento.getFechaFinal()));
		sql.append("WHERE ID = " + evento.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteEvento(Evento evento) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.EVENTOS WHERE ID = %2$d", USUARIO, evento.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Evento convertResultSetToEvento(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		String nombre = resultSet.getString("NOMBRE");
		Date fechaInicio = resultSet.getDate("FECHA_INICIO");
		Date fechaFinal = resultSet.getDate("FECHA_FINAL");

		Evento eve = new Evento(id, nombre, fechaInicio, fechaFinal);

		return eve;
	}

	public void setConn(Connection connection) {
		this.conn = connection;
	}

	public void cerrarRecursos() {
		for (Object ob : recursos) {
			if (ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

}
