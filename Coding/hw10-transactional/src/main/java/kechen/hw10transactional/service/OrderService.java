package kechen.hw10transactional.service;

import kechen.hw10transactional.dto.OrderRequest;
import kechen.hw10transactional.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}