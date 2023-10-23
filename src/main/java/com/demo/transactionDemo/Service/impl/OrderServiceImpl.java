package com.demo.transactionDemo.Service.impl;

import com.demo.transactionDemo.Entity.Order;
import com.demo.transactionDemo.Entity.Payment;
import com.demo.transactionDemo.Payload.OrderRequest;
import com.demo.transactionDemo.Payload.OrderResponse;
import com.demo.transactionDemo.Repository.OrderRepository;
import com.demo.transactionDemo.Repository.PaymentRepository;
import com.demo.transactionDemo.Service.OrderService;
import com.demo.transactionDemo.exception.PaymentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

   // @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository){
        this. orderRepository =  orderRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("payment failed ");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);


        OrderResponse orderResponse =new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;






        return null;
    }
}
