package com.example.task.repository;

import com.example.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findBySurname(String surname);
}
