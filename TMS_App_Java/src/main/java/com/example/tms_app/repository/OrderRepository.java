package com.example.tms_app.repository;

import com.example.tms_app.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {
    List<Order> getOrdersByUserUserId(UUID userId);
    List<Order> getOrdersByOrderIdAndUserUserId(UUID orderId, UUID userId);
    Order getOrderByOrderId(UUID orderId);
}
