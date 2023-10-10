package org.example.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.entity.Order;
import org.example.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
