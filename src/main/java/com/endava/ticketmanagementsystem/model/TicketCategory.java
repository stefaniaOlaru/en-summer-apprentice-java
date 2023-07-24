package com.endava.ticketmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "ticket_category", schema = "ticket_management_system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_category_id",columnDefinition="int primary key")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name ="price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


}
