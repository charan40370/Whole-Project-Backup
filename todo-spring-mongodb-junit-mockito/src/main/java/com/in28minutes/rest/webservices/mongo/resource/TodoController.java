package com.in28minutes.rest.webservices.mongo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.mongo.model.ResponseForMockitoTest;
import com.in28minutes.rest.webservices.mongo.model.Todo;
import com.in28minutes.rest.webservices.mongo.repository.TodoRepository;

@RestController
public class TodoController {

	@Autowired
	private TodoRepository repository;//we used Autowired to get values from other class which is repository
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello Charan & pranitha";
	}
	
	/*@PostMapping("/addTodo")
	public String saveTodo(@RequestBody Todo todo) {
		repository.save(todo);
		return "Added Todo with id: " + todo.getId();// here getId() is inbuild from jar
	}*/
	
	@PostMapping("/addTodo")  //this is for Unit testing , for normal mongo use above method for saving
	public ResponseForMockitoTest saveTodo(@RequestBody Todo todo) {
		repository.save(todo);
		return new ResponseForMockitoTest("Added Todo with id: " + todo.getId(),true);// here getId() is inbuild from jar
	}
	
	
	@GetMapping("/findAllTodos")
	public List<Todo> getTodos() {
		return repository.findAll(); //here findALl() is inbuild from mongo repository
	}
	
	@GetMapping("/findAllTodods/{id}")
	public Optional<Todo> getTodo(@PathVariable int id) { //here I am getting value from path itself, not like query param
		return repository.findById(id);  //I have used Optional collection from util that get record optionally from list
	}

    @DeleteMapping("/delete/{id}") // provided in Spring version 4, I mean direct DeleteMapping
	public String deleteTodo(@PathVariable int id) {//passing delete id from 
        repository.deleteById(id); //request mapping also can use and then pass the id -> this is another method 
		return "Todo deleted with id: "+id;
	}
}
