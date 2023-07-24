package com.endava.ticketmanagementsystem.controller;

import com.endava.ticketmanagementsystem.dto.EventDTO;
import com.endava.ticketmanagementsystem.dto.TicketCategoryDTO;
import com.endava.ticketmanagementsystem.model.Event;
import com.endava.ticketmanagementsystem.model.TicketCategory;
import com.endava.ticketmanagementsystem.repository.TicketCategoryRepository;
import com.endava.ticketmanagementsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private TicketCategoryRepository ticketCategoryRepository;

//    public EventController(EventService eventService) {
//        this.eventService = eventService;
//    }

    @GetMapping("/api/events")
    public List<EventDTO> getEvents(@RequestParam Integer venueId, @RequestParam String eventType) {
        List<Event> events = eventService.getEventsByVenueAndType(venueId, eventType);
        List<EventDTO> eventDTO = new ArrayList<>();
        for(int i =0 ; i < events.size(); i++){
            eventDTO.add(eventService.transformEvent(events.get(i)));
        }
        return eventDTO;
    }






}
