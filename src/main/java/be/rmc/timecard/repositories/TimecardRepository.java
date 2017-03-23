package be.rmc.timecard.repositories;

import be.rmc.timecard.entities.Timecard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.UUID;


public interface TimecardRepository extends JpaRepository<Timecard,UUID> {

}