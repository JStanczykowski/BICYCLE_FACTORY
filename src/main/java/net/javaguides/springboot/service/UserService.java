package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Worker;
import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	List<User> getAllUser();
	User saveWorker(UserRegistrationDto registrationDto);
	User getWorkerById(long id);
	User getWorkerByEmail(String username);
	User updateWorker(User worker);
	User updateWorkerEdit(User worker);
	void deleteWorkerById(long id);
}
