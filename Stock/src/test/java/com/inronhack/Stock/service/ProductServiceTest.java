package com.inronhack.Stock.service;

import com.inronhack.Stock.model.Product;
import com.inronhack.Stock.model.dto.ProductDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;
     private Product product1;

    @BeforeEach
    void setUp() {
        product1 = new Product( "Chair", 150,"LERU", "A simple chair", new BigDecimal("10"));
        product1.setId(10);
        productService.create(product1);
    }

    @Test
    void create() {
        Product product = new Product("lamp", 55, "IKEA", "LED lamp", new BigDecimal("15"));
        productService.create(product);
        assertEquals("lamp", product.getName());
    }


    @Test
    void decrementQuantity() {
        Product product2 = new Product( "Chair", 150,"LERU", "A simple chair", new BigDecimal("10"));
        productService.create(product2);
        ProductDTO productDTO = new ProductDTO(10);
        productService.decrementQuantity(product2.getId(), productDTO);
        assertEquals(140, productService.findById(10).getQuantity());
    }
}