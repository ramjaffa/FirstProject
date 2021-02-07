package com.in28minutes.rest.webservices.restfulwebservices;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.todo.TodoHardcodedService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class TodoJpaResourceController {
	@Autowired
	public TodoHardcodedService todoService;
	
	@Autowired
	public TodoJpaRepository todoJpaRepository;

	@GetMapping(path = "/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoJpaRepository.findByUsername(username);
//		return todoService.findAll();
	}
	//Delete 
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username,@PathVariable long id){
//		Todo todo = todoService.deleteById(id);
		todoJpaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		
//		return ResponseEntity.notFound().build();
	}
	
	//Find By Specific Id
	@GetMapping(path = "/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable long id) {
		return todoJpaRepository.findById(id).get();
//		return todoService.findById(id);
	}
	//Edit
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(
			@PathVariable String username,@PathVariable long id,@RequestBody Todo todo){
//			Todo todoUpdated = todo.save(todo);
			Todo todoUpdated = todoJpaRepository.save(todo);
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	//Create
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(
			@PathVariable String username,@RequestBody Todo todo){
//			Todo createdTodo = todoService.save(todo);
			todo.setUsername(username);
			Todo createdTodo = todoJpaRepository.save(todo);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
}
