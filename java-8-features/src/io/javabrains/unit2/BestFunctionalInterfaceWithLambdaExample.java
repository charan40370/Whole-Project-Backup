package io.javabrains.unit2;

import java.util.function.BiConsumer;

public class BestFunctionalInterfaceWithLambdaExample {
	public static void main(String[] args) {
	
		//Start with example
		int[] someNumbers = {1,2,3,4};
		int key = 2;
		
		process(someNumbers, key);
		
		processJava8(someNumbers, key,(s,k) -> System.out.println(s+k));
		
		
	}
	
	private static void process(int[] someNumbers, int key) {
		for(int i : someNumbers) {
			System.out.println(i+key);
		}
	}
	
	//samething using java 8
	private static void processJava8(int[] someNumbers, int key,BiConsumer<Integer , Integer> biconsumer) {
		for(int i : someNumbers) {
			biconsumer.accept(i, key);
		}
	}
}
