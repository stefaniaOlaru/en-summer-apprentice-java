package com.endava.ticketmanagementsystem.controller;

import com.endava.ticketmanagementsystem.dto.OrderRequestDTO;
import com.endava.ticketmanagementsystem.dto.OrderResponseDTO;
import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.User;
import com.endava.ticketmanagementsystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/api/saveorder")
    public OrderResponseDTO saveOrder(@RequestBody OrderRequestDTO order){

        Orders orders = ordersService.saveOrder(transformOrderRequest(order));
        return transformOrderResponse(orders);
    }

    public Orders transformOrderRequest(OrderRequestDTO orderDTO){
        Orders order = new Orders();

        return order;
    }

    public OrderResponseDTO transformOrderResponse(Orders order){
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        return orderResponseDTO;
    }
}
