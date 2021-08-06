package com.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens",60),
				new Person("Lewis", "Carroll",69),
				new Person("Thomas", "Carlyle",61),
				new Person("Charlotte", "Bronte",60),
				new Person("Mathew", "Arnold",60)			
				);
	System.out.println("Printing all persons");
	 printConditionallyUsingConsumer(people,p -> true, p -> System.out.println(p));
	 printConditionallyUsingConsumer(people,p -> true,System.out::println);//p -> method(p)// here this replaces that method reference
	 //Here the println is the method or reference of System.out
	
	}
	
	private static void printConditionallyUsingConsumer(List<Person> people, Predicate<Person> predicate,Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
	}
}
}