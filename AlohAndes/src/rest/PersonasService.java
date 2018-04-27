package rest;

import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.AlohAndesTransactionManager;
import vos.Persona;

@Path("personas")
public class PersonasService {

	@Context
	private ServletContext context;

	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}

	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPersonas() {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());

			List<Persona> personas;
			personas = tm.getAllPersonas();
			return Response.status(200).entity(personas).build();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@GET
	@Path( "{id: \\d+}" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getPersonaById( @PathParam( "id" ) Long id )
	{
		try{
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager( getPath( ) );

			Persona persona = tm.getPersonaById( id );
			return Response.status( 200 ).entity( persona ).build( );			
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPersona(Persona persona) {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());
			tm.addPersona(persona);
			return Response.status( 200 ).entity( persona ).build( );
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePersona(Persona persona) {
		AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());
		try {
			tm.updatePersona(persona);
			return Response.status( 200 ).entity( persona ).build( );
		} catch (Exception e) {
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePersona(Persona persona) {
		AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());
		try {
			tm.deletePersona(persona);
			return Response.status( 200 ).entity( persona ).build( );
		} catch (Exception e) {
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
}
