package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import vos.Reserva;
import vos.VORFC12;
import vos.VORFC12OF;
import vos.VORFC12OP;
import vos.VORFC13;

public class DAOReserva {

	public final static String USUARIO = "ISIS2304A091810";
	
	public final static String USUARIO2 = "ISIS2304A071810";

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


	//	public void addReserva(Reserva reserva) throws SQLException, Exception {
	//		String sql = String.format(
	//				"INSERT INTO %1$s.Reservas (ID, TIPO_OFERTA, ID_OFERTA, FECHA_RESERVA, FECHA_INICIO, FECHA_FIN, FECHA_OPORTUNA, COSTO_CALCULADO, ESTADO, PERSONA) VALUES (%2$s, '%3$s', '%4$s', TO_DATE('%5$s', 'YYYY-MM-DD'), TO_DATE('%6$s', 'YYYY-MM-DD'), TO_DATE('%7$s', 'YYYY-MM-DD'), TO_DATE('%8$s', 'YYYY-MM-DD'), '%9$s', '%10$s', '%11$s')",
	//				USUARIO, reserva.getId(), reserva.getTipoOferta(), reserva.getIdOferta(), reserva.getFechaReserva(), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getFechaOportuna(), calcularCosto(reserva), reserva.getEstado(), reserva.getPersona());
	//		System.out.println(sql);
	//
	//		PreparedStatement prepStmt = conn.prepareStatement(sql);
	//		recursos.add(prepStmt);
	//		prepStmt.executeQuery();
	//
	//	}
	/**
	 * RF4 - Registrar una reserva. Se usa el metodo de calcular el costo a partir de las fechas que se seleccionaron.
	 * @param reserva
	 * @throws SQLException
	 * @throws Exception
	 */
	//	public void agregarReserva(Date fechaInicio, Date fechaFin, String tipoOferta, Long idOferta, Long persona) throws SQLException, Exception {
	//		Long randomNum = (long) ThreadLocalRandom.current().nextInt(2000, 999999999);
	//		Reserva res = new Reserva(randomNum, tipoOferta, idOferta, new Date(System.currentTimeMillis()), fechaInicio, fechaFin, new Date(fechaInicio.getTime()+8*24*60*60*1000), (long) 0, "activa", persona);
	//		res.setCostoCalculado(calcularCosto(res));
	//		addReserva(res);
	//	}

	//	public void updateReserva(Reserva reserva) throws SQLException, Exception {
	//
	//		StringBuilder sql = new StringBuilder();
	//		sql.append(String.format("UPDATE %s.Reservas ", USUARIO));
	//		sql.append(String.format("SET TIPO_OFERTA = '%1$s', ID_OFERTA = '%2$s', FECHA_RESERVA = '%3$s', FECHA_INICIO = '%4$s', "
	//				+ "FECHA_FIN = '%5$s', FECHA_OPORTUNA = '%6$s', COSTO_CALCULADO = '%7$s', ESTADO = '%8$s', PERSONA = '%9$s'  ", reserva.getTipoOferta(),
	//				reserva.getIdOferta(), reserva.getFechaReserva(), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getFechaOportuna(), reserva.getCostoCalculado(), "activo", reserva.getPersona()));
	//		sql.append("WHERE ID = " + reserva.getId());
	//		System.out.println(sql);
	//
	//		PreparedStatement prepStmt = conn.prepareStatement(sql.toString());
	//		recursos.add(prepStmt);
	//		prepStmt.executeQuery();
	//	}

	public void deleteReserva(Reserva Reserva) throws SQLException, Exception {

		String sql = String.format("DELETE FROM %1$s.Reservas WHERE ID = %2$d", USUARIO, Reserva.getId());

		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	//	public Long calcularCosto(Reserva reserva) throws SQLException, Exception {
	//		double precio = 0;
	//		if(reserva.getEstado().equalsIgnoreCase( "activa")) {
	//			switch(reserva.getTipoOferta()) {
	//			case "hotel": DAOOfertaHotel daoOfertaHotel = new DAOOfertaHotel(); daoOfertaHotel.setConn(conn);
	//			return (long) (precio*((calcularDiasEntreDates(reserva.getFechaInicio(), reserva.getFechaFin()))/30));
	//			}	
	//
	//			precio = (Double) precio*(calcularDiasEntreDates(reserva.getFechaInicio(), reserva.getFechaFin()));
	//		}
	//		else {
	//			System.out.println("La reserva se cancelo");
	//			Date today = new Date(System.currentTimeMillis());
	//			if(today.before(reserva.getFechaInicio())) { //si se cancela antes de la fecha de inicio
	//				precio = precio*0.3;
	//			}
	//			else { //si se cancela despues de la fecha de inicio
	//				precio = precio*0.5;
	//			}
	//		}
	//		return (long) precio;
	//	}

	/**
	 * RF5 - Cancelar Reserva. Se cambia el estado de la reserva a cancelado y se actualiza.
	 * @param reserva La reserva que se va a cancelar
	 * @throws SQLException
	 * @throws Exception
	 */
	//	public void cancelarReserva(Reserva reserva) throws SQLException, Exception {
	//		System.out.println("Cancelando reserva con id: " + reserva.getId() + "...");
	//		reserva.setEstado("cancelado");
	//		updateReserva(reserva);
	//		System.out.println("Reserva actualizada exitosamente");
	//	}

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
		String sql = String.format("SELECT * FROM %1$s.Reservas WHERE TIPO_OFERTA = '%2$s' AND ID_OFERTA = %3$d AND ESTADO = 'activa'", USUARIO, tipoOferta, idOferta);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			reservasPotenciales.add(convertResultSetToReserva(rs));
		}
		for(int i = 0; i<reservasPotenciales.size() && disponible; i++) {
			Reserva actual = reservasPotenciales.get(i);
			LocalDate fI = fechaInicio.toLocalDate();
			LocalDate fF = fechaFin.toLocalDate();
			LocalDate actualFechaInicio = actual.getFechaInicio().toLocalDate();
			LocalDate actualFechaFin = actual.getFechaFin().toLocalDate();
			if ((fI.isAfter(actualFechaInicio) && fI.isBefore(actualFechaFin)) || (fF.isBefore(actualFechaFin) && fF.isAfter(actualFechaInicio)) || actualFechaInicio.equals(fI) || actualFechaFin.equals(fF)){
				disponible= false;
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
		System.out.println("Empezando cancelacion de reserva...");
		ArrayList<Reserva> reservas = getReservas();
		for(int i = 0; i<reservas.size(); i++) {
			Reserva actual = reservas.get(i);
			if(actual.getPersona().equals(persona) && actual.getFechaInicio().toLocalDate().compareTo(fechaInicio.toLocalDate()) == 0 && actual.getFechaFin().toLocalDate().compareTo(fechaFin.toLocalDate()) == 0) {
				System.out.println("Se encontro reserva a borrar");
				deleteReserva(actual);
			}
		}
	}
	
	public VORFC12 consultarFuncionamiento()throws SQLException {
		ArrayList<VORFC12OF> ofB = new ArrayList<>();
		ArrayList<VORFC12OF> ofM = new ArrayList<>();
		ArrayList<VORFC12OP> opB = new ArrayList<>();
		ArrayList<VORFC12OP> opM = new ArrayList<>();

		String sql = String.format("SELECT SEMANA, DEMANDA, ID_OFERTA " + 
				"FROM (SELECT t.*, row_number() OVER (PARTITION BY SEMANA ORDER BY DEMANDA DESC) as seqnum " + 
				"      FROM (SELECT to_number(to_char(to_date(FECHA_INICIO,'DD/MM/YYYY'),'WW')) AS SEMANA,COUNT(ID_OFERTA) AS DEMANDA,ID_OFERTA " + 
				"            FROM RESERVAS " + 
				"            GROUP BY ID_OFERTA,to_number(to_char(to_date(FECHA_INICIO,'DD/MM/YYYY'),'WW')) " + 
				"            ORDER BY DEMANDA desc)t)t " + 
				"WHERE seqnum = 1",USUARIO2);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println("-----------------B1------------------");
		while (rs.next()) {
			ofB.add(convertResultSetToVORFC12OF(rs));
		}
		
		System.out.println("-----------------P1------------------");
		
		sql = String.format("SELECT SEMANA, DEMANDA, ID_OFERTA " + 
				"FROM (SELECT t.*, row_number() OVER (PARTITION BY SEMANA ORDER BY DEMANDA asc) as seqnum " + 
				"      FROM (SELECT to_number(to_char(to_date(FECHA_INICIO,'DD/MM/YYYY'),'WW')) AS SEMANA,COUNT(ID_OFERTA) AS DEMANDA,ID_OFERTA " + 
				"            FROM RESERVAS " + 
				"            GROUP BY ID_OFERTA,to_number(to_char(to_date(FECHA_INICIO,'DD/MM/YYYY'),'WW')) " + 
				"            ORDER BY DEMANDA asc)t)t " + 
				"WHERE seqnum = 1",USUARIO2);
		prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();
		while (rs.next()) {
			ofM.add(convertResultSetToVORFC12OF(rs));
		}
		
		System.out.println("-----------------P2------------------");

		
		/**String sql1 = String.format("SELECT t2.SEMANA, t2.DEMANDA, t2.ID_OPERADOR  \r\n" + 
				"				FROM (SELECT t1.*, row_number() OVER (PARTITION BY t1.SEMANA ORDER BY t1.DEMANDA DESC) AS seqnum  \r\n" + 
				"				FROM (SELECT to_number(to_char(to_date(r1.FECHA_INICIO,'DD/MM/YYYY'),'WW')) AS SEMANA,COUNT(o1.ID_OPERADOR) AS DEMANDA,o1.ID_OPERADOR   \r\n" + 
				"				FROM (OFERTAS o1 INNER JOIN RESERVAS r1  \r\n" + 
				"				ON o1.ID_OFERTA = r1.ID_OFERTA) \r\n" + 
				"				GROUP BY to_number(to_char(to_date(r1.FECHA_INICIO,'DD/MM/YYYY'),'WW')), o1.ID_OPERADOR \r\n" + 
				"				ORDER BY DEMANDA desc)t1)t2  \r\n" + 
				"				WHERE seqnum = 1");
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		recursos.add(prepStmt1);
		ResultSet rs1 = prepStmt1.executeQuery();
		System.out.println("-----------------B2------------------");
		while (rs1.next()) {
			opB.add(convertResultSetToVORFC12OP(rs1));
		}
		
		System.out.println("-----------------P3------------------");

		
		sql = String.format("SELECT SEMANA, DEMANDA, ID_OPERADOR " + 
				"FROM (SELECT t.*, row_number() OVER (PARTITION BY SEMANA ORDER BY DEMANDA ASC) as seqnum " + 
				"      FROM (SELECT to_number(to_char(to_date(r1.FECHA_INICIO,'DD/MM/YYYY'),'WW')) AS SEMANA,COUNT(o1.ID_OPERADOR) AS DEMANDA,o1.ID_OPERADOR " + 
				"            FROM(%1$s.OFERTAS o1 INNER JOIN %1$s.RESERVAS r1 " + 
				"            ON o1.ID_OFERTA = r1.ID_OFERTA) " + 
				"            GROUP BY to_number(to_char(to_date(r1.FECHA_INICIO,'DD/MM/YYYY'),'WW')), o1.ID_OPERADOR " + 
				"            ORDER BY DEMANDA ASC)t)t " + 
				"WHERE seqnum = 1",USUARIO2);
		prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();
		while (rs.next()) {
			opM.add(convertResultSetToVORFC12OP(rs));
		}**/
		
		VORFC12 resp = new VORFC12(ofB,ofM,opB,opM);
		
		return resp;
		
	}
	
	public VORFC12OF convertResultSetToVORFC12OF(ResultSet resultSet)throws SQLException {

		Long semana = resultSet.getLong("SEMANA");
		Long demanda = resultSet.getLong("DEMANDA");
		Long id_oferta = resultSet.getLong("ID_OFERTA");

		VORFC12OF res = new VORFC12OF(semana, demanda, id_oferta);

		return res;
	}
	
	public VORFC12OP convertResultSetToVORFC12OP(ResultSet resultSet)throws SQLException {

		Long semana = resultSet.getLong("SEMANA");
		Long demanda = resultSet.getLong("DEMANDA");
		Long id_operador = resultSet.getLong("ID_OPERADOR");

		VORFC12OP res = new VORFC12OP(semana, demanda, id_operador);

		return res;
	}




	public Reserva convertResultSetToReserva(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("ID");
		Long idOferta = resultSet.getLong("ID_OFERTA");
		Date afiliacion = resultSet.getDate("FECHA_RESERVA");
		Date fechaInicio = resultSet.getDate("FECHA_INICIO");
		Date fechaFin = resultSet.getDate("FECHA_FIN");
		Date fechaOportuna = resultSet.getDate("FECHA_OPORTUNA");
		Long costoCalculado = resultSet.getLong("COSTO_CALCULADO");
		String estado = resultSet.getString("ESTADO");
		Long persona = resultSet.getLong("PERSONA");

		Reserva res = new Reserva(id, idOferta, afiliacion, fechaInicio, fechaFin, fechaOportuna, costoCalculado, estado, persona);

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
