package com.TechSell.demo.services;

import com.TechSell.demo.models.Products;
import com.TechSell.demo.repos.ProductRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Products> getAllProducts() {
        return productRepo.findAll();
    }

    public Products getProductById(int productId) {
        return productRepo.getProductById(productId);
    }

    public Products addProduct(Products product) {
       return productRepo.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
    }

}
