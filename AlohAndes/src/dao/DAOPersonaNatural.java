package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.PersonaNatural;

public class DAOPersonaNatural {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOPersonaNatural() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<PersonaNatural> getPersonanaturales() throws SQLException, Exception {
		ArrayList<PersonaNatural> personasN = new ArrayList<PersonaNatural>();

		String sql = String.format("SELECT * FROM %1$s.OPERADORES_PERSONANATURAL WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			personasN.add(convertResultSetToPersonaNatural(rs));
		}
		return personasN;
	}

	public PersonaNatural findPersonaNaturalById(Long id) throws SQLException, Exception {
		PersonaNatural personaN = null;

		String sql = String.format("SELECT * FROM %1$s.OPERADORES_PERSONANATURAL WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			personaN = convertResultSetToPersonaNatural(rs);
		}

		return personaN;
	}

	public void addPersonaNatural(PersonaNatural persona) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.OPERADORES_PERSONANATURAL (ID, COSTO_SERVICIOS, PERSONA) VALUES (%2$s, '%3$s', '%4$s')",
				USUARIO, persona.getId(), persona.getCostoServicios(), persona.getPersona());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updatePersonaNatural(PersonaNatural persona) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.OPERADORES_PERSONANATURAL ", USUARIO));
		sql.append(String.format("SET COSTO_SERVICIOS = '%1$s', PERSONA = '%2$s' ", persona.getCostoServicios(),
				persona.getPersona()));
		sql.append("WHERE ID = " + persona.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deletePersonaNatural(PersonaNatural persona) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.OPERADORES_PERSONANATURAL WHERE ID = %2$d", USUARIO, persona.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public PersonaNatural convertResultSetToPersonaNatural(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		Long costoServicios = resultSet.getLong("COSTO_SERVICIOS");
		Long persona = resultSet.getLong("PERSONA");

		PersonaNatural perN = new PersonaNatural(id, costoServicios, persona);

		return perN;
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
