package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Hotel;

public class DAOHotel {

		public final static String USUARIO = "ISIS2304A091810";

		private ArrayList<Object> recursos;
		private Connection conn;

		public DAOHotel() {
			recursos = new ArrayList<Object>();
		}

		public ArrayList<Hotel> getHotels() throws SQLException, Exception {
			ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

			String sql = String.format("SELECT * FROM %1$s.OPERADORES_HOTEL WHERE ROWNUM <= 50", USUARIO);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				hoteles.add(convertResultSetToHotel(rs));
			}
			return hoteles;
		}

		public Hotel findHotelById(Long id) throws SQLException, Exception {
			Hotel hotel = null;

			String sql = String.format("SELECT * FROM %1$s.OPERADORES_HOTEL WHERE ID = %2$d", USUARIO, id);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			ResultSet rs = prepStmt.executeQuery();

			if (rs.next()) {
				hotel = convertResultSetToHotel(rs);
			}

			return hotel;
		}

		public void addHotel(Hotel hotel) throws SQLException, Exception {

			String sql = String.format(
					"INSERT INTO %1$s.OPERADORES_HOTEL (ID, NOMBRE, DIRECCION) VALUES (%2$s, '%3$s', '%4$s')",
					USUARIO, hotel.getId(), hotel.getNombre(), hotel.getDireccion());
			System.out.println(sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();

		}

		public void updateHotel(Hotel hotel) throws SQLException, Exception {

			StringBuilder sql = new StringBuilder();
			sql.append(String.format("UPDATE %s.Hotels ", USUARIO));
			sql.append(String.format("SET NOMBRE = '%1$s', DIRECCION = '%2$s'", hotel.getNombre(),
					hotel.getDireccion()));
			sql.append("WHERE ID = " + hotel.getId());
			System.out.println(sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}

		public void deleteHotel(Hotel hotel) throws SQLException, Exception {

			String sql = String.format("DELETE FROM %1$s.OPERADORES_HOTEL WHERE ID = %2$d", USUARIO, hotel.getId());

			System.out.println(sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}

		public Hotel convertResultSetToHotel(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("ID");
			String nombre = resultSet.getString("NOMBRE");
			String direccion = resultSet.getString("DIRECCION");

			Hotel hot = new Hotel(id, nombre, direccion);

			return hot;
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
