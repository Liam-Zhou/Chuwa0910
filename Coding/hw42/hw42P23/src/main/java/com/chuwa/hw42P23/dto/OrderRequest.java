package com.chuwa.hw42P23.dto;

import com.chuwa.hw42P23.entity.Order;
import com.chuwa.hw42P23.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}