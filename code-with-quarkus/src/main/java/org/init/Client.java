package org.init;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path(value = "/hello")
@RegisterRestClient(configKey = "resource", baseUri = "http://localhost:8080")
public interface Client {

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    Response clientTest();

}
