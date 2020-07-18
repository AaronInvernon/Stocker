package com.inronhack.Stock.service;

import com.inronhack.Stock.exception.ProductNotFoundException;
import com.inronhack.Stock.exception.ProductStockException;
import com.inronhack.Stock.model.Product;
import com.inronhack.Stock.model.dto.ProductDTO;
import com.inronhack.Stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product p) { return productRepository.save(p); }

    public Product findById(Integer id) { return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not Found")); }

    public List<Product> findAll() { return productRepository.findAll(); }

    public void delete(Integer id) { productRepository.delete(findById(id)); }

    public void decrementQuantity(Integer id, ProductDTO productDTO) {
        Product product = findById(id);
        if(product.getQuantity() < productDTO.getQuantity()) throw new ProductStockException("There are " + product.getQuantity() + "in stock");
        product.setQuantity(product.getQuantity() - productDTO.getQuantity());
    }
}