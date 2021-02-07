package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String HelloWorld() {
		return "HelloWorld Again!!!";
	}
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
//		return throw new RuntimeException("Some Error has happened!! Contact Support!!!");
		return new HelloWorldBean("HelloWorldBean");
		 
	}
	@GetMapping(path="/hello-world/path/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World with Path Variable, %s", name));
	}
}
