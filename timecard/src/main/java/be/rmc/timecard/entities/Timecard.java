package be.rmc.timecard.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Entity
public class Timecard {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    private LocalDate entrydate;

    private String status;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Timecard() {  //yes its required
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(LocalDate entrydate) {
        entrydate = entrydate;
    }

    @Override
    public String toString() {
        return "Timecard{" +
                "id=" + id +
                ", userId='" + employee.toString() + '\'' +
                '}';
    }
}
