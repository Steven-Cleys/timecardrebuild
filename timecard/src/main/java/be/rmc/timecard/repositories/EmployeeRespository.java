package be.rmc.timecard.repositories;


import be.rmc.timecard.entities.Employee;
import be.rmc.timecard.entities.Timecard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface EmployeeRespository extends JpaRepository<Employee,Long> {

    Collection<Employee> findByUserName (String rn);

}
