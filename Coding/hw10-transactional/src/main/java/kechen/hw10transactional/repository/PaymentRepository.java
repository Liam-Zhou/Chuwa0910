package kechen.hw10transactional.repository;

import kechen.hw10transactional.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
