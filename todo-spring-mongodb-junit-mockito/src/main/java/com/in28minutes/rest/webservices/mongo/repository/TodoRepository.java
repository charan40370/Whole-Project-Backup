package com.in28minutes.rest.webservices.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.in28minutes.rest.webservices.mongo.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, Integer> {

	
	
	
}
