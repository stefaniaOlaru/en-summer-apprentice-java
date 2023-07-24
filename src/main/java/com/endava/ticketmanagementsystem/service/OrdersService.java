package com.endava.ticketmanagementsystem.service;

import com.endava.ticketmanagementsystem.dto.OrderDTO;
import com.endava.ticketmanagementsystem.dto.OrderRequestDTO;
import com.endava.ticketmanagementsystem.dto.OrderResponseDTO;
import com.endava.ticketmanagementsystem.model.Orders;
import com.endava.ticketmanagementsystem.model.TicketCategory;
import com.endava.ticketmanagementsystem.model.User;
import com.endava.ticketmanagementsystem.repository.OrdersRepository;
import com.endava.ticketmanagementsystem.repository.TicketCategoryRepository;
import com.endava.ticketmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<OrderDTO> transformOrders(List<Orders> orders){
        List<OrderDTO> orderDTO = new ArrayList<>();
        for(int i = 0 ; i < orders.size(); i++){
            OrderDTO temp = new OrderDTO();
            temp.setEventId(orders.get(i).getTicketCategory().getEvent().getId());
            temp.setTimestamp(orders.get(i).getOrderedAt());
            temp.setTicketCategoryId(orders.get(i).getTicketCategory().getId());
            temp.setNumberOfTickets(orders.get(i).getNumberOfTickets());
            temp.setTotalPrice(orders.get(i).getTotalPrice());
            orderDTO.add(temp);
        }
        return orderDTO;
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

    public OrderResponseDTO transformOrderResponse(Integer eventId , Orders order){
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setEventId(eventId);
        orderResponseDTO.setTimestamp(order.getOrderedAt());
        orderResponseDTO.setTicketCategoryId(order.getTicketCategory().getId());
        orderResponseDTO.setNumberOfTickets(order.getNumberOfTickets());
        orderResponseDTO.setTotalPrice(order.getTotalPrice());
        return orderResponseDTO;
    }
}
