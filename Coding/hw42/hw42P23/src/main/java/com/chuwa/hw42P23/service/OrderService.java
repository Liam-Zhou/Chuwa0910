package com.chuwa.hw42P23.service;


import com.chuwa.hw42P23.dto.OrderRequest;
import com.chuwa.hw42P23.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}