package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.client.ProductClient;
import com.ironhack.EdgeService.exceptions.ProductServiceDownException;
import com.ironhack.EdgeService.model.Product.Product;
import com.ironhack.EdgeService.model.Product.ProductDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductClient productClient;

    @HystrixCommand(fallbackMethod = "errorFindAll")
    public List<Product> findAll(){ return productClient.findAll(); }

    public List<Product> errorFindAll() {
        throw new ProductServiceDownException("Product Service Down Exception. Method: findAll. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindById")
    public Product findById(Integer id){ return productClient.findById(id); }

    public Product errorFindById(Integer id) {
        throw new ProductServiceDownException("Product Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreate")
    public Product create(Product product){ return productClient.create(product); }

    public Product errorCreate(Product product) {
        throw new ProductServiceDownException("Product Service Down Exception. Method: create. ");
    }

    @HystrixCommand(fallbackMethod = "errorDelete")
    public void delete(Integer id){ productClient.delete(id); }

    public void errorDelete(Integer id) {
        throw new ProductServiceDownException("Product Service Down Exception. Method: delete. ");
    }

    @HystrixCommand(fallbackMethod = "errorDecrementQuantity")
    public void decrementQuantity(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        productClient.decrementQuantity(id, productDTO);
    }
    public void errorDecrementQuantity(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        throw new ProductServiceDownException("Product Service Down Exception. Method: errorDecrementQuantity. ");
    }
}
