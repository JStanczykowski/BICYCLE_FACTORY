package net.javaguides.springboot.registration;


import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RegistrationUserTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserRegistrationDto userRegistrationDto;

    @BeforeEach
    void setup() {
        userServiceImpl = new UserServiceImpl(userRepository);
        BCryptPasswordEncoder passwordEncoder;
    }

    @Test
    void savedUser() {
        UserRegistrationDto userRegistrationDto1 = new UserRegistrationDto();
        userRegistrationDto1.setFirstName("dasd");
        userRegistrationDto1.setLastName("dass");
        userRegistrationDto1.setEmail("dasas@email");

        //userRegistrationDto1.setPassword(passwordEncoder.encode("dawd"));
        userRegistrationDto1.setRoles("technic");

        //User savedUser = userServiceImpl.saveWorker(userRegistrationDto1);
        //assertThat(savedUser.getFirstName()).isNotNull();
    }

}
