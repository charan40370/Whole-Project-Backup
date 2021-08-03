package com.java8.features;

import java.util.Arrays;
import java.util.List;

public class forEachExample {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens",60),
				new Person("Lewis", "Carroll",60),
				new Person("Thomas", "Carlyle",60),
				new Person("Charlotte", "Bronte",60),
				new Person("Mathew", "Arnold",60)			
				);
		
		System.out.println("Using For loop");
		
		for(int i=0; i<people.size();i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("Using Object loop");
		
		for(Person p: people) {
			System.out.println(p);
		}
		
		
		System.out.println("Using lambda forEach");
		
		people.forEach(p -> System.out.println(p));
		
	}

}
