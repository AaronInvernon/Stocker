package com.inronhack.Stock.globalHandler;

import com.inronhack.Stock.exception.ProductNotFoundException;
import com.inronhack.Stock.exception.ProductStockException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GlobalHandlerTest {

    private GlobalHandler globalHandler = new GlobalHandler();
    private MockHttpServletResponse response;

    @BeforeEach
    void setUp() { response = new MockHttpServletResponse(); }


    @Test
    void handleProductNotFoundException() throws IOException {
        globalHandler.handleProductNotFoundException(new ProductNotFoundException("ProductNotFound"), response);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

    @Test
    void handleProductStockException()  throws IOException {
        globalHandler.handleProductStockException(new ProductStockException("ProductNotFound"), response);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }
}