package com.chuwa.hw42P23.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private String orderTackingNumber;
    private String status;
    private String message;
}