package com.inronhack.Employee.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public void handleEmployeeNotFoundException(EmployeeNotFoundException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(IllegalInputException.class)
    public void handleIllegalInputException(IllegalInputException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }
}
