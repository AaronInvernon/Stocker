package com.inronhack.CreateOrder.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public void handleClientNotFoundException(ClientNotFoundException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public void handleEmployeeNotFoundException(EmployeeNotFoundException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public void handleOrderNotFoundException(OrderNotFoundException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }
}
