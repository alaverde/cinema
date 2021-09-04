package com.politecnico.serviceuser;

import com.politecnico.serviceuser.entities.User;
import com.politecnico.serviceuser.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryMockTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findByAll_return_ListUsers(){
        User user = User.builder()
                .name("Sara")
                .lastName("Laverde")
                .build();
        userRepository.save(user);
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(5);
    }
}
