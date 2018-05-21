package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Persona;
import vos.Reserva;

public class DAOPersona {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOPersona() {
		recursos = new ArrayList<Object>();
	}
	
	public ArrayList<Persona> rfc8(String oferta) throws SQLException, Exception{
		ArrayList<Persona> personas = new ArrayList<Persona>();

		String sql = String.format("SELECT PERSONAS.ID, PERSONAS.NOMBRE, PERSONAS.CORREO, PERSONAS.AFILIACION "
				                 + "FROM (%1$s.RESERVAS INNER JOIN %2$s.PERSONAS ON RESERVAS.PERSONA = PERSONAS.ID) "
				                 + "WHERE RESERVAS.TIPO_OFERTA = '%3$s' "  
				                 + "AND RESERVAS.FECHA_FIN - RESERVAS.FECHA_INICIO >=15 "  
				                 + "GROUP BY PERSONAS.ID, PERSONAS.NOMBRE, PERSONAS.CORREO, PERSONAS.AFILIACION " 
				                 + "ORDER BY PERSONAS.ID" , USUARIO, USUARIO, oferta);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			personas.add(convertResultSetToPersona(rs));
		}
		return personas;
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
	
	/**
	 * Para rfc10
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	public Persona convertResultSetToPersona2(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("PERSONA");
		String nombre = resultSet.getString("NOMBRE");
		String correo = resultSet.getString("CORREO");
		String afiliacion = resultSet.getString("AFILIACION");

		Persona per = new Persona(id, nombre, correo, afiliacion);

		return per;
	}
	
	/**
	 * RFC10 consultar consumo de personas
	 * @param inicio
	 * @param fin
	 * @param idOferta
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Persona> consultarConsumoSQL(String inicio, String fin, Long idOferta) throws SQLException{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		String sql = String.format("SELECT PERSONA,NOMBRE,CORREO, AFILIACION FROM %1$s.RESERVAS INNER JOIN PERSONAS ON RESERVAS.PERSONA = PERSONAS.ID WHERE ID_OFERTA = %2$s AND (FECHA_INICIO BETWEEN TO_DATE('%3$s', 'DD/MM/YY') AND TO_DATE('%4$s', 'DD/MM/YY'))", USUARIO, idOferta, inicio, fin);
		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			personas.add(convertResultSetToPersona2(rs));
		}
		return personas;
	}
	
	public ArrayList<Persona> consultarConsumoSQLNegado(String inicio, String fin, Long idOferta) throws SQLException{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		String sql = String.format("SELECT * FROM PERSONAS WHERE ID NOT IN"
				+ "(SELECT PERSONA FROM RESERVAS INNER JOIN PERSONAS ON "
				+ "RESERVAS.PERSONA = PERSONAS.ID "
				+ "WHERE ID_OFERTA = 235090 "
				+ "AND (FECHA_INICIO BETWEEN TO_DATE('01/01/19', 'DD/MM/YY') "
				+ "AND TO_DATE('01/01/20', 'DD/MM/YY')))", USUARIO, idOferta, inicio, fin);
			//	+ "AND ROWNUM <=300";  //limite para que termine el query
		System.out.println(sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			personas.add(convertResultSetToPersona(rs));
		}
		return personas;
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
