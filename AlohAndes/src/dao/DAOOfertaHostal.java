package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.OfertaHostal;

public class DAOOfertaHostal {
	
	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOOfertaHostal() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<OfertaHostal> getOfertasHotel() throws SQLException, Exception {
		ArrayList<OfertaHostal> ofertasHotel = new ArrayList<OfertaHostal>();

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_HOSTAL WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			ofertasHotel.add(convertResultSetToOfertaHostal(rs));
		}
		return ofertasHotel;
	}

	public OfertaHostal findOfertaHostalById(Long id) throws SQLException, Exception {
		OfertaHostal ofertaHostal = null;

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_HOSTAL WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			ofertaHostal = convertResultSetToOfertaHostal(rs);
		}

		return ofertaHostal;
	}

	public void addOfertaHostal(OfertaHostal ofertaHostal) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OFERTAS_HOSTAL (ID, PRECIO, HOSTAL, ESTADO) VALUES (%2$s, '%3$s', '%4$s', 'HABILITADO')",
				USUARIO, ofertaHostal.getId(), ofertaHostal.getPrecio(), ofertaHostal.getHostal());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateOfertaHostal(OfertaHostal ofertaHostal) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_HOSTAL ", USUARIO));
		sql.append(String.format("SET PRECIO = '%1$s', HOSTAL = '%2$s'", ofertaHostal.getPrecio(), ofertaHostal.getHostal()));
		sql.append("WHERE ID = " + ofertaHostal.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteOfertaHostal(OfertaHostal OfertaHostal) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OFERTAS_HOSTAL WHERE ID = %2$d", USUARIO, OfertaHostal.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deshabilitarOferta(Long idOferta) throws SQLException, Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_HOSTAL ", USUARIO));
		sql.append(String.format("SET ESTADO = 'deshabilitado"));
		sql.append("WHERE ID = " + idOferta);
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public OfertaHostal convertResultSetToOfertaHostal(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		Long precio = resultSet.getLong("PRECIO");
		Long hostal = resultSet.getLong("HOSTAL");
		String estado = resultSet.getString("ESTADO");

		OfertaHostal ofHotel = new OfertaHostal(id, precio, hostal, estado);

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
