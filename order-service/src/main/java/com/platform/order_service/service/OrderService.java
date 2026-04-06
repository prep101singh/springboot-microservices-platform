package com.platform.order_service.service;

import com.platform.order_service.client.ProductClient;
import com.platform.order_service.dto.CreateOrderRequestDTO;
import com.platform.order_service.dto.OrderItemRequest;
import com.platform.order_service.dto.Product;
import com.platform.order_service.entity.Order;
import com.platform.order_service.entity.OrderItem;
import com.platform.order_service.repository.OrderItemRepository;
import com.platform.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productClient = productClient;
    }

    public Order createOrder(CreateOrderRequestDTO request) {
        double totalPrice = 0;

        Order order = new Order();
        order.setUserId(request.getUserId());

        order = orderRepository.save(order);

        for (OrderItemRequest item : request.getItems()) {

            Product product = productClient.getProduct(item.getProductId());

            double itemPrice = product.getPrice() * item.getQuantity();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(item.getProductId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(itemPrice);

            orderItemRepository.save(orderItem);

            totalPrice += itemPrice;
        }

        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
