package net.javaguides.springboot.user;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class UserTest {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserService userService;

    @Autowired
    public UserServiceImpl userServiceImpl;

    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        userServiceImpl = new UserServiceImpl(userRepository);
    }

    @Test
    void addUser() {

    }
}
