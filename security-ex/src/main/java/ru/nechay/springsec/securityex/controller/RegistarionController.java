package ru.nechay.springsec.securityex.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ru.nechay.springsec.securityex.models.Role;
import ru.nechay.springsec.securityex.models.User;
import ru.nechay.springsec.securityex.repos.UserRepo;

@Controller
public class RegistarionController {
	@Autowired
	private UserRepo userRepo;
	
	
	@GetMapping("/registration")
	public String registration() {
		return "greeting/registration";
	}
	
	
	@PostMapping("/registration")
	public String addUser(User user, Model model) {
		User userFromDb = userRepo.findByUsername(user.getUsername());
		
		if(userFromDb != null) {
			model.addAttribute("message", "User exists!");
			return "greeting/registration";
		}
		
		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		userRepo.save(user);
		
		return "redirect:/login";
	}
}
