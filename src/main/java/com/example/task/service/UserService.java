package com.example.task.service;

import com.example.task.model.User;

public interface UserService {

    User createUser(User user);
    User updateUser(User user, Long id);
    User getUser(Long id);
    Iterable<User> getAllUsers();
    void deleteUser(Long id);
    Iterable<User> searchUsers(User user);

    User getUserByName(String name);
}
