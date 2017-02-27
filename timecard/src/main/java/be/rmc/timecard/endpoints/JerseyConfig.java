package be.rmc.timecard.endpoints;

// add jersey jax-rs to spring config
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * This class configures JAX-RS to build restservices instead of default spring.
 * Why? Because I can.
 * Also includes swagger configuration with jax-rs
 */
//@Configuration
@Component
@ApplicationPath("/api") //http://stackoverflow.com/questions/35170462/spring-boot-not-serving-static-content-when-jersey-rest-is-included
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
        configureSwagger();
    }

    /**
     * Configures swagger with this application.
     * Note: the base/application path is required.
     * If you want to resolve the swagger with the attached UI you might need to change the url found in swagger/index.html
     */
    private void configureSwagger() {

        register(ApiListingResource.class); //Swagger
        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api"); //match application path for swagger UI
        beanConfig.setResourcePackage("be.rmc.timecard.endpoints");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }

    /**
     * All endpoints needs to be registered here.
     */
    private void registerEndpoints() { //register endpoints here
        //register(WadlResource.class); //wadl

        register(HelloWorldEndpoint.class);
        register(EmployeeEndpoint.class);
        register(TimecardEndpoint.class);
    }
}