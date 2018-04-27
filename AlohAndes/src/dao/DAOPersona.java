package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Persona;

public class DAOPersona {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOPersona() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<Persona> getPersonas() throws SQLException, Exception {
		ArrayList<Persona> personas = new ArrayList<Persona>();

		String sql = String.format("SELECT * FROM %1$s.PERSONAS WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			personas.add(convertResultSetToPersona(rs));
		}
		return personas;
	}

	public Persona findPersonaById(Long id) throws SQLException, Exception {
		Persona persona = null;

		String sql = String.format("SELECT * FROM %1$s.Personas WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		if (rs.next()) {
			persona = convertResultSetToPersona(rs);
		}

		return persona;
	}

	public void addPersona(Persona persona) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.Personas (ID, NOMBRE, CORREO, AFILIACION) VALUES (%2$s, '%3$s', '%4$s', '%5$s')",
				USUARIO, persona.getId(), persona.getNombre(), persona.getCorreo(), persona.getAfiliacion());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updatePersona(Persona persona) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.Personas ", USUARIO));
		sql.append(String.format("SET NOMBRE = '%1$s', CORREO = '%2$s', AFILIACION = '%3$s' ", persona.getNombre(),
				persona.getCorreo(), persona.getAfiliacion()));
		sql.append("WHERE ID = " + persona.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deletePersona(Persona persona) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.Personas WHERE ID = %2$d", USUARIO, persona.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Persona convertResultSetToPersona(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		String nombre = resultSet.getString("NOMBRE");
		String correo = resultSet.getString("CORREO");
		String afiliacion = resultSet.getString("AFILIACION");

		Persona per = new Persona(id, nombre, correo, afiliacion);

		return per;
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
