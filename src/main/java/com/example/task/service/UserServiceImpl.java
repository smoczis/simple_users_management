package com.example.task.service;

import com.example.task.exception.NoUserException;
import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        user.setId(id);
        return repository.save(user);
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
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("name", "surname")
                .withMatcher("name", contains().ignoreCase())
                .withMatcher("surname", contains().ignoreCase());
        return repository.findAll(Example.of(user, matcher));
    }

    @Override
    public User getUserByName(String name) {
        return repository.findByName(name);
    }
}
