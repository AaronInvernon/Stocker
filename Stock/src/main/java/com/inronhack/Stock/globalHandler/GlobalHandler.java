package com.inronhack.Stock.globalHandler;

import com.inronhack.Stock.exception.ProductNotFoundException;
import com.inronhack.Stock.exception.ProductStockException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public void handleProductNotFoundException(ProductNotFoundException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(ProductStockException.class)
    public void handleProductStockException(ProductStockException e, HttpServletResponse response)  throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
    }
}
