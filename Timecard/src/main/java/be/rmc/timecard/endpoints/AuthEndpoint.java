package be.rmc.timecard.endpoints;

import be.rmc.timecard.entities.Employee;
import be.rmc.timecard.security.AccountCredentials;
import io.swagger.annotations.*;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by scleys on 3/21/17.
 */
@Component
@Path("/login")
@Api(value = "/login", description = "login")
public class AuthEndpoint {
    @POST
    @ApiOperation( value = "get token", notes = "get token based on login")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok",
                    responseHeaders = @ResponseHeader(name = "Authorization", description = "JWT token")),
            @ApiResponse(code = 401, message = "Unauthorized")
          })
    public Response getToken(AccountCredentials act) {
        return Response.ok().build();
    }
}
