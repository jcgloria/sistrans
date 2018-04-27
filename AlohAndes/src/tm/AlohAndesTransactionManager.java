package tm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import dao.DAOGustan;
import dao.DAOOfertaHostal;
import dao.DAOOfertaHotel;
import dao.DAOPersona;
import dao.DAOReserva;
import dao.DAOServicio;
import vos.OfertaHotel;
import vos.Persona;
import vos.Reserva;
import vos.ReservaColectiva;
import vos.Servicio;

public class AlohAndesTransactionManager {

	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	private static String CONNECTION_DATA_PATH;

	private String user;

	private String password;

	private String url;

	private String driver;

	private Connection conn;

	public AlohAndesTransactionManager(String contextPathP) {

		try {
			CONNECTION_DATA_PATH = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
			initializeConnectionData();
		} 
		catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initializeConnectionData() throws IOException, ClassNotFoundException {

		FileInputStream fileInputStream = new FileInputStream(new File(AlohAndesTransactionManager.CONNECTION_DATA_PATH));
		Properties properties = new Properties();

		properties.load(fileInputStream);
		fileInputStream.close();

		this.url = properties.getProperty("url");
		this.user = properties.getProperty("usuario");
		this.password = properties.getProperty("clave");
		this.driver = properties.getProperty("driver");

		//Class.forName(driver);
	}

	private Connection darConexion() throws SQLException {
		System.out.println("[ALOHANDES APP] Attempting Connection to: " + url + " - By User: " + user);
		return DriverManager.getConnection(url, user, password);
	}

	public List<Persona> getAllPersonas() throws Exception {
		DAOPersona daoPersona = new DAOPersona();
		List<Persona> personas;
		try 
		{
			this.conn = darConexion();
			daoPersona.setConn(conn);
			personas = daoPersona.getPersonas();
		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoPersona.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return personas;
	}

	public List<Reserva> getAllReservas() throws Exception {
		DAOReserva daoReserva = new DAOReserva();
		List<Reserva> reservas;
		try 
		{
			this.conn = darConexion();
			daoReserva.setConn(conn);
			reservas = daoReserva.getReservas();
		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoReserva.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return reservas;
	}

	public Persona getPersonaById(Long id) throws Exception {
		DAOPersona daoPersona = new DAOPersona();
		Persona persona = null;
		try 
		{
			this.conn = darConexion();
			daoPersona.setConn(conn);
			persona = daoPersona.findPersonaById(id);
			if(persona == null)
			{
				throw new Exception("La persona con el id = " + id + " no se encuentra persistido en la base de datos.");				
			}
		} 
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoPersona.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return persona;
	}
	
	public OfertaHotel getOfertaHotelById(Long id) throws Exception {
		DAOOfertaHotel daoOfertaHotel = new DAOOfertaHotel();
		OfertaHotel oferta = null;
		try 
		{
			this.conn = darConexion();
			daoOfertaHotel.setConn(conn);
			oferta = daoOfertaHotel.findOfertaHotelById(id);
			if(oferta == null)
			{
				throw new Exception("La persona con el id = " + id + " no se encuentra persistido en la base de datos.");				
			}
		} 
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoOfertaHotel.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return oferta;
	}

	public void addPersona(Persona persona) throws Exception 
	{

		DAOPersona daoPersona = new DAOPersona( );
		try
		{
			this.conn = darConexion();
			daoPersona.setConn(conn);


			daoPersona.addPersona(persona);

		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoPersona.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updatePersona(Persona persona) throws Exception 
	{
		DAOPersona daoPersona = new DAOPersona( );
		try
		{
			this.conn = darConexion();
			daoPersona.setConn( conn );

			if( daoPersona.findPersonaById(persona.getId()) == null) {
				throw new Exception("No existe un bebedor con este id");
			}
			else {
				daoPersona.updatePersona(persona);

			}

		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoPersona.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	public void deletePersona(Persona persona) throws Exception 
	{
		DAOPersona daoPersona = new DAOPersona( );
		try
		{
			this.conn = darConexion();
			daoPersona.setConn( conn );
			if(daoPersona.findPersonaById(persona.getId()) == null) {
				throw new Exception("No existe una persona con este id");
			}
			else {
				daoPersona.deletePersona(persona);
			}
		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoPersona.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}
	/**
	 * Busca las ofertas que le sirvan a una persona.
	 * @param persona
	 */
	public ArrayList<Servicio> buscarOfertasParaPersona(Persona persona) throws Exception{
		DAOGustan daoGustan = new DAOGustan();
		DAOServicio daoServicios = new DAOServicio();

		try
		{
			this.conn = darConexion();
			daoGustan.setConn( conn );
			ArrayList<String> servicios = daoGustan.darServiciosDeUnaPersona(persona); //buscando servicios del usuario
			daoServicios.setConn(conn);
			ArrayList<Servicio> serviciosOferta = daoServicios.getServicios(); //obtener servicios de las ofertas
			ArrayList<Servicio> serviciosOfertaFiltrado = new ArrayList<Servicio>(); //lista donde se almacenan ofertas con los servicios que le sirven a un usuario
			for(int i = 0; i<servicios.size(); i++) {
				for(int j = 0; j<serviciosOferta.size(); j++) {
					if(servicios.get(i).equals(serviciosOferta.get(j).getNomServicio())) {
						serviciosOfertaFiltrado.add(serviciosOferta.get(j));
					}
				}
			}

			return serviciosOfertaFiltrado;

		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoGustan.cerrarRecursos();
				daoServicios.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	/**
	 * RF7 - Intenta hacer una reserva colectiva a partir de las especificaciones del usuario.
	 * @param reservaColectiva
	 * @throws Exception si no hay suficientes reservas con las especificaciones solicitadas
	 */
	public void solicitarReservaColectiva(ReservaColectiva reservaColectiva) throws Exception {
		System.out.println("RESERVA COLECTIVA EMPEZADA");
		ArrayList<Servicio> ofertasConServicios = buscarOfertasParaPersona(getPersonaById(reservaColectiva.getPersona()));
		ArrayList<Long> ofertasQueSonDeHotel = new ArrayList<Long>();
		for(int i = 0; i<ofertasConServicios.size(); i++) {
			if(ofertasConServicios.get(i).getTipoOferta().equals("hotel")) { //filtrar por las que son de hotel
				ofertasQueSonDeHotel.add(ofertasConServicios.get(i).getIdOferta());
			}
		}

		ArrayList<Long> ofertasPotenciales = new ArrayList<Long>(); 
		DAOOfertaHotel daoOfertaHotel = new DAOOfertaHotel();
		this.conn = darConexion();
		daoOfertaHotel.setConn(conn);
		for(int i = 0; i<ofertasQueSonDeHotel.size(); i++) {
			if(daoOfertaHotel.findOfertaHotelById(ofertasQueSonDeHotel.get(i)).getTipoHabitacion().trim().equals(reservaColectiva.getTipoHabitacion().trim())){ //filtrar por tipo de habitacion
				ofertasPotenciales.add(ofertasQueSonDeHotel.get(i));
			}
		}
		

		DAOReserva daoReserva = new DAOReserva();
		this.conn = darConexion();
		daoReserva.setConn(conn);
		try
		{	
			ArrayList<Long> ofertas = new ArrayList<Long>();
			this.conn = darConexion();
			daoReserva.setConn( conn );
			for(int i = 0; i<ofertasPotenciales.size(); i++) {
				if(daoReserva.consultarDisponibilidad("hotel", ofertasPotenciales.get(i), reservaColectiva.getFechaInicio(), reservaColectiva.getFechaFin())) {
					ofertas.add(ofertasPotenciales.get(i));
					System.out.println("se encontro disponible");
				}
			}
			System.out.println("NUMERO DE OFERTAS ENCONTRADAS: " + ofertas.size());
			if(ofertas.size() < reservaColectiva.getCantidad()) {
				throw new Exception("No hay suficientes habitaciones disponibles con las especificaciones solicitadas");
			}
			else {
				System.out.println("Si hay reservas suficientes, reservando...");
				int contador = 0;
				while(contador < reservaColectiva.getCantidad()) {
					daoReserva.agregarReserva(reservaColectiva.getFechaInicio(), reservaColectiva.getFechaFin(), "hotel", ofertas.get(contador), reservaColectiva.getPersona());				
					contador++;
					System.out.println("Se agrego reserva. Total: " + contador);
				}
				System.out.println("Reserva colectiva exitosa");
			}

		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoOfertaHotel.cerrarRecursos();
				daoReserva.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}	
	}

	/**
	 * RF8 - Cancela una reserva colectiva existente
	 * @param reservaColectiva
	 * @throws SQLException
	 * @throws Exception
	 */
	public void cancelarReservaColectiva(ReservaColectiva reservaColectiva) throws SQLException, Exception{
		DAOReserva daoReserva = new DAOReserva();
		try 
		{
			this.conn = darConexion();
			daoReserva.setConn(conn);
			daoReserva.cancelarReservaPersonaYFechas(reservaColectiva.getPersona(), reservaColectiva.getFechaInicio(), reservaColectiva.getFechaFin());
		}
		catch (SQLException sqlException) {
			System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
			sqlException.printStackTrace();
			throw sqlException;
		} 
		catch (Exception exception) {
			System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try {
				daoReserva.cerrarRecursos();
				if(this.conn!=null){
					this.conn.close();					
				}
			}
			catch (SQLException exception) {
				System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	/**
	 * RF9 - Deshabilitar Oferta de AlohAndes.
	 * @throws Exception 
	 */
	public void deshabilitarOferta(String tipoOferta, Long idOferta) throws Exception {
		{
			DAOOfertaHotel daoOfertaHotel = new DAOOfertaHotel();
			DAOOfertaHostal daoOfertaHostal = new DAOOfertaHostal();
			try
			{
				this.conn = darConexion();
				if(tipoOferta.equals("hotel")) {
					daoOfertaHotel.setConn(conn);
					daoOfertaHotel.deshabilitarOferta(idOferta);
				}
				else if(tipoOferta.equals("hostal")) {
					this.conn = darConexion();
					daoOfertaHostal.setConn(conn);
					daoOfertaHostal.deshabilitarOferta(idOferta);
				}
			}

			catch (SQLException sqlException) {
				System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
				sqlException.printStackTrace();
				throw sqlException;
			} 
			catch (Exception exception) {
				System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			} 
			finally {
				try {
					daoOfertaHotel.cerrarRecursos();
					daoOfertaHostal.cerrarRecursos();
					if(this.conn!=null){
						this.conn.close();					
					}
				}
				catch (SQLException exception) {
					System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
					exception.printStackTrace();
					throw exception;
				}
			}
		}
	}
	/**
	 * RF10 - Habilitar Oferta de AlohAndes.
	 * @throws Exception 
	 */
	public void habilitarOferta(String tipoOferta, Long idOferta) throws Exception {
		{
			DAOOfertaHotel daoOfertaHotel = new DAOOfertaHotel();
			DAOOfertaHostal daoOfertaHostal = new DAOOfertaHostal();
			try
			{
				this.conn = darConexion();
				if(tipoOferta.equals("hotel")) {
					daoOfertaHotel.setConn(conn);
					daoOfertaHotel.habilitarOferta(idOferta);
				}
				else if(tipoOferta.equals("hostal")) {
					this.conn = darConexion();
					daoOfertaHostal.setConn(conn);
					daoOfertaHostal.habilitarOferta(idOferta);
				}
			}

			catch (SQLException sqlException) {
				System.err.println("[EXCEPTION] SQLException:" + sqlException.getMessage());
				sqlException.printStackTrace();
				throw sqlException;
			} 
			catch (Exception exception) {
				System.err.println("[EXCEPTION] General Exception:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			} 
			finally {
				try {
					daoOfertaHotel.cerrarRecursos();
					daoOfertaHostal.cerrarRecursos();
					if(this.conn!=null){
						this.conn.close();					
					}
				}
				catch (SQLException exception) {
					System.err.println("[EXCEPTION] SQLException While Closing Resources:" + exception.getMessage());
					exception.printStackTrace();
					throw exception;
				}
			}
		}
	}

}
