package ru.nechay.springsec.securityex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

	
	@GetMapping("/greeting")
	public String greeting(Model model) {
		
		return "greeting/greet";
	}
	@GetMapping("/main")
	public String main(Model model) {
		
		return "greeting/main";
	}
}
