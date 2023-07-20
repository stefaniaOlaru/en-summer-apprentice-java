package com.endava.ticketmanagementsystem.repository;

import com.endava.ticketmanagementsystem.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findOrderByUserId(Integer userId);
}
