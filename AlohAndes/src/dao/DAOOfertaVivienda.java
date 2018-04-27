package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.OfertaVivienda;

public class DAOOfertaVivienda {
	
	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOOfertaVivienda() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<OfertaVivienda> getOfertaViviendas() throws SQLException, Exception {
		ArrayList<OfertaVivienda> ofertaViviendas = new ArrayList<OfertaVivienda>();

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_VIVIENDA WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			ofertaViviendas.add(convertResultSetToOfertaVivienda(rs));
		}
		return ofertaViviendas;
	}

	public OfertaVivienda findOfertaViviendaById(Long id) throws SQLException, Exception {
		OfertaVivienda ofertaVivienda = null;

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_VIVIENDA WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			ofertaVivienda = convertResultSetToOfertaVivienda(rs);
		}

		return ofertaVivienda;
	}

	public void addOfertaVivienda(OfertaVivienda ofertaVivienda) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OFERTAS_VIVIENDA (ID, COSTO_NOCHE, COSTO_MENSUAL, COSTO_SEMESTRE, MENAJE, CAPACIDAD, VIVIENDA) VALUES (%2$s, '%3$s', '%4$s', '%5$s','%6$s', '%7$s', '%8$s')",
				USUARIO, ofertaVivienda.getId(), ofertaVivienda.getCostoNoche(), ofertaVivienda.getCostoMensual(), 
				ofertaVivienda.getCostoSemestre(), ofertaVivienda.getMenaje(), ofertaVivienda.getCapacidad(), 
				ofertaVivienda.getVivienda());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateOfertaVivienda(OfertaVivienda ofertaVivienda) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_VIVIENDA ", USUARIO));
		sql.append(String.format("SET COSTO_NOCHE = '%1$s', COSTO_MENSUAL = '%2$s', COSTO_SEMESTRE = '%3$s', MENAJE = '%4$s', "
				+ "CAPACIDAD = '%5$s', VIVIENDA = '%6$s'", ofertaVivienda.getCostoNoche(),
				ofertaVivienda.getCostoMensual(), ofertaVivienda.getCostoSemestre(), ofertaVivienda.getMenaje(), ofertaVivienda.getCapacidad(), ofertaVivienda.getVivienda()));
		sql.append("WHERE ID = " + ofertaVivienda.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteOfertaVivienda(OfertaVivienda OfertaVivienda) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OFERTAS_VIVIENDA WHERE ID = %2$d", USUARIO, OfertaVivienda.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public OfertaVivienda convertResultSetToOfertaVivienda(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		Long costoNoche = resultSet.getLong("COSTO_NOCHE");
		Long costoMensual = resultSet.getLong("COSTO_MENSUAL");
		Long costoSemestre = resultSet.getLong("COSTO_SEMESTRE");
		String menaje = resultSet.getString("MENAJE");
		Long capacidad = resultSet.getLong("CAPACIDAD");
		Long vivienda = resultSet.getLong("VIVIENDA");

		OfertaVivienda ofViv = new OfertaVivienda(id, costoNoche, costoMensual, costoSemestre, menaje, capacidad, 
				vivienda);

		return ofViv;
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
