package com.edsontelesfontes.Course.controller;

import com.edsontelesfontes.Course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"maria", "maria@gmail.com", "9999-9999","101010");
        return ResponseEntity.ok().body(u);
    }
}
