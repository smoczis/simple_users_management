package com.example.task.controller;

import com.example.task.model.User;
import com.example.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = service.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User newUser = service.getUser(id);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User existingUser, @PathVariable Long id) {
        User newUser = service.updateUser(existingUser, id);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PostMapping("/users-search")
    public ResponseEntity<Iterable<User>> searchUsers(@RequestBody User user) {
        Iterable<User> users = service.searchUsers(user);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
