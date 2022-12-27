package net.javaguides.springboot.user;

import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.UserServiceImpl;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class UserTest {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserService userService;

    @Autowired
    public UserServiceImpl userServiceImpl;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;
    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(BCryptPasswordEncoder.class);
        userServiceImpl = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    void addUser() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto("Dawid", "Drej", "dd@kielce.pl", passwordEncoder.encode("password"), "technic");

        userServiceImpl.save(userRegistrationDto);

        assertFalse(userRepository.findAll().stream().anyMatch(user1 -> user1.getEmail().equals(userRegistrationDto.getEmail())));
    }
    @Test
    void addUserWithSameEmail() {
        UserRegistrationDto userRegistrationDto1 = new UserRegistrationDto("Dawid", "Drej", "dd@kielce.pl", passwordEncoder.encode("password"), "technic");
        UserRegistrationDto userRegistrationDto2 = new UserRegistrationDto("Kuba", "Stanczykowski", "dd@kielce.pl", passwordEncoder.encode("password"), "technic");

        userServiceImpl.save(userRegistrationDto1);

        assertThat(catchThrowable(() -> {
            userServiceImpl.save(userRegistrationDto2);
            throw new Exception("bad email");
        })).as("User with this email exist in database")
                .isInstanceOf(Exception.class)
                .hasMessageContaining("bad email");
    }

}
