package com.endava.ticketmanagementsystem.controller;

import com.endava.ticketmanagementsystem.model.Event;
import com.endava.ticketmanagementsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

//    public EventController(EventService eventService) {
//        this.eventService = eventService;
//    }

    @GetMapping("/api/events")
    public List<Event> getEvents(@RequestParam Integer venueId, @RequestParam String eventType) {
        List<Event> events = eventService.getEventsByVenueAndType(venueId, eventType);
        return events;
    }
}
