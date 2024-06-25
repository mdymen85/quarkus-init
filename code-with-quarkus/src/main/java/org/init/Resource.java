package org.init;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
@Slf4j
public class Resource {

    @Inject
    private TestService testService;

    @Inject
    private ExecutorTestsService executorTestsService;

    @Inject
    HttpHeaders httpHeaders;

    @Inject
    @RestClient
    Client client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        log.info("before sending to client");
        client.clientTest();
        log.info("after sending to client");
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path(("/test"))
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {
        httpHeaders.getRequestHeaders().keySet()
                        .stream()
                                .forEach(http -> {
                                    log.info("key {}, value {}", http, httpHeaders.getHeaderString(http));
                                });
        log.info("this is the client");
        return "Hello from RESTEasy Reactive";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TestObject test(TestObject testObject) {
        return testService.setDateTime(testObject);
    }

    @POST
    @Path("/executor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void executor() throws InterruptedException {
        this.executorTestsService.execute();
    }

}
