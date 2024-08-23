package com.dev.opendelivery.order.repository;

import com.dev.opendelivery.order.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Paramqqqq

import java.time.LocalDateTime;
import java.util.*;

public interface OrderEventRepository extends JpaRepository<Event, UUID> {


    @Query("""
           SELECT e FROM Event e
           LEFT JOIN e.sourceApp o
           WHERE o.id = :sourceAppId
           AND e.id = :id
           """)
    Event findByIdAndSourceAppId(@Param("id") UUID id, @Param("sourceAppId") UUID sourceAppId);


    @Query("""
           SELECT e FROM Event e
           LEFT JOIN e.sourceApp o
           WHERE o.id = :sourceAppId
           AND e.acceptedAt IS NULL AND e.createdAt > :eightHoursAgo
           """)
    List<Event> getEventsNotAcceptedByTheSourceApplication(@Param("sourceAppId") UUID sourceAppId, @Param("eightHoursAgo") LocalDateTime eightHoursAgo);

}
