package com.ironhack.EdgeService.handler;

import com.ironhack.EdgeService.exceptions.BillServiceDownException;
import com.ironhack.EdgeService.exceptions.EmployeeServiceDownException;
import com.ironhack.EdgeService.exceptions.OrderServiceDownException;
import com.ironhack.EdgeService.exceptions.ProductServiceDownException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BillServiceDownException.class)
    public void billServiceDownExceptionHandler(BillServiceDownException billServiceDownException, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_GONE, billServiceDownException.getMessage());
    }

    @ExceptionHandler(EmployeeServiceDownException.class)
    public void employeeServiceDownExceptionHandler(EmployeeServiceDownException employeeServiceDownException, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_GONE, employeeServiceDownException.getMessage());
    }

    @ExceptionHandler(OrderServiceDownException.class)
    public void orderServiceDownExceptionHandler(OrderServiceDownException orderServiceDownException, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_GONE, orderServiceDownException.getMessage());
    }

    @ExceptionHandler(ProductServiceDownException.class)
    public void productServiceDownExceptionHandler(ProductServiceDownException productServiceDownException, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_GONE, productServiceDownException.getMessage());
    }
}
