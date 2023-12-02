package kechen.hw10transactional.dto;

import kechen.hw10transactional.entity.Order;
import kechen.hw10transactional.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
