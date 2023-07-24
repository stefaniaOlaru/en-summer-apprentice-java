package com.endava.ticketmanagementsystem.repository;

import com.endava.ticketmanagementsystem.dto.TicketCategoryDTO;
import com.endava.ticketmanagementsystem.model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Integer> {
   // Integer findPriceById(Integer ticketCategoryId);
    List<TicketCategory> findTicketCategoriesByEventId(Integer eventId);
    TicketCategory findTicketCategoryById(Integer ticketCategoryId);
}
