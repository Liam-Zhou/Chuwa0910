package org.example.service;


import org.example.dto.OrderRequest;
import org.example.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
