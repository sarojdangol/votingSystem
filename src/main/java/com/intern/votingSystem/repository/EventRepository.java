package com.intern.votingSystem.repository;

import com.intern.votingSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

    @Query("Select e from Event e order By e.event_id")
    List<Event> getAllEvent();

    @Modifying
    @Query("Delete from Event e where e.event_id=:id")
    void deleteEvent(@Param("id") int id);
}
