package com.platform.order_service.controller;

import com.platform.order_service.dto.CreateOrderRequestDTO;
import com.platform.order_service.entity.Order;
import com.platform.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequestDTO request) {
        return orderService.createOrder(request);
    }
}
