package be.rmc.timecard.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Entity
public class Timecard {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;
    private String userName;

    Timecard() {  //yes its required
    }

    public Timecard(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Timecard{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
