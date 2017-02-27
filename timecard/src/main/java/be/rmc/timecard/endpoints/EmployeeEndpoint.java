package be.rmc.timecard.endpoints;

import be.rmc.timecard.entities.Employee;
import be.rmc.timecard.repositories.EmployeeRespository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Component
@Path("/employee")
@Api(value = "/employee", description = "Employees")
public class EmployeeEndpoint {

    private final EmployeeRespository empRepo;

    @Autowired public EmployeeEndpoint(EmployeeRespository empRepo) {
        this.empRepo = empRepo;
    }

    @GET
    @ApiOperation( value = "GET employee", notes = "Gets employee by user name")
    @Path("/{username}")
    @Produces("application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "User not found") })
    public Response getEmployeeByUserName(@ApiParam(value = "name to search on", required = true)
                                              @PathParam("username") String username) {
        Collection<Employee> emps = empRepo.findByUserName(username);
        if (emps.isEmpty()) {
            throw new WebApplicationException("User name not found", 404);
        }
        return Response.ok().entity(empRepo.findByUserName(username)).build();
    }

    @POST
    @ApiOperation( value = "create employee", notes = "create an employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response createEmployee(Employee emp) {
        empRepo.save(emp);
        return Response.ok().entity(emp).build();
    }

    @GET
    @ApiOperation(value ="GET all employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEmployees() {
        return Response.ok().entity(empRepo.findAll()).build();
    }
}
