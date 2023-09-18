package com.example.tms_app.controller;

import com.example.tms_app.models.dto.order_dto.OrderDto;
import com.example.tms_app.models.dto.order_dto.OrderPostDto;
import com.example.tms_app.service.order_service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/orders/{userId}")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<OrderDto> getOrdersByUserId(@PathVariable  UUID userId) {
        return this.orderService.getOrdersByUserId(userId);
    }

    @GetMapping("/{orderId}")
    public List<OrderDto> getOrdersByIdAndUserId(@PathVariable UUID orderId, @PathVariable UUID userId) {
        return this.orderService.getOrdersByIdAndUserId(orderId, userId);
    }

    @PostMapping("")
    public OrderDto saveOrder(@RequestBody OrderPostDto orderPostDto, @PathVariable UUID userId) {
        return this.orderService.saveOrder(orderPostDto, userId);
    }

    @PatchMapping("/{orderId}")
    public OrderDto patchOrder(@RequestBody OrderPostDto orderPostDto, @PathVariable UUID orderId) {
        return this.orderService.updateOrder(orderPostDto, orderId);
    }

    @DeleteMapping("{orderId}")
    public OrderDto deleteOrder(@PathVariable UUID orderId) {
        return this.orderService.deleteOrder(orderId);
    }
}
