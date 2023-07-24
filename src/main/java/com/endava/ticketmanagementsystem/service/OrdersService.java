package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.model.Orders;
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
    public Orders saveOrder(Orders order) {
        User user = userRepository.findUserById(order.getUser().getId());
        Integer totalPrice = ticketCategoryRepository.findPriceById(order.getTicketCategory().getId()) *
                order.getNumberOfTickets();
        Orders tempOrder = new Orders(order.getId(), new Date(), order.getNumberOfTickets(),
                order.getUser(), totalPrice,order.getTicketCategory());
        ordersRepository.save(tempOrder);
        return tempOrder;
    }
}
