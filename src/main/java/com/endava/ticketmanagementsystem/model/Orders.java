package com.endava.ticketmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "orders", schema = "ticket_management_system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",columnDefinition="int primary key")
    private Integer id;

    @Column(name = "ordered_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedAt;

    @Column(name = "number_of_tickets")
    private Integer numberOfTickets;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_price")
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name = "ticket_category_id")
    private TicketCategory ticketCategory;

}
