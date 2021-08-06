package com.java8.features;


public class MethodReferenceExample1 {

	public static void main(String[] args) {
		
		Thread t = new Thread(MethodReferenceExample1::printMessage);//() -> printMessage()  //instead of this we replaced with method reference
		//***for method reference you have to pass class name and use :: and method name
		//it does samething like lambda mentioned below
		//method reference is alternate to the lambda with less syntax than that
		//this example is without parameters, for parameter, see MethodReferenceExample2
		t.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello using method reference");
	}
}

//OR

//using Lambdas
/*public class MethodReferenceExampleUsingLambda {

	public static void main(String[] args) {
		
		Thread t = new Thread(() -> printMessage());
		t.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello using method reference");
	}
}

*/