package be.rmc.timecard.endpoints;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by cleysst on 27/09/2016.
 */

//example endpoint
@Component
@Path("/hello")
@Api(value = "/hello", description = "this is the hello from the hello world")
public class HelloWorldEndpoint {

    @GET
    @Path("/world")
    @ApiOperation(value = "/world",
            notes = "Shows the world from hello world")
    @Produces("application/json")
    public Response test() {
        return Response.ok("{\"Success\":\"Hello World\"}").build();
    }
}