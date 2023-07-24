package com.endava.ticketmanagementsystem.dto;

import com.endava.ticketmanagementsystem.model.TicketCategory;
import com.endava.ticketmanagementsystem.model.Venue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Integer id;
    private Venue venue;
    private String type;
    private String description;
    private String name;
    private Date startDate;
    private Date endDate;
    private List<TicketCategory> ticketCategories;
}
