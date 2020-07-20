package com.ironhack.EdgeService.client;

import com.ironhack.EdgeService.model.Product.Product;
import com.ironhack.EdgeService.model.Product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "stock-service")
public interface ProductClient {

    @GetMapping("/products")
    public List<Product> findAll();

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Integer id);

    @PostMapping("/products")
    public Product create(@RequestBody Product product);

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id);

    @PatchMapping("/products/{id}")
    public void decrementQuantity(@PathVariable Integer id, @RequestBody ProductDTO productDTO);
}
