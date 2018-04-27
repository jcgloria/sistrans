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
import vos.OfertaHotel;

@Path("ofertahoteles")
public class HotelService {

	@Context
	private ServletContext context;

	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}

	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}

	@GET
	@Path( "{id: \\d+}" )
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getOfertaHotel(@PathParam( "id" ) Long id) {

		try {
			AlohAndesTransactionManager tm = new AlohAndesTransactionManager(getPath());

			
			OfertaHotel ofertaHotel = tm.getOfertaHotelById(id);
			return Response.status(200).entity(ofertaHotel).build();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

}