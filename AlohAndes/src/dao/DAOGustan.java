package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Gustan;
import vos.Persona;


public class DAOGustan {
	
	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOGustan() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<Gustan> getGustan() throws SQLException, Exception {
		ArrayList<Gustan> gustan = new ArrayList<Gustan>();

		String sql = String.format("SELECT * FROM %1$s.GUSTAN WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			gustan.add(convertResultSetToGustan(rs));
		}
		return gustan;
	}

	public void addGustan(Gustan gustan) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.SERVICIOS (PERSONA, SERVICIO) VALUES (%2$s, '%3$s')",
				USUARIO, gustan.getPersona(), gustan.getServicio());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void deleteGustan(Gustan gustan) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.SERVICIOS WHERE PERSONA = %2$d AND SERVICIO = %3$d", USUARIO, gustan.getPersona(), gustan.getServicio());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Gustan convertResultSetToGustan(ResultSet resultSet) throws SQLException {
		Long persona = resultSet.getLong("PERSONA");
		String servicio = resultSet.getString("SERVICIO");

		Gustan gus = new Gustan(persona, servicio);

		return gus;
	}
	
	public ArrayList<String> darServiciosDeUnaPersona(Persona persona) throws SQLException, Exception{
		ArrayList<String> servicios = new ArrayList<String>();
		String sql = String.format("SELECT * FROM %1$s.GUSTAN WHERE PERSONA = %2$s" , USUARIO, persona.getId());
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while(rs.next()) {
			servicios.add(convertResultSetToGustan(rs).getServicio());
		}
		return servicios;
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
