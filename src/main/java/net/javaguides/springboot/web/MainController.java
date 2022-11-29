package net.javaguides.springboot.web;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String login() {


		return "login";
	}

	@GetMapping("/index")
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getAuthorities().toString().equals("[MENAGO]"))
			return "redirect:/worker";
		else if(auth.getAuthorities().toString().equals("[TECHNIC]"))
			return "redirect:/technic";
		else
			return "index";

		}
	

	@GetMapping("/menago")
	public String menadzer() {
		return "menago";}


}
