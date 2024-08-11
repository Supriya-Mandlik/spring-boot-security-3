package com.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//custom security configuration
//basic authentication

@RestController
public class GreetingsController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}

}