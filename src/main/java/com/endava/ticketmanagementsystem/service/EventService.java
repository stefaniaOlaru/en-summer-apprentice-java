package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.dto.EventDTO;
import com.endava.ticketmanagementsystem.dto.TicketCategoryDTO;
import com.endava.ticketmanagementsystem.model.Event;
import com.endava.ticketmanagementsystem.model.TicketCategory;
import com.endava.ticketmanagementsystem.repository.EventRepository;
import com.endava.ticketmanagementsystem.repository.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements IEventService{
 @Autowired
 private EventRepository eventRepository;

 @Autowired
 private TicketCategoryRepository ticketCategoryRepository;

    @Override
    public List<Event> getEventsByVenueAndType(Integer venueId, String eventType) {
        return eventRepository.findEventsByVenueIdAndEventTypeName(venueId,eventType);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public EventDTO transformEvent(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setVenue(event.getVenue());
        eventDTO.setType(event.getEventType().getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setName(event.getName());
        eventDTO.setStartDate(event.getStartDate());
        eventDTO.setEndDate(event.getEndDate());
        List <TicketCategory> ticketCategories = ticketCategoryRepository.findTicketCategoriesByEventId(event.getId());
        List <TicketCategoryDTO> ticketCategoriesDTO = new ArrayList<>();
        for(int i = 0; i < ticketCategories.size(); i++){
            TicketCategoryDTO temp = new TicketCategoryDTO();
            temp.setId(ticketCategories.get(i).getId());
            temp.setDescription(ticketCategories.get(i).getDescription());
            temp.setPrice(ticketCategories.get(i).getPrice());
            ticketCategoriesDTO.add(temp);
        }
        eventDTO.setTicketCategories(ticketCategoriesDTO);
        return eventDTO;
    }

}
