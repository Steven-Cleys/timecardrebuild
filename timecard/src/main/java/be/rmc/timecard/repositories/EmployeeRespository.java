package be.rmc.timecard.repositories;


import be.rmc.timecard.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRespository extends JpaRepository<Employee,Long> {

}
