package com.edsontelesfontes.Course.services;

import com.edsontelesfontes.Course.entities.Product;
import com.edsontelesfontes.Course.entities.User;
import com.edsontelesfontes.Course.repositories.ProductRepository;
import com.edsontelesfontes.Course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return  productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
    }
}
