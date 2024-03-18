package com.TechSell.demo.repos;

import com.TechSell.demo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products, Integer> {
    Products getProductById(int i);
}
