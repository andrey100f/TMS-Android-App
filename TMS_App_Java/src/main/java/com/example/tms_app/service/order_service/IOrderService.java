package com.example.tms_app.service.order_service;

import com.example.tms_app.models.dto.order_dto.OrderDto;
import com.example.tms_app.models.dto.order_dto.OrderPostDto;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    List<OrderDto> getOrdersByUserId(UUID userId);
    List<OrderDto> getOrdersByIdAndUserId(UUID orderId, UUID userId);
    OrderDto saveOrder(OrderPostDto orderPostDto, UUID userId);
    OrderDto updateOrder(OrderPostDto orderPostDto, UUID userId);
    OrderDto deleteOrder(UUID orderId);
}
