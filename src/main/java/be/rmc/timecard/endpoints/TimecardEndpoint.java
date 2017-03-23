package be.rmc.timecard.endpoints;

import be.rmc.timecard.entities.Employee;
import be.rmc.timecard.entities.Timecard;
import be.rmc.timecard.repositories.EmployeeRespository;
import be.rmc.timecard.repositories.TimecardRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Component
@Path("/timecard")
@Api(value = "/timecard", description = "timecards")
public class TimecardEndpoint {

    private final TimecardRepository tcrRepo;

    @Autowired public TimecardEndpoint(TimecardRepository tcrRepo) {
        this.tcrRepo = tcrRepo;
    }


    @POST
    @ApiOperation( value = "create timecard", notes = "create a timecard")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response createTimecard(Timecard tc) {
        tcrRepo.save(tc);
        return Response.ok().entity(tc).build();
    }

    @GET
    @ApiOperation(value ="GET all timecards")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTimecards() {
        return Response.ok().entity(tcrRepo.findAll()).build();
    }
}
