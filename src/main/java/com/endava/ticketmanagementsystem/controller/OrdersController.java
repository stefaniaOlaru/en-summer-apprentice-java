package com.endava.ticketmanagementsystem.controller;

import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.User;
import com.endava.ticketmanagementsystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/api/orders")
    public List<Orders> getAllOrders( ) {
        User user = new User();
        user.setId(3);
        return ordersService.getOrdersByUser(user);
    }
}
