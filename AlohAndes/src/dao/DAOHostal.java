package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Hostal;

public class DAOHostal {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOHostal() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<Hostal> getHostaless() throws SQLException, Exception {
		ArrayList<Hostal> hostales = new ArrayList<Hostal>();

		String sql = String.format("SELECT * FROM %1$s.OPERADORES_HOSTAL WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			hostales.add(convertResultSetToHostal(rs));
		}
		return hostales;
	}

	public Hostal findHostalById(Long id) throws SQLException, Exception {
		Hostal hostal = null;

		String sql = String.format("SELECT * FROM %1$s.OPERADORES_HOSTAL WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			hostal = convertResultSetToHostal(rs);
		}

		return hostal;
	}

	public void addHostal(Hostal hostal) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OPERADORES_HOSTAL (ID, NOMBRE, DIRECCION, HORA_APERTURA, HORA_CIERRE) VALUES (%2$s, '%3$s', '%4$s', '%5$s', '%6$s')",
				USUARIO, hostal.getId(), hostal.getNombre(), hostal.getDireccion(), hostal.getHoraApertura(), hostal.getHoraCierre());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateHostal(Hostal hostal) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OPERADORES_HOSTAL ", USUARIO));
		sql.append(String.format("SET NOMBRE = '%1$s', DIRECCION = '%2$s', HORA_APERTURA = '%3$s', HORA_CIERRE = '%4$s'", hostal.getNombre(),
				hostal.getDireccion(), hostal.getHoraApertura(), hostal.getHoraCierre()));
		sql.append("WHERE ID = " + hostal.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteHostal(Hostal hostal) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OPERADORES_HOSTAL WHERE ID = %2$d", USUARIO, hostal.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Hostal convertResultSetToHostal(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		String nombre = resultSet.getString("NOMBRE");
		String direccion = resultSet.getString("DIRECCION");
		String horaApertura = resultSet.getString("HORA_APERTURA");
		String horaCierre = resultSet.getString("HORA_CIERRE");

		Hostal hos = new Hostal(id, nombre, direccion, horaApertura, horaCierre);

		return hos;
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
