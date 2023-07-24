package com.endava.ticketmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "event_type", schema = "ticket_management_system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_type_id",columnDefinition="int primary key")
    private Integer id;

    @Column(name = "event_type_name")
    private String name;
}
