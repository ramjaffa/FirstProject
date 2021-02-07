package com.in28minutes.rest.webservices.restfulwebservices.basic.auth;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {
	
	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorldBean() {
//		return throw new RuntimeException("Some Error has happened!! Contact Support!!!");
		return new AuthenticationBean("We are Authenticated");
		 
	}
	
} 
