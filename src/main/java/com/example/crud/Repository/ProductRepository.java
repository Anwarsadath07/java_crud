package com.example.crud.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crud.Models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByname(String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1% OR p.Description LIKE %?1%")
    List<Product> findAllByKeyword(String keyword);

}