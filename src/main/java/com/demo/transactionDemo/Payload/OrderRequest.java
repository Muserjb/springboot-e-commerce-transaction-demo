package com.demo.transactionDemo.Payload;

import com.demo.transactionDemo.Entity.Order;
import com.demo.transactionDemo.Entity.Payment;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
