package com.Ecommerce.project.Repository;

import com.Ecommerce.project.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContaining(String name);
}