package com.endava.ticketmanagementsystem.controller;

import com.endava.ticketmanagementsystem.dto.OrderDTO;
import com.endava.ticketmanagementsystem.dto.OrderRequestDTO;
import com.endava.ticketmanagementsystem.dto.OrderResponseDTO;
import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.User;
import com.endava.ticketmanagementsystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/api/getorders")
    public List<OrderDTO> getAllOrders( ) {
        User user = new User();
        user.setId(3);
        List < OrderDTO> orders = ordersService.transformOrders(ordersService.getOrdersByUser(user));
        return orders;
    }

    @PostMapping("/api/saveorder")
    public OrderResponseDTO saveOrder(@RequestBody OrderRequestDTO orderRequest){

        Orders order = ordersService.saveOrder(orderRequest);
        return ordersService.transformOrderResponse(orderRequest.getEventId(),order);
    }

}
