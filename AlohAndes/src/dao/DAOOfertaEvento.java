package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.OfertaEvento;

public class DAOOfertaEvento {
	
	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOOfertaEvento() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<OfertaEvento> getOfertaEventos() throws SQLException, Exception {
		ArrayList<OfertaEvento> ofertasEvento = new ArrayList<OfertaEvento>();

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_EVENTO WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			ofertasEvento.add(convertResultSetToOfertaEvento(rs));
		}
		return ofertasEvento;
	}

	public OfertaEvento findOfertaEventoById(Long id) throws SQLException, Exception {
		OfertaEvento ofertaEvento = null;

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_EVENTO WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			ofertaEvento = convertResultSetToOfertaEvento(rs);
		}

		return ofertaEvento;
	}

	public void addOfertaEvento(OfertaEvento ofertaEvento) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OFERTAS_EVENTO (ID, PRECIO, NUM_HABITACIONES, DIRECCION, MENAJE, EVENTO) VALUES (%2$s, '%3$s', '%4$s', '%5$s','%6$s', '%7$s')",
				USUARIO, ofertaEvento.getId(), ofertaEvento.getPrecio(), ofertaEvento.getNumHabitaciones(), 
				ofertaEvento.getDireccion(), ofertaEvento.getMenaje(), ofertaEvento.getEvento());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateOfertaEvento(OfertaEvento ofertaEvento) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_EVENTO ", USUARIO));
		sql.append(String.format("SET PRECIO = '%1$s', NUM_HABITACIONES = '%2$s', DIRECCION = '%3$s', MENAJE = '%4$s', "
				+ "EVENTO = '%5$s'", ofertaEvento.getPrecio(),ofertaEvento.getNumHabitaciones(), ofertaEvento.getDireccion(), ofertaEvento.getMenaje(), ofertaEvento.getEvento()));
		sql.append("WHERE ID = " + ofertaEvento.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteOfertaEvento(OfertaEvento ofertaEvento) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OFERTAS_EVENTO WHERE ID = %2$d", USUARIO, ofertaEvento.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public OfertaEvento convertResultSetToOfertaEvento(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		Long precio = resultSet.getLong("PRECIO");
		Long numHabitaciones = resultSet.getLong("NUM_HABITACIONES");
		String direccion = resultSet.getString("DIRECCION");
		String menaje = resultSet.getString("MENAJE");
		Long evento = resultSet.getLong("EVENTO");

		OfertaEvento ofEven = new OfertaEvento(id, precio, numHabitaciones, direccion, menaje, evento);

		return ofEven;
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
