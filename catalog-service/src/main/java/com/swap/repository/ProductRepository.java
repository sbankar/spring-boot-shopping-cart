package com.swap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swap.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);
}
