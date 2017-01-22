package net.wessendorf.wildfly.swarm.httpserver.rest;

import org.jboss.aerogear.unifiedpush.api.Installation;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Logger;

@Path("/registry/device")
public class DeviceRegistryResource {

	private final Logger logger = Logger.getLogger(DeviceRegistryResource.class.getName());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGet() {

		String addr = "";
		InetAddress IP= null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		addr =  IP.getHostAddress();

		logger.severe("call landed on: " +addr);


		return Response.ok(Json.createObjectBuilder()
		.add("status-srv", addr)
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