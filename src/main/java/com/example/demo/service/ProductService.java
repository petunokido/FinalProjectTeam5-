package com.example.demo.service;

import com.example.demo.exception.ProductNotFound;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Create new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    //get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //find Product by Id
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(ProductNotFound::new);
    }
}
