package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByUsername(String username);
	
}
