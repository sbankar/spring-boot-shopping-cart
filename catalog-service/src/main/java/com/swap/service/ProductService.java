package com.swap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swap.model.Product;
import com.swap.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
 
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
 
    public List<Product> findAllProducts() {
    	List<Product>list = new ArrayList<Product>();
    	Product product = new Product();
    	product.setId(1l);
    	product.setCode("A");
    	product.setName("MyName");
    	product.setPrice(40);
    	list.add(product);
    	Product product1 = new Product();
    	product1.setId(2l);
    	product1.setCode("A");
    	product1.setName("MyName");
    	product1.setPrice(30);
    	list.add(product);
        return productRepository.findAll();
    }
 
    public Optional<Product> findProductByCode(String code) {
        return productRepository.findByCode(code);
    }
}
