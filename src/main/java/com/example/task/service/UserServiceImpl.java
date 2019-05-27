package com.example.task.service;

import com.example.task.exception.NoUserException;
import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(this.getUser(user.getId()));
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoUserException("User with id: " + id + " not found!"));
    }

    @Override
    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<User> searchUsers(User user) {
        return repository.findAll(Example.of(user));
    }
}
