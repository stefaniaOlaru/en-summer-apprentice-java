package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.dto.OrderRequestDTO;
import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.TicketCategory;
import com.endava.ticketmanagementsystem.model.User;
import com.endava.ticketmanagementsystem.repository.OrdersRepository;
import com.endava.ticketmanagementsystem.repository.TicketCategoryRepository;
import com.endava.ticketmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrdersService implements IOrdersService{

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketCategoryRepository ticketCategoryRepository;
    @Override
    public List<Orders> getOrdersByUser(User user) {
        return ordersRepository.findOrderByUserId(user.getId());
    }

    @Override
    public Orders saveOrder(OrderRequestDTO order) {
        Integer userId = 6;
        User user = userRepository.findUserById(userId);
        TicketCategory ticketCategory = ticketCategoryRepository.findTicketCategoryById(order.getTicketCategoryId());
        Integer totalPrice = ticketCategory.getPrice() *
                order.getNumberOfTickets();
        Orders tempOrder = new Orders( new Date(), order.getNumberOfTickets(),
                user, totalPrice,ticketCategory);
        ordersRepository.save(tempOrder);
        return tempOrder;
    }
}
