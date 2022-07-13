package com.hunterxa.AnalytiX.event;

import com.hunterxa.AnalytiX.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.date = ?1")
    Optional<Event> findEventsByDate(LocalDate date);
}
