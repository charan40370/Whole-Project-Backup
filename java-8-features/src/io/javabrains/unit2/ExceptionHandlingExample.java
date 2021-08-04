package io.javabrains.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		
		//Start with example
		int[] someNumbers = {1,2,3,4};
		int key = 0;
		
		processJava8Exception1(someNumbers, key,(s,k) -> {//one way of handling Exception but not good looking 
			//There is one more way of doing this, for that see in Java 8 Lambda Basics 18 video by Java brains
			try {
				System.out.println(s/k); //Here you will get Arithmetic Exception as dividing by Zero(0)
			}
			catch(ArithmeticException e) {
				System.out.println("An ArithmeticException happened");
			}
		});
		
		
		
				
	}
	
	private static void processJava8Exception1(int[] someNumbers, int key,BiConsumer<Integer , Integer> biconsumer) {
		for(int i : someNumbers) {
			biconsumer.accept(i, key);
		}
	}
}
