package com.java8.features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {
	public static void main(String args[]) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens",60),
				new Person("Lewis", "Carroll",60),
				new Person("Thomas", "Carlyle",60),
				new Person("Charlotte", "Bronte",60),
				new Person("Mathew", "Arnold",60)	
				);
		
		//These are possible ways to do in java 7, we can do same thing in java 8 in better way
		
		
		//Step 1:Sort list by last name

		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		//you can use just sort(list) => this will achieve natural order not the customized order as we need customized we use comparator way 
		//of sorting
			
		//Step 2: Create a method that prints all elements in the list
		printAll(people);
		
		//Step 3: Create a method that prints all people that have last name beginning with C
		printAllLastNamesWithC(people);
		
		//This is very inflexible if you want one more that starts with D, you have to create new method
		
		////Step 4: Create a method that prints all people that have last name beginning with C based on condition
		
		printConditionally(people, new Condition() {//we passing behaviour here like we passing the implementation as a parameter that has implementation of checking last name
			@Override
			public boolean test(Person p) {				
					return p.getLastName().startsWith("C");							
			}			
		});
		
		
	}
	
	private static void printAll(List<Person> people) {
		for(Person p : people) {
			System.out.println(p);
		}
	}
	
	private static void printAllLastNamesWithC(List<Person> people) {
		for(Person p : people) {
			if(p.getLastName().startsWith("C")) {//you can create one more method that starts with A or B or D
				System.out.println(p);
			}
		}
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p : people) {
			if(condition.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	
	
	public interface Condition{
		public boolean test(Person p);
	}
}


