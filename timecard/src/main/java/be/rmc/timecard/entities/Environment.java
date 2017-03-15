package be.rmc.timecard.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;


@Entity
public class Environment implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, nullable = false, updatable = false)
    private UUID envId;
    @Column(unique=true,nullable = false)
    private String name;
    @Column(nullable = false)
    private String hostName;
    @Column(nullable = false)
    private String release;
    private String userName;
    private String password;
    @Column(name = "createdAt", updatable = false)
    private Date createdAt;
    @ManyToMany(mappedBy = "environments")
   private Set <User> users;

    private Environment() {}


}
