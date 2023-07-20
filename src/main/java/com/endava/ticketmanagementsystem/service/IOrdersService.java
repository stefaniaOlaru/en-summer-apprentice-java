package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.Users;

import java.util.List;

public interface IOrdersService {
   // List<Orders> getOrdersByUserId(Users user);
    List<Orders> getOrdersByUserId(Integer userId);
}
