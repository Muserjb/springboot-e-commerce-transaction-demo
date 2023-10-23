package com.demo.transactionDemo.Service;

import com.demo.transactionDemo.Payload.OrderRequest;
import com.demo.transactionDemo.Payload.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
