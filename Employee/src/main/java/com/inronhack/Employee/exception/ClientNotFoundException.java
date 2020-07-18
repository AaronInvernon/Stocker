package com.inronhack.Employee.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message) {
        super (message);
    }
}
