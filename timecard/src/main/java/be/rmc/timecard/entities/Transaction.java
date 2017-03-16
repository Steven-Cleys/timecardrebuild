package be.rmc.timecard.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * Created by scleys on 3/16/17.
 */

@Entity
public class Transaction implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, nullable = false, updatable = false)
    private UUID transId;

    private UUID templateId;

    private UUID userId;

    private boolean success;

    private String attributes;

    @Column(name = "createdAt", updatable = false)
    private Date createdAt;

    private Transaction() {}
}
