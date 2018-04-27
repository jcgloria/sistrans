package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.OfertaHotel;

public class DAOOfertaHotel {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOOfertaHotel() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<OfertaHotel> getOfertasHotel() throws SQLException, Exception {
		ArrayList<OfertaHotel> ofertasHotel = new ArrayList<OfertaHotel>();

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_HOTEL WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			ofertasHotel.add(convertResultSetToOfertaHotel(rs));
		}
		return ofertasHotel;
	}

	public OfertaHotel findOfertaHotelById(Long id) throws SQLException, Exception {
		OfertaHotel ofertaHotel = null;
		String sql = String.format("SELECT * FROM %1$s.OFERTAS_HOTEL WHERE ID = %2$d", USUARIO, id);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			ofertaHotel = convertResultSetToOfertaHotel(rs);
		}
		
		return ofertaHotel;
	}

	public void addOfertaHotel(OfertaHotel ofertaHotel) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OFERTAS_HOTEL (ID, TIPO_HABITACION, PRECIO, HOTEL, ESTADO) VALUES (%2$s, '%3$s', '%4$s', '%5$s', 'HABILITADO')",
				USUARIO, ofertaHotel.getId(), ofertaHotel.getTipoHabitacion(), ofertaHotel.getPrecio(), ofertaHotel.getHotel());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateOfertaHotel(OfertaHotel ofertaHotel) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_HOTEL ", USUARIO));
		sql.append(String.format("SET TIPO_HABITACION = '%1$s', PRECIO = '%2$s', HOTEL = '%3$s'", ofertaHotel.getTipoHabitacion(), ofertaHotel.getPrecio(), ofertaHotel.getHotel()));
		sql.append("WHERE ID = " + ofertaHotel.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteOfertaHotel(OfertaHotel OfertaHotel) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OFERTAS_HOTEL WHERE ID = %2$d", USUARIO, OfertaHotel.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	/**
	 * Metodo que devuelve las ofertas de cierto tipo de habitacion y con ciertos servicios
	 * @param idPersona
	 * @param tipoHabitacion
	 * @param cantidad
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<OfertaHotel> getOfertasHotelPorTipo(Long idPersona, String tipoHabitacion, int cantidad) throws SQLException, Exception {
		ArrayList<OfertaHotel> ofertasHotel = new ArrayList<OfertaHotel>();

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_HOTEL WHERE TIPO_HABITACION = %2$s ", USUARIO, tipoHabitacion);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			ofertasHotel.add(convertResultSetToOfertaHotel(rs));
		}
		return ofertasHotel;
	}
	
	public void deshabilitarOferta(Long idOferta) throws SQLException, Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_HOTEL ", USUARIO));
		sql.append(String.format("SET ESTADO = 'deshabilitado"));
		sql.append("WHERE ID = " + idOferta);
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public OfertaHotel convertResultSetToOfertaHotel(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		String tipoHabitacion = resultSet.getString("TIPO_HABITACION");
		Long precio = resultSet.getLong("PRECIO");
		Long hotel = resultSet.getLong("HOTEL");
		String estado = resultSet.getString("ESTADO");

		OfertaHotel ofHotel = new OfertaHotel(id, tipoHabitacion, precio, hotel, estado);

		return ofHotel;
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

	public void habilitarOferta(Long idOferta) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_HOTEL ", USUARIO));
		sql.append(String.format("SET ESTADO = 'habilitado"));
		sql.append("WHERE ID = " + idOferta);
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}

}
