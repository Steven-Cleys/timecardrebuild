package be.rmc.timecard.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by scleys on 4/20/17.
 * Implements audit/who columns
 */
@MappedSuperclass
public abstract class BaseEntity {


    @Column(name = "updated_by")
    private String updatedBy;



    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}