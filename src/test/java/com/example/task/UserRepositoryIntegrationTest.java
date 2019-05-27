package com.example.task;

import com.example.task.model.User;
import com.example.task.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager manager;
    @Autowired
    private UserRepository repository;


    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        User user = new User();
        user.setName("Alex");
        manager.persist(user);
        manager.flush();

        // when
        User found = repository.findByName(user.getName());

        // then
        assertThat(found.getName()).isEqualTo(user.getName());
    }

    @Test
    public void whenFindBySurname_thenReturnUser() {
        // given
        User user = new User();
        user.setSurname("Alex");
        manager.persist(user);
        manager.flush();

        // when
        User found = repository.findBySurname(user.getSurname());

        // then
        assertThat(found.getSurname()).isEqualTo(user.getSurname());
    }
}
