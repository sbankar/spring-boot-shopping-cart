package com.swap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swap.exception.ProductNotFoundException;
import com.swap.model.Product;
import com.swap.service.ProductService;
 
@RestController
@RequestMapping("/api/products")
public class ProductController {
 
    private final ProductService productService;
    
   // @Value("${user}")
	private String user;
 
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
 
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello "+user;
    }
    
    @GetMapping("")
    public List<Product> allProducts() {
        return productService.findAllProducts();
    }
 
    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code) {
        return productService.findProductByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Product with code ["+code+"] doesn't exist"));
    }
}