package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.AlohAndesTransactionManager;
import vos.Persona;

@Path("rfc8")
public class RFC8 {

	@Context
	private ServletContext context;

	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}

	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	@GET
	@Path( "{oferta: \\s+}" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response clientesFrecuentes( @PathParam( "oferta" )String oferta) {
		try{
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager( getPath( ) );

			List<Persona> personas;
			personas = tm.clientesFrecuentes("hotel");
			return Response.status( 200 ).entity( personas ).build( );			
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response get() {

		try{
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager( getPath( ) );

			List<Persona> personas;
			personas = tm.clientesFrecuentes("hotel");
			return Response.status( 200 ).entity( personas ).build( );			
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
}
