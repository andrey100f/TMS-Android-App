package com.example.tms_app.models.mapper;

import com.example.tms_app.config.DateTimeFormat;
import com.example.tms_app.models.Order;
import com.example.tms_app.models.TicketCategory;
import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.order_dto.OrderDto;
import com.example.tms_app.models.dto.order_dto.OrderPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    private final TicketCategoryMapper ticketCategoryMapper;
    private final EventMapper eventMapper;

    @Autowired
    public OrderMapper(TicketCategoryMapper ticketCategoryMapper, EventMapper eventMapper) {
        this.ticketCategoryMapper = ticketCategoryMapper;
        this.eventMapper = eventMapper;
    }

    public OrderDto convertModelToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setOrderedAt(order.getOrderedAt().format(DateTimeFormat.formatter));
        orderDto.setEvent(eventMapper.convertModelToDto(order.getTicketCategory().getEvent()));
        orderDto.setNumberOfTickets(order.getNumberOfTickets());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setTicketCategory(ticketCategoryMapper.convertModelToDto(order.getTicketCategory()));
        return orderDto;
    }

    public Order convertPostDtoToModel(OrderPostDto orderPostDto, TicketCategory ticketCategory, User user) {
        Order order = new Order();
        order.setOrderedAt(LocalDateTime.now());
        order.setUser(user);
        order.setTicketCategory(ticketCategory);
        order.setNumberOfTickets(orderPostDto.getNumberOfTickets());
        order.setTotalPrice(orderPostDto.getTotalPrice());
        return order;
    }

    public List<OrderDto> convertModeListToDtoList(List<Order> orders) {
        List<OrderDto> result = new ArrayList<>();
        for(Order order: orders) {
            result.add(convertModelToDto(order));
        }
        return result;
    }
}
