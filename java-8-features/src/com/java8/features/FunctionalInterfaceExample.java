package com.java8.features;

@FunctionalInterface
public interface FunctionalInterfaceExample {

	//Functinal Interface:
			//It can have any number of mehtods, but should contain only one abstract method, which means remaining all should be default methods with implementation
			//abstract method:
		    //In java 8 you can interfaces with implementation, before java 8 it's only abstract methods like signatures
			//you could have an interface with 3 methods, out of those can have two default methods with default implmentation
			//and one for lambda, now this interface can be functional interface
	
	
	//if in future, if any developer adds one more abstract method, then that interface is no longer Functional Interface
	//To avoid this we can use @FunctionalInterface
	//It is not mandatory to add this, but it is good practice as it gives clue to the developer
	public void justExample();
}
