package com.demo.transactionDemo.exception;

public class PaymentException extends RuntimeException{

    public PaymentException(String message){
        super(message);
    }
}
