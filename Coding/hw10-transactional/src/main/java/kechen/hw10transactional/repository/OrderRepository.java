package kechen.hw10transactional.repository;


import kechen.hw10transactional.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
