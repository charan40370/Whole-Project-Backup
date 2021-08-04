package com.java8.features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java8.features.Unit1ExerciseSolutionJava7.Condition;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens",60),
				new Person("Lewis", "Carroll",60),
				new Person("Thomas", "Carlyle",60),
				new Person("Charlotte", "Bronte",60),
				new Person("Mathew", "Arnold",60)	
				);
		
		//These are possible ways to do in java 7, we can do same thing in java 8 in better way
		
		
		//Step 1:Sort list by last name

		Collections.sort(people,(Person p1, Person p2) -> p1.getLastName().compareTo(p1.getLastName()) );
		//OR
		Collections.sort(people,(p1,p2) -> p1.getLastName().compareTo(p1.getLastName()) );//same as above as it supports "Type Inference", no need to mention Person
		
		//you can use just sort(list) => this will achieve natural order not the customized order as we need customized we use comparator way 
		//of sorting
			
		//Step 2: Create a method that prints all elements in the list
		printConditionally(people, p -> true); //p -> true , here lambda accepting p object and giving true for all p objects
		
		//Step 3: Create a method that prints all people that have last name beginning with C
		printConditionally(people, p -> p.getLastName().startsWith("C"));
		
		//drastically reduced the lines, implemented interface without any issues
		//for better understanding compare with Java7 example
		
		//Step 4: Using Predicate to achieve step 2, without creating Condition interface by using java 8 in built Predicate interface
		printConditionallyUsingPredicate(people,p->true);
		
		//Step 5: Using Consumer
        printConditionallyUsingConsumer(people,p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
		//OR
		//Step 5: Using Consumer
		printConditionallyUsingConsumer(people,p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getFirstName()));
	}


	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p : people) {
			if(condition.test(p)) {//in this line three different things are in synch, they are test method 
				//which is 1)p -> true, 2)calling test(p),3)executing p ->true which is returning true always like return true from previous java 7 class
				//Here when printconditionally called, it will pass poeple and lambda which is treated as interface, then it comes to the current line
				//from here for each person, test(p) is called, which means it pass p to the above printconditionally method, from there you will get true as it is lambda
				//and it return true for all 'p' objects
				System.out.println(p);
			}
		}
	}
	
	
	private static void printConditionallyUsingPredicate(List<Person> people, Predicate<Person> predicate) {
		for(Person p : people) {//Predicate can accept generic, it can accept any object
			if(predicate.test(p)) {//here predicate accepts the object and returns the boolean similarly we doing 
				//achieving above operation that gives true always without creating Condition Interface in java
				System.out.println(p);
			}
		}
	}
	
	private static void printConditionallyUsingConsumer(List<Person> people, Predicate<Person> predicate,Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
	
	
}
