package com.demo.transactionDemo.Repository;

import com.demo.transactionDemo.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
