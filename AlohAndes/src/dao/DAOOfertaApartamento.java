package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.OfertaApartamento;

public class DAOOfertaApartamento {
	
	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOOfertaApartamento() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<OfertaApartamento> getOfertaApartamentos() throws SQLException, Exception {
		ArrayList<OfertaApartamento> ofertaApartamentos = new ArrayList<OfertaApartamento>();

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_APARTAMENTO WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			ofertaApartamentos.add(convertResultSetToOfertaApartamento(rs));
		}
		return ofertaApartamentos;
	}

	public OfertaApartamento findOfertaApartamentoById(Long id) throws SQLException, Exception {
		OfertaApartamento ofertaApartamento = null;

		String sql = String.format("SELECT * FROM %1$s.OFERTAS_APARTAMENTO WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			ofertaApartamento = convertResultSetToOfertaApartamento(rs);
		}

		return ofertaApartamento;
	}

	public void addOfertaApartamento(OfertaApartamento ofertaApartamento) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OFERTAS_APARTAMENTO (ID, COSTO, SERVICIOS, INTERNET_TV, ADMINISTRACION, PERSONA) VALUES (%2$s, '%3$s', '%4$s', '%5$s','%6$s', '%7$s')",
				USUARIO, ofertaApartamento.getId(), ofertaApartamento.getCosto(), ofertaApartamento.getServicios(), 
				ofertaApartamento.getInternetTv(), ofertaApartamento.getAdministracion(), ofertaApartamento.getPersona());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateOfertaApartamento(OfertaApartamento ofertaApartamento) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OFERTAS_APARTAMENTO ", USUARIO));
		sql.append(String.format("SET COSTO = '%1$s', SERVICIOS = '%2$s', INTERNET_TV = '%3$s', ADMINISTRACION = '%4$s', "
				+ "PERSONA = '%5$s'", ofertaApartamento.getCosto(),ofertaApartamento.getServicios(), ofertaApartamento.getInternetTv(), ofertaApartamento.getAdministracion(), ofertaApartamento.getPersona()));
		sql.append("WHERE ID = " + ofertaApartamento.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteOfertaApartamento(OfertaApartamento ofertaApartamento) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OFERTAS_APARTAMENTO WHERE ID = %2$d", USUARIO, ofertaApartamento.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public OfertaApartamento convertResultSetToOfertaApartamento(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		Long costo = resultSet.getLong("COSTO");
		String servicios = resultSet.getString("SERVICIOS");
		String internetTv = resultSet.getString("INTERNET_TV");
		String administracion = resultSet.getString("ADMINISTRACION");
		Long persona = resultSet.getLong("PERSONA");

		OfertaApartamento ofApt = new OfertaApartamento(id, costo, servicios, internetTv, administracion,  persona);

		return ofApt;
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
