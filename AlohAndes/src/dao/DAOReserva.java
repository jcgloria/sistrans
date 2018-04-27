package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import vos.Reserva;

public class DAOReserva {

	public final static String USUARIO = "ISIS2304A091810";

	private ArrayList<Object> recursos;
	private Connection conn;

	public DAOReserva() {
		recursos = new ArrayList<Object>();
	}
	
	public ArrayList<Reserva> getReservas() throws SQLException, Exception {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();

		String sql = String.format("SELECT * FROM %1$s.RESERVAS WHERE ROWNUM <= 50", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			reservas.add(convertResultSetToReserva(rs));
		}
		return reservas;
	}

	public Reserva findReservaById(Long id) throws SQLException, Exception {
		Reserva reserva = null;

		String sql = String.format("SELECT * FROM %1$s.Reservas WHERE ID = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		if (rs.next()) {
			reserva = convertResultSetToReserva(rs);
		}

		return reserva;
	}


	public void addReserva(Reserva reserva) throws SQLException, Exception {
		String sql = String.format(
				"INSERT INTO %1$s.Reservas (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO CALCULADO, ESTADO, PERSONA) VALUES (%2$s, '%3$s', '%4$s', '%5$s','%6$s', '%7$s', '%8$s', '%9$s', '%10$s', '%11$s')",
				USUARIO, reserva.getId(), reserva.getTipoOferta(), reserva.getIdOferta(), reserva.getFechaReserva(), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getFechaOportuna(), calcularCosto(reserva), "activo", reserva.getPersona());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	/**
	 * RF4 - Registrar una reserva. Se usa el metodo de calcular el costo a partir de las fechas que se seleccionaron.
	 * @param reserva
	 * @throws SQLException
	 * @throws Exception
	 */
	public void agregarReserva(Date fechaInicio, Date fechaFin, String tipoOferta, Long idOferta, Long persona) throws SQLException, Exception {
		Long randomNum = (long) ThreadLocalRandom.current().nextInt(2000, 999999999);
		Reserva res = new Reserva(randomNum, tipoOferta, idOferta, new Date(System.currentTimeMillis()), fechaInicio, fechaFin, new Date(fechaInicio.getTime()+8*24*60*60*1000), (long) 0, "activa", persona);
		res.setCostoCalculado(calcularCosto(res));
		addReserva(res);
	}

	public void updateReserva(Reserva reserva) throws SQLException, Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(String.format("UPDATE %s.Reservas ", USUARIO));
		sql.append(String.format("SET TIPO_OFERTA = '%1$s', ID_OFERTA = '%2$s', FECHA_RESERVA = '%3$s', FECHA_INICIO = '%4$s', "
				+ "FECHA_FIN = '%5$s', FECHA_OPORTUNA = '%6$s', COSTO_CALCULADO = '%7$s', ESTADO = '%8$s', PERSONA = '%9$s'  ", reserva.getTipoOferta(),
				reserva.getIdOferta(), reserva.getFechaReserva(), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getFechaOportuna(), reserva.getCostoCalculado(), "activo", reserva.getPersona()));
		sql.append("WHERE ID = " + reserva.getId());
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteReserva(Reserva Reserva) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.Reservas WHERE ID = %2$d", USUARIO, Reserva.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Long calcularCosto(Reserva reserva) throws SQLException, Exception {
		System.out.println("Empezando calculo de costo...");
		double precio = 0;
		if(reserva.getEstado().equals( "activo")) {
			System.out.println("La reserva esta activa");
			switch(reserva.getTipoOferta()) {
			case "hotel": DAOOfertaHotel daoOfertaHotel = new DAOOfertaHotel();
			precio = daoOfertaHotel.findOfertaHotelById(reserva.getIdOferta()).getPrecio();
			case "hostal" : DAOOfertaHostal daoOfertaHostal = new DAOOfertaHostal();
			precio = daoOfertaHostal.findOfertaHostalById(reserva.getIdOferta()).getPrecio();
			case "vivienda" : DAOOfertaVivienda daoOfertaVivienda = new DAOOfertaVivienda();
			precio = daoOfertaVivienda.findOfertaViviendaById(reserva.getIdOferta()).getCostoNoche();
			case "apartamento" : DAOOfertaApartamento daoOfertaApartamento = new DAOOfertaApartamento();
			precio = daoOfertaApartamento.findOfertaApartamentoById(reserva.getId()).getCosto();
			case "evento" : DAOOfertaEvento daoOfertaEvento = new DAOOfertaEvento();
			precio = daoOfertaEvento.findOfertaEventoById(reserva.getId()).getPrecio();
			case "persona natural": DAOOfertaPersonaNatural daoOfertaPN = new DAOOfertaPersonaNatural();
			precio = daoOfertaPN.findOfertaPersonaNaturalById(reserva.getId()).getPrecioMensual();
			return (long) (precio*((calcularDiasEntreDates(reserva.getFechaInicio(), reserva.getFechaFin()))/30));
			}	

			precio = (Double) precio*(calcularDiasEntreDates(reserva.getFechaInicio(), reserva.getFechaFin()));
		}
		else {
			System.out.println("La reserva se cancelo");
			Date today = new Date(System.currentTimeMillis());
			if(today.before(reserva.getFechaInicio())) { //si se cancela antes de la fecha de inicio
				precio = precio*0.3;
			}
			else { //si se cancela despues de la fecha de inicio
				precio = precio*0.5;
			}
		}
		return (long) precio;
	}

	/**
	 * RF5 - Cancelar Reserva. Se cambia el estado de la reserva a cancelado y se actualiza.
	 * @param reserva La reserva que se va a cancelar
	 * @throws SQLException
	 * @throws Exception
	 */
	public void cancelarReserva(Reserva reserva) throws SQLException, Exception {
		System.out.println("Cancelando reserva con id: " + reserva.getId() + "...");
		reserva.setEstado("cancelado");
		updateReserva(reserva);
		System.out.println("Reserva actualizada exitosamente");
	}

	/**
	 * Consulta la disponibilidad de una oferta de AlohAndes.
	 * @param tipoOferta
	 * @param idOferta
	 * @param fechaInicio
	 * @param fechaFin
	 * @return true si la oferta esta disponible, false si esta ocupada durante estas fechas
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean consultarDisponibilidad(String tipoOferta, Long idOferta, Date fechaInicio, Date fechaFin) throws SQLException, Exception {
		boolean disponible = true;
		ArrayList<Reserva> reservasPotenciales = new ArrayList<Reserva>();
		String sql = String.format("SELECT * FROM %1$s.Reservas WHERE TIPO_OFERTA = %2$s AND ID_OFERTA = %3$d AND ESTADO = ACTIVA", USUARIO, tipoOferta, idOferta);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			reservasPotenciales.add(convertResultSetToReserva(rs));
		}
		for(int i = 0; i<reservasPotenciales.size() && disponible; i++) {
			Reserva actual = reservasPotenciales.get(i);
			if(actual.getFechaInicio().compareTo(fechaInicio)*fechaInicio.compareTo(actual.getFechaFin()) > 0){
				disponible = false;
			}
			else if(actual.getFechaInicio().before(fechaFin)){
				disponible = false;
			}
		}
		return disponible;
	}

	/**
	 * Metodo que busca todas las reservas de la persona y fechas especificadas por parametro, y se eliminan. 
	 * Este metodo se usa para cancelar reservas colectivas.
	 * @param persona
	 * @param fechaInicio
	 * @param fechaFin
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public void cancelarReservaPersonaYFechas(Long persona, Date fechaInicio, Date fechaFin) throws SQLException, Exception {
		ArrayList<Reserva> reservas = getReservas();
		for(int i = 0; i<reservas.size(); i++) {
			Reserva actual = reservas.get(i);
			if(actual.getPersona() == persona && actual.getFechaInicio().equals(fechaInicio) && actual.getFechaFin().equals(fechaFin)) {
				deleteReserva(actual);
			}
		}
	}


	public Reserva convertResultSetToReserva(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		String tipoOferta = resultSet.getString("TIPO_OFERTA");
		Long idOferta = resultSet.getLong("ID_OFERTA");
		Date afiliacion = resultSet.getDate("FECHA_RESERVA");
		Date fechaInicio = resultSet.getDate("FECHA_INICIO");
		Date fechaFin = resultSet.getDate("FECHA_FIN");
		Date fechaOportuna = resultSet.getDate("FECHA_OPORTUNA");
		Long costoCalculado = resultSet.getLong("COSTO_CALCULADO");
		String estado = resultSet.getString("ESTADO");
		Long persona = resultSet.getLong("PERSONA");

		Reserva res = new Reserva(id, tipoOferta, idOferta, afiliacion, fechaInicio, fechaFin, fechaOportuna, costoCalculado, estado, persona);

		return res;
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

	public static int calcularDiasEntreDates(Date a, Date b) {
		try {
			long diff = b.getTime() - a.getTime();
			return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}
