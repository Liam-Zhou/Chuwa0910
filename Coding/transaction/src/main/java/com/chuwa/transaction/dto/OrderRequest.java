package com.chuwa.transaction.dto;

import com.chuwa.transaction.entity.Order;
import com.chuwa.transaction.entity.Payment;

public class OrderRequest {
    private Order order;
    private Payment payment;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
