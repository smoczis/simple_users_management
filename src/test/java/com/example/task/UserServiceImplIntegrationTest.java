package com.example.task;

import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import com.example.task.service.UserService;
import com.example.task.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceImplIntegrationTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService(UserRepository repository) {
            return new UserServiceImpl(repository);
        }
    }

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Before
    public void setUp() {
        User user = new User();
        user.setName("Romek");
        Mockito.when(repository.findByName(user.getName()))
                .thenReturn(user);
    }

    @Test
    public void whenValidName_thenUserShouldBeFound() {
        String name = "Romek";
        User found = service.getUserByName(name);

        assertThat(found.getName())
                .isEqualTo(name);
    }
}
