package com.educative.ecommerce.repository;

import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategory(Category category);
    Optional<Product> findByName(String name);
    
}
