package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.AlohAndesTransactionManager;
import vos.Persona;
import vos.Reserva;
import vos.ReservaColectiva;

/**
 * Servicio encargado de atender las peticiones de las reservas.
 * @author juancg
 *
 */
@Path("reservas")
public class ReservasService {
	
	@Context
	private ServletContext context;

	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}

	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	@POST
	@Path("/masiva")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addReservaColectiva(ReservaColectiva reservaColectiva) {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());
			tm.solicitarReservaColectiva(reservaColectiva);
			return Response.status( 200 ).entity( reservaColectiva ).build( );
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getReservas() {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());

			List<Reserva> reservas;
			reservas = tm.getAllReservas();
			return Response.status(200).entity(reservas).build();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	@DELETE
	@Path("/masiva")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteReservaColectica(ReservaColectiva reservaColectiva) {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());
			tm.cancelarReservaColectiva(reservaColectiva);
			return Response.status( 200 ).entity( reservaColectiva ).build( );
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
}
