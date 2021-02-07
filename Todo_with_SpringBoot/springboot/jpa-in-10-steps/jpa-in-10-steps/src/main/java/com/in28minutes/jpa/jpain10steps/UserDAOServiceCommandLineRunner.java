package com.in28minutes.jpa.jpain10steps;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.jpa.jpain10steps.entity.User;
import com.in28minutes.jpa.jpain10steps.service.UserDAOService;


@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {
//	private static final Logger log=LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	@Autowired
	private UserDAOService userDaoService;

	@Override
	public void run(String... args) throws Exception {
		// We save the user here
		User user = new User("Jack", "Admin");
		long insert =userDaoService.insert(user);
//		log.info("New User is Created: ")
		System.out.println("New User is Created : "+user);

	}

}
