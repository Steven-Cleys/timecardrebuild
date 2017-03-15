package be.rmc.timecard.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * Created by scleys on 3/15/17.
 */

@Entity
@Table(name = "TUSER")
public class User implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, nullable = false, updatable = false)
    private UUID userId;
    @Column(unique=true,nullable = false)
    private String userName;
    private String firstName;
    private String lastName;
    private String userType;
    private String email;
    private String password;
    private String description;
    private String company;
    private boolean active;
    @Column(name = "createdAt", updatable = false)
    private Date createdAt;
    @Column(name = "expireDate")
    private Date expireDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_environment", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "env_id"))
    private Set<Environment> environments;

    private User() {}
}
