package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.User;

import java.util.List;

public interface IOrdersService {
   // List<Orders> getOrdersByUserId(Users user);
    List<Orders> getOrdersByUser(User user);
}
