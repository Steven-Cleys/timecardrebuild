package be.rmc.timecard.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by scleys on 3/16/17.
 */

@Entity
public class ProcessHistory {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "fk_template_id")
    private Template template;

    @ManyToOne()
    @JoinColumn(name = "fk_env_id")
    private Environment environment;

    @ManyToOne()
    @JoinColumn(name = "fk_mod_id")
    private Module module;


    private Date completionDate;

}
