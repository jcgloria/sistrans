package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Vivienda;

public class DAOVivienda {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOVivienda() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<Vivienda> getViviendas() throws SQLException, Exception {
		ArrayList<Vivienda> viviendas = new ArrayList<Vivienda>();

		String sql = String.format("SELECT * FROM %1$s.OPERADORES_VIVIENDA WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			viviendas.add(convertResultSetToVivienda(rs));
		}
		return viviendas;
	}

	public Vivienda findViviendaById(Long id) throws SQLException, Exception {
		Vivienda vivienda = null;

		String sql = String.format("SELECT * FROM %1$s.OPERADORES_VIVIENDA WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			vivienda = convertResultSetToVivienda(rs);
		}

		return vivienda;
	}

	public void addVivienda(Vivienda vivienda) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OPERADORES_VIVIENDA (ID, NOMBRE, UBICACION) VALUES (%2$s, '%3$s', '%4$s')",
				USUARIO, vivienda.getId(), vivienda.getId(), vivienda.getNombre(), vivienda.getUbicacion());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateVivienda(Vivienda vivienda) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OPERADORES_VIVIENDA ", USUARIO));
		sql.append(String.format("SET NOMBRE = '%1$s', UBICACION = '%2$s'", vivienda.getNombre(),
				vivienda.getUbicacion()));
		sql.append("WHERE ID = " + vivienda.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteVivienda(Vivienda vivienda) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OPERADORES_VIVIENDA WHERE ID = %2$d", USUARIO, vivienda.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Vivienda convertResultSetToVivienda(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		String nombre = resultSet.getString("NOMBRE");
		String ubicacion = resultSet.getString("UBICACION");

		Vivienda viv = new Vivienda(id, nombre, ubicacion);

		return viv;
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
