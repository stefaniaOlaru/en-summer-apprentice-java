package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.User;
import com.endava.ticketmanagementsystem.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersService implements IOrdersService{

    @Autowired
    private OrdersRepository ordersRepository;
    @Override
    public List<Orders> getOrdersByUser(User user) {
        return ordersRepository.findOrderByUserId(user.getId());
    }
}
