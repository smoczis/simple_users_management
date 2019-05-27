package com.example.task.service;

import com.example.task.model.User;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    User getUser(Long id);
    Iterable<User> getAllUsers();
    void deleteUser(Long id);
    Iterable<User> searchUsers(User user);
}