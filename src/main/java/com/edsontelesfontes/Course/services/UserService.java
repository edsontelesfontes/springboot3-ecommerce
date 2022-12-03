package com.edsontelesfontes.Course.services;

import com.edsontelesfontes.Course.entities.User;
import com.edsontelesfontes.Course.repositories.UserRepository;
import com.edsontelesfontes.Course.services.exceptions.DatabaseException;
import com.edsontelesfontes.Course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        User user1 = userRepository.getReferenceById(id);
        updateData(user1, user);
        return userRepository.save(user1);
    }

    private void updateData(User user1, User user) {
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
    }
}
