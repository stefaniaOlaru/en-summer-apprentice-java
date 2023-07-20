package com.endava.ticketmanagementsystem.repository;

import com.endava.ticketmanagementsystem.model.Event;
import com.endava.ticketmanagementsystem.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    //i want to find all events by venue id and event type name
    List<Event> findEventsByVenueIdAndEventTypeName(Integer venueId, String eventTypeName);
    List<Event> findAll();
}
