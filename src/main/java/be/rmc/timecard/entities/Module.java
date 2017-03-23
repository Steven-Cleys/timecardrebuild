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
public class Module implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, nullable = false, updatable = false)
    private UUID modId;

    @Column(unique=true,nullable = false)
    private String name;

    private String release;

    private boolean active;

    @Column(name = "createdAt", updatable = false)
    private Date createdAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "module_environment", joinColumns = @JoinColumn(name = "mod_id"), inverseJoinColumns = @JoinColumn(name = "env_id"))
    private Set<Environment> environments;

    @ManyToMany(mappedBy = "modules", cascade = CascadeType.ALL)
    private Set <Template> templates;


    private Module() {}

}
