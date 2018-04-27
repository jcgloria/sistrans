package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.OfertaPersonaNatural;

public class DAOOfertaPersonaNatural {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOOfertaPersonaNatural() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<OfertaPersonaNatural> getOfertaPersonaNaturals() throws SQLException, Exception {
		ArrayList<OfertaPersonaNatural> ofertasPersonaNatural = new ArrayList<OfertaPersonaNatural>();

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_PERSONANATURAL WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			ofertasPersonaNatural.add(convertResultSetToOfertaPersonaNatural(rs));
		}
		return ofertasPersonaNatural;
	}

	public OfertaPersonaNatural findOfertaPersonaNaturalById(Long id) throws SQLException, Exception {
		OfertaPersonaNatural ofertaPersonaNatural = null;

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_PERSONANATURAL WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			ofertaPersonaNatural = convertResultSetToOfertaPersonaNatural(rs);
		}

		return ofertaPersonaNatural;
	}

	public void addOfertaPersonaNatural(OfertaPersonaNatural ofertaPersonaNatural) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OFERTAS_PERSONANATURAL (ID, PRECIO_MENSUAL, PRECIO_SEMESTRE, OFERTAS_PERSONANATURAL) VALUES (%2$s, '%3$s', '%4$s', '%5$s')",
				USUARIO, ofertaPersonaNatural.getId(), ofertaPersonaNatural.getPrecioMensual(), ofertaPersonaNatural.getPrecioSemestre(), ofertaPersonaNatural.getPersona());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateOfertaPersonaNatural(OfertaPersonaNatural ofertaPersonaNatural) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_PERSONANATURAL ", USUARIO));
		sql.append(String.format("SET PRECIO_MENSUAL = '%1$s', PRECIO_SEMESTRE = '%2$s', OFERTAS_PERSONANATURAL = '%3$s'", ofertaPersonaNatural.getPrecioMensual(), ofertaPersonaNatural.getPrecioSemestre(), ofertaPersonaNatural.getPersona()));
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteOfertaPersonaNatural(OfertaPersonaNatural ofertaPersonaNatural) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OFERTAS_PERSONANATURAL WHERE ID = %2$d", USUARIO, ofertaPersonaNatural.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public OfertaPersonaNatural convertResultSetToOfertaPersonaNatural(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		Long precioMensual = resultSet.getLong("PRECIO_MENSUAL");
		Long precioSemestre = resultSet.getLong("PRECIO_SEMESTRE");
		Long persona = resultSet.getLong("OPERADOR_PERSONANATURAL");


		OfertaPersonaNatural ofPerN = new OfertaPersonaNatural(id, precioMensual, precioSemestre, persona);

		return ofPerN;
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
