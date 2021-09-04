package com.politecnico.serviceuser;

import com.politecnico.serviceuser.entities.User;
import com.politecnico.serviceuser.repositories.UserRepository;
import com.politecnico.serviceuser.services.UserService;
import com.politecnico.serviceuser.services.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceMockTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void begin() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
        User user = User.builder()
                .id(5L)
                .name("Juan")
                .lastName("Marquez").build();
        Mockito.when(userRepository.findById(5L))
                .thenReturn(Optional.of(user));
    }

    @Test
    public void when_findById_return_user() {
        User user = userService.findById(5L);
        Assertions.assertThat(user.getName()).isEqualTo("Juan");
    }

}
