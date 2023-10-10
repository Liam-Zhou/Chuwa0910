package com.chuwa.hw42P23.repository;

import com.chuwa.hw42P23.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
