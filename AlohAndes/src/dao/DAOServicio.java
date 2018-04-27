package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Persona;
import vos.Servicio;

public class DAOServicio {
	
	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOServicio() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<Servicio> getServicios() throws SQLException, Exception {
		ArrayList<Servicio> servicios = new ArrayList<Servicio>();

		String sql = String.format("SELECT * FROM %1$s.SERVICIOS WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			servicios.add(convertResultSetToServicio(rs));
		}
		return servicios;
	}

	public Servicio findServicioById(Long id) throws SQLException, Exception {
		Servicio servicio = null;

		String sql = String.format("SELECT * FROM %1$s.SERVICIOS WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			servicio = convertResultSetToServicio(rs);
		}

		return servicio;
	}

	public void addServicio(Servicio servicio) throws SQLException, Exception {

		String sql = String.format(
				"INSERT INTO %1$s.SERVICIOS (ID, TIPO_OFERTA, ID_OFERTA, NOM_SERVICIO) VALUES (%2$s, '%3$s', '%4$s', '%5$s')",
				USUARIO, servicio.getId(), servicio.getTipoOferta(), servicio.getIdOferta(), servicio.getNomServicio());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}

	public void updateServicio(Servicio servicio) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.SERVICIOS ", USUARIO));
		sql.append(String.format("SET TIPO_OFERTA = '%1$s', ID_OFERTA = '%2$s', NOM_SERVICIO = '%3$s' ", servicio.getTipoOferta(),
				servicio.getIdOferta(), servicio.getNomServicio()));
		sql.append("WHERE ID = " + servicio.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteServicio(Servicio servicio) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.SERVICIOS WHERE ID = %2$d", USUARIO, servicio.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Servicio convertResultSetToServicio(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		String tipoOferta = resultSet.getString("TIPO_OFERTA");
		Long idOferta = resultSet.getLong("ID_OFERTA");
		String nomServicio = resultSet.getString("NOM_SERVICIO");

		Servicio ser = new Servicio(id, tipoOferta, idOferta, nomServicio);

		return ser;
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
