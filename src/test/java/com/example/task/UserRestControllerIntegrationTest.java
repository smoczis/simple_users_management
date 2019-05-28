package com.example.task;

import com.example.task.controller.UserController;
import com.example.task.repository.UserRepository;
import com.example.task.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserRestControllerIntegrationTest {

    @MockBean
    private UserService service;

    @Autowired
    private UserController controller;

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenUserControllerInjected_thenNotNull() throws Exception {
        assertThat(controller).isNotNull();
    }
}
