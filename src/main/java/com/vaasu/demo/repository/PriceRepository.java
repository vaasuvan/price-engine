package com.vaasu.demo.repository;

import com.vaasu.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Product, Integer> {
}
