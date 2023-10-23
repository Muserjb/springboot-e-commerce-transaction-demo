package com.demo.transactionDemo.Repository;

import com.demo.transactionDemo.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
