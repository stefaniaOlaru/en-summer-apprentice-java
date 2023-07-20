package com.endava.ticketmanagementsystem.controller;

import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.Users;
import com.endava.ticketmanagementsystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/api/orders")
    public List<Orders> getAllOrders( ) {
//        Users user = new Users();
//        user.setId(3);
        return ordersService.getOrdersByUserId(3);
    }
}
