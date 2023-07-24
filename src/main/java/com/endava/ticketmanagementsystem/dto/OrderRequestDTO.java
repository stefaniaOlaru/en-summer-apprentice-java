package com.endava.ticketmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    private Integer eventId;
    private Integer ticketCategoryId;
    private Integer numberOfTickets;
}
