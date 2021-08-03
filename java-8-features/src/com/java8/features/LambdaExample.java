package com.java8.features;

import java.util.ArrayList;

public class LambdaExample {

	public static void main(String args[]) {
		
		    ArrayList<Integer> numbers = new ArrayList<Integer>();
		    numbers.add(5);
		    numbers.add(9);
		    numbers.add(8);
		    numbers.add(1);
		    numbers.forEach( (n) ->  System.out.println(n)  );	
	}
	
	
	/*greetin Function = () system.out.println("Hello World!");
	 
	doubleNumberFunction = (int a) -> a*2; //you dont need to mention "return" as compiler will understand that the return type and returns the value 
	
	addFunction = (int a, int b) -> a+b;*/
	
	/*1) safeDivideFunction  = (int a, int b) -> a/b;
	
	2) -> What if you want safe divistion like if b is not 0, then only divide -> you have to add if condition
	if you are adding new line or extra line than one line, you have add block or braces to do that in lambda
	
	safeDivideFunction  = (int a, int b) -> {
		if (b==0) return 0;
		return a/b;
	};*/
	
	
	//stringLengthCountFunction = (String s) -> s.length(); // this is to print length of the string that passed as a parameter
	
	
	
}
