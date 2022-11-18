package com.edsontelesfontes.Course.services;

import com.edsontelesfontes.Course.entities.Category;
import com.edsontelesfontes.Course.entities.Order;
import com.edsontelesfontes.Course.repositories.CategoryRepository;
import com.edsontelesfontes.Course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return  categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order not found"));
    }
}
