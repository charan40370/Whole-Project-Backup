package com.java7.traditional;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		greeter.greet(helloWorldGreeting);// this is called polymorphism as HelloWorldGreeting already implmented Greeter interface
		//this greet method will call interface method which is HelloworldGreeting class
	
		// Using Lambda above can be achieved like
		Greeting myLambdaFunc = () -> System.out.println("Hello World!");//this return type should match Greeting return type
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		// -> How to specify or how to mention this variable type??? => see below =>   lambdaFunction = () -> System.out.println("Hello World!");  
		
		MyLambda mylambdaFunction = () -> System.out.println("Hello World!");// this will understand by seeing the interface body
		
		MyAdd addFunction = (int a, int b) -> a+b;// only interface name should matche, others like method name in interface doesn't matter likewise return type too in this line of code
		
		
		//Difference between Regular interface implementation and Lambda way of implementation-----------------------------------------------------------------------------------------------------------------------------------------------
		Greeting helloWorldGreeting1 = new HelloWorldGreeting();  
		Greeting lambdaGreeting = () -> System.out.println("Hello World!");
		
		helloWorldGreeting1.perform();//regurlar way of calling method that implements interface method  -> Same output
		lambdaGreeting.perform();//This is how you execute lambda expressions. By calling the interface method  on it, just as if it were an instance of a class!! -> Same output
		//almost like implementation but not the implementation
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//Lambda & anonymous inner class
		//*)dont say both are same, there are things that anonymous can do which lambda doesn't
		Greeting lambdaGreeting2 = () -> System.out.println("Hello World!A");//same thing can be acheived using anonymous inner class but with more code
		//we can also achieve same thing using anonymous inner class
		Greeting innerClassGreeting = new Greeting() {
			public void perform() {
				System.out.println("Hello world!A");
			}
		};

		innerClassGreeting.perform();
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		
	}
}



interface MyLambda {
	void foo();//if you are using lambda for this foo method, if there is one more different method in this interface
	//Compiler gets confused and will throw error, while using lambdas only one method should be there in interface ex: int add(int x, int y); this throws error
}


interface MyAdd {
	int add(int x, int y);
	//int add(int x, int y,int z); if you add this, MyAdd addFunction = (int a, int b) -> a+b; this line cannot be compiled as java confuses if there are multiple signature methods in interface while using java
}