package com.inronhack.CreateOrder.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message) {
        super (message);
    }
}
