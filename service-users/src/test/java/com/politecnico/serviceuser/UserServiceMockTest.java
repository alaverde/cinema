package com.politecnico.serviceuser;

import com.politecnico.serviceuser.repositories.UserRepository;
import com.politecnico.serviceuser.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceMockTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;
}
