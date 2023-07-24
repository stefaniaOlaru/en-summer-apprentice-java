package com.endava.ticketmanagementsystem.controller;

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
    public List<Orders> getAllOrders( ) {
        User user = new User();
        user.setId(3);
        return ordersService.getOrdersByUser(user);
    }

    @PostMapping("/api/saveorder")
    public OrderResponseDTO saveOrder(@RequestBody OrderRequestDTO orderRequest){

        Orders order = ordersService.saveOrder(orderRequest);
        return transformOrderResponse(orderRequest.getEventId(),order);
    }


    public OrderResponseDTO transformOrderResponse(Integer eventId ,Orders order){
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setEventId(eventId);
        orderResponseDTO.setTimestamp(order.getOrderedAt());
        orderResponseDTO.setTicketCategoryId(order.getTicketCategory().getId());
        orderResponseDTO.setNumberOfTickets(order.getNumberOfTickets());
        orderResponseDTO.setTotalPrice(order.getTotalPrice());
        return orderResponseDTO;
    }
}
