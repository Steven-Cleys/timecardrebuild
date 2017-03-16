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
public class Template implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, nullable = false, updatable = false)
    private UUID templateId;

    @Column(unique=true,nullable = false)
    private String name;

    private UUID refId;

    private boolean active;

    private String release;

    private String webserviceType;

    private String hostURL;

    private String schema;

    @Column(name = "createdAt", updatable = false)
    private Date createdAt;

    @Column(name = "expireDate")
    private Date expireDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "template_module", joinColumns = @JoinColumn(name = "template_id"), inverseJoinColumns = @JoinColumn(name = "mod_id"))
    private Set<Module> modules;

    private Template() {}
}
