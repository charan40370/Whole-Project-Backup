package com.java8.features;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {
	//Streams has bunch of methods that we can use
	//Stream you can think as new view of the collection, stream will always have a source
	//Streams consists of 3 elements
	//1)source   ex: people
	//2)operations that performed on the stream    ex: filter
	//3)terminal or end point that causes to do it duty or task  ex: forEach
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens",60),
				new Person("Lewis", "Carroll",60),
				new Person("Thomas", "Carlyle",60),
				new Person("Charlotte", "Bronte",60),
				new Person("Mathew", "Arnold",60)			
				);
		
		//Example 1
		people.stream()
		.filter(p -> p.getLastName().startsWith("C") )  //this is predicate
		.forEach(p -> System.out.println(p));//this ends or this is the end of the stream 
		
		
		//Example 2
		long count = people.stream() //source
		.filter(p -> p.getLastName().startsWith("C") )//operation that we performing
		.count();//end point of our stream
		
		System.out.println("Using Stream: "+count);
		
		
		// splits collection into multiple streams to make the process fast
		long count1 = people.parallelStream() //source
				            .filter(p -> p.getLastName().startsWith("C") )//operation that we performing
				            .count();//end point of our stream
				
		System.out.println("Using Parallel Stream: "+count1);
		
		
	}

}
