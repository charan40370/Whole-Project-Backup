package com.java8.features;

public class RunnableExample {
	public static void main(String[] args) {
		
		
		//Runnable using Anonymous inner class
		Thread myThread = new Thread(new Runnable() {//This is anonymous inner class
			//instead of creating new interface, which is Runnable, we can just use anonymous inner class and then just create instance
			//like we did above "new Runnable()" and implement the run method and do what ever you want inside that
			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
			}
		});
		myThread.run();
		
		//OR 
		
		//Runnable using Lambda and achieving same thing--------------------------------------------------------------------------------------------------------
		//Remember, this works because Runnable has a single method. If it had more than one method, you could not have written a lambda function of that type
		
		//Rather than creating inline anonymous inner class, we using lambda here
		Thread myLambdaThread = new Thread(() -> System.out.println("Printed Lambda Runnable"));// as there is only one method Runnable, this is achieved using Lambda
		//if there is more than one method in Runnable, this cannot be achieved 
		
		myLambdaThread.run();
		
		
		
		
	}
}
