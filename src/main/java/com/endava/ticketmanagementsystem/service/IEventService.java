package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.model.Event;

import java.util.List;

public interface IEventService {
    List<Event> getEventsByVenueAndType(Integer venueId, String eventType);
    List<Event> getAllEvents();
}
