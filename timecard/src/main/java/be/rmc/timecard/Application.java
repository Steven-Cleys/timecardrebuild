package be.rmc.timecard;


import be.rmc.timecard.entities.Employee;
import be.rmc.timecard.entities.Timecard;
import be.rmc.timecard.repositories.EmployeeRespository;
import be.rmc.timecard.repositories.TimecardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Arrays;

/**
 * All the magic starts here with @SpringBootApplication
 * This class with start spring boot and the service
 */
@SpringBootApplication //also include all files and packages under this directory
//following annotations might not be required, not sure yet.
@EntityScan(basePackages = { //models
		"be.rmc.timecard.entities"
})
@EnableJpaRepositories(basePackages = { //repository
		"be.rmc.timecard.repositories"
})
@ComponentScan(basePackages = "be.rmc.timecard.endpoints")

public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//just some testing, following code will get executed on startup
	@Bean
	CommandLineRunner runner(TimecardRepository tcr, EmployeeRespository er) { //some testing code
		return args -> {
/*			Arrays.asList("test,test3,test15".split(","))
					.forEach((n -> tcr.save(new Timecard(n))));

			tcr.findAll().forEach(r -> System.out.println("r = " + r));
			tcr.findByUserName("test15").forEach(r -> System.out.println("r = " + r));*/
			er.save(new Employee("SCleys","steven","cleys","stevencleys@gmail.com"));
			Employee emp = er.findOne(1L);
			System.out.println("emp.toString() = " + emp.toString());
			emp.setFirstName("test");
			er.save(emp);
			System.out.println("emp.toString() = " + emp.toString());
			er.save(new Employee("WDEVOOGHT","Wim","Devooght","wd@gmail.com"));
			er.save(new Employee("dsf","sfsfsdfsd","jhjh","sdflkj@gmail.com"));
			Timecard tc = new Timecard();
			tc.setEmployee(er.findByUserName("SCleys").stream().findFirst().get());
			tcr.save(tc);
		};
	}
}
