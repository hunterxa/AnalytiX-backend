package com.hunterxa.AnalytiX.event;

import com.hunterxa.AnalytiX.event.Event;
import com.hunterxa.AnalytiX.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findByDate(LocalDate date);

    @Query(
            value = "SELECT * FROM events e WHERE e.fk_creator_id = :creatorId",
            nativeQuery = true
    )
    List<Event> findByCreatorId(@Param("creatorId") Long creatorId);
}
