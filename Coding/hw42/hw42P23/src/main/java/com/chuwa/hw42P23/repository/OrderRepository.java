package com.chuwa.hw42P23.repository;

import com.chuwa.hw42P23.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
