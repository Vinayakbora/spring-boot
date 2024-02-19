package com.example.springbootassignment.repositories;

import com.example.springbootassignment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
