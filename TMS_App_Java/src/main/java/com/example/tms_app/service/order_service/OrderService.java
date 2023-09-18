package com.example.tms_app.service.order_service;

import com.example.tms_app.models.Event;
import com.example.tms_app.models.Order;
import com.example.tms_app.models.TicketCategory;
import com.example.tms_app.models.User;
import com.example.tms_app.models.dto.order_dto.OrderDto;
import com.example.tms_app.models.dto.order_dto.OrderPostDto;
import com.example.tms_app.models.exceptions.models.EntityNotFoundException;
import com.example.tms_app.models.mapper.OrderMapper;
import com.example.tms_app.repository.EventRepository;
import com.example.tms_app.repository.OrderRepository;
import com.example.tms_app.repository.TicketCategoryRepository;
import com.example.tms_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements IOrderService{
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final UserRepository userRepository;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final EventRepository eventRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, UserRepository userRepository,
                        TicketCategoryRepository ticketCategoryRepository, EventRepository eventRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.userRepository = userRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<OrderDto> getOrdersByUserId(UUID userId) {
        List<Order> orders = this.orderRepository.getOrdersByUserUserId(userId);
        if(orders.isEmpty()) {
            throw new EntityNotFoundException("Orders Not Found!!");
        }
        return this.orderMapper.convertModeListToDtoList(orders);
    }

    @Override
    public List<OrderDto> getOrdersByIdAndUserId(UUID orderId, UUID userId) {
        List<Order> orders = this.orderRepository.getOrdersByOrderIdAndUserUserId(orderId, userId);
        if(orders.isEmpty()) {
            throw new EntityNotFoundException("Orders Not Found!!");
        }
        return this.orderMapper.convertModeListToDtoList(orders);
    }

    @Override
    public OrderDto saveOrder(OrderPostDto orderPostDto, UUID userId) {
        User user = this.userRepository.getUserByUserId(userId);
        Event event = this.eventRepository.getEventByEventName(orderPostDto.getEventName());
        TicketCategory ticketCategory = this.ticketCategoryRepository.
                getTicketCategoriesByEventEventIdAndDescription(event.getEventId(), orderPostDto.getTicketCategory());
        orderPostDto.setTotalPrice(ticketCategory.getPrice() * orderPostDto.getNumberOfTickets());
        Order orderSaved = this.orderRepository.save(this.orderMapper.convertPostDtoToModel(orderPostDto,
                ticketCategory, user));
        return this.orderMapper.convertModelToDto(orderSaved);
    }

    @Override
    public OrderDto updateOrder(OrderPostDto orderPostDto, UUID orderId) {
        Order order = this.orderRepository.getOrderByOrderId(orderId);
        Event event = this.eventRepository.getEventByEventName(orderPostDto.getEventName());
        TicketCategory ticketCategory = this.ticketCategoryRepository.
                getTicketCategoriesByEventEventIdAndDescription(event.getEventId(), orderPostDto.getTicketCategory());
        order.setTotalPrice(ticketCategory.getPrice() * orderPostDto.getNumberOfTickets());
        order.setTicketCategory(ticketCategory);
        order.setNumberOfTickets(orderPostDto.getNumberOfTickets());
        Order orderUpdated = this.orderRepository.save(order);
        return this.orderMapper.convertModelToDto(orderUpdated);
    }

    @Override
    public OrderDto deleteOrder(UUID orderId) {
        Order order = this.orderRepository.getOrderByOrderId(orderId);
        OrderDto result = this.orderMapper.convertModelToDto(order);
        this.orderRepository.deleteById(orderId);
        return result;
    }
}
