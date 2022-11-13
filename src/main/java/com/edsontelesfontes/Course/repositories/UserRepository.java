package com.edsontelesfontes.Course.repositories;

import com.edsontelesfontes.Course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
