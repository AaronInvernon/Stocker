package com.ironhack.EdgeService.exceptions;

public class OrderServiceDownException extends RuntimeException{
    public OrderServiceDownException(String message){ super(message);}
}