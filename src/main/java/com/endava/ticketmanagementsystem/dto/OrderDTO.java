package com.endava.ticketmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer eventId;
    private Date timestamp;
    private Integer ticketCategoryId;
    private Integer numberOfTickets;
    private Integer totalPrice;
}
