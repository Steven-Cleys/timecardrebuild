package be.rmc.timecard.endpoints;

import be.rmc.timecard.entities.Employee;
import be.rmc.timecard.repositories.EmployeeRespository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/employee")
@Api(value = "/employee", description = "Employees")
public class EmployeeEndpoint {

    private final EmployeeRespository empRepo;

    @Autowired public EmployeeEndpoint(EmployeeRespository empRepo) {
        this.empRepo = empRepo;
    }

    @GET
    @ApiOperation( value = "GET employee", notes = "Shows the world from hello world")
    @Produces("application/json")
    public Response test() {
        return Response.ok("{\"Success\":\"Hello World\"}").build();
    }

    @POST
    @ApiOperation( value = "create employee", notes = "create an employee")
    @Produces("application/json")
    public Response createEmployee(Employee emp) {
        empRepo.save(emp);
        return Response.ok().entity(emp).build();
    }
}
