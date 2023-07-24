package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.model.Event;
import com.endava.ticketmanagementsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService{
 @Autowired
 private EventRepository eventRepository;

    @Override
    public List<Event> getEventsByVenueAndType(Integer venueId, String eventType) {
        return eventRepository.findEventsByVenueIdAndEventTypeName(venueId,eventType);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
