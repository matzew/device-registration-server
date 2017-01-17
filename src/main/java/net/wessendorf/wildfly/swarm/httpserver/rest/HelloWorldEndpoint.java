package net.wessendorf.wildfly.swarm.httpserver.rest;

import org.jboss.aerogear.unifiedpush.api.Installation;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/registry/device")
public class HelloWorldEndpoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGet() {
		return Response.ok(Json.createObjectBuilder()
		.add("status", "submitted")
		.add("date", new Date().toString()).build())
				.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerInstallation(
			@DefaultValue("") @HeaderParam("x-ag-old-token") final String oldToken,
			Installation entity,
			@Context HttpServletRequest request) {

		// do

		return Response.ok(entity).build();
	}
}