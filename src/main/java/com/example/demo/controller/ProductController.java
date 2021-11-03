package com.example.demo.controller;

import com.example.demo.model.Product;

import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService, ProductService productService1) {
        this.productService = productService1;

    }

    //get all products
    @ApiOperation(value = "Update registration detail",
            authorizations = { @Authorization(value="basicAuth") })
    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductResponse> productResponseList = new ArrayList<>();

        for(Product product: products){
            productResponseList.add(new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getValue()
            ));
        }

        return productResponseList;
    }

    //find product by Id
    @ApiOperation(value = "Update registration detail",
            authorizations = { @Authorization(value="basicAuth") })
    @GetMapping("/products/{id}")
    public ProductResponse getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getValue()
        );
    }

    //create new product
    @ApiOperation(value = "Update registration detail",
            authorizations = { @Authorization(value="basicAuth") })
    @PostMapping(value = "/products", consumes = "application/json")
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest){
        Product product= productService.createProduct(Product.builder()
                .name(productRequest.getName())
                .value(productRequest.getValue())
                .build());
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getValue()
        );
    }
}