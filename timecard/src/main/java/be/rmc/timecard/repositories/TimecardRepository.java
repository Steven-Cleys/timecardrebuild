package be.rmc.timecard.repositories;

import be.rmc.timecard.entities.Timecard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface TimecardRepository extends JpaRepository<Timecard,Long> {

    //select * from tc where name = :rn
    //@Query("...")
    Collection<Timecard> findByUserName (String rn);
}