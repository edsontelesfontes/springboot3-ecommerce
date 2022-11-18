package com.edsontelesfontes.Course.repositories;

import com.edsontelesfontes.Course.entities.Category;
import com.edsontelesfontes.Course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
