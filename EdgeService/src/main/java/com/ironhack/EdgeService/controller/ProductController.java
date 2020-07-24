package com.ironhack.EdgeService.controller;

import com.ironhack.EdgeService.model.Product.Product;
import com.ironhack.EdgeService.model.Product.ProductDTO;
import com.ironhack.EdgeService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll(){ return productService.findAll(); }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable Integer id){ return productService.findById(id); }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) { return productService.create(product); }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) { productService.delete(id); }

    @PatchMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void decrementQuantity(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        productService.decrementQuantity(id, productDTO);
    }
}
