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

//Predicate -> It is Functional Interface
//Java 8 has built in functions from the java.util.function and it provides some out of box interfaces that we use most of the times
//example Predicate<T> => boolean valued function of one argument
//if you want an interface that takes an object and has to return boolean, we can use Predicate interface


//Consumer -> It is one more functional interface
//it accepts one object and returns nothing