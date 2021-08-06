package com.java8.features;

public class ClosuresExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20; //if you are using or passing b which is not part of interface, you have to declare with final, but here compiler understands in java 8(not in java 7), as long as you are
		//not changing the value, you are good, if you try to change or assign a value again, compiler will throw error
		doProcess(a, i -> System.out.println(i+b));
		//when program executes the first thing happens is, it comes to doProcess and then passes 'a' which is 10 and lambda expression to the doProcess method, but the
		//thing here is: it also passing & executing b which is 20
		//1)doProcess gets executed -> passes i,b is passed by compiler and it is not responsible as per logic or in programming terminology as interface only allows i(which is only one variable)
		//(assuming b is final(as java 8 allows final) -> 
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}
	
}

interface Process {
	void process(int i);
}


/*// Same thing in java 7
 * what happening here?
 * Step 1) doProcessJava7(pass value a, pass interface implmentation which is sysout)
 * Step 2)the above will be there as a parameters(even the whole implementation is ready to use) like sysout is passes as a parameter to doProcessJava7 method
 * Step 3)doProcessJava7, will just use the process7(i), which is saying execute the sysout parameter like ordering to perform the implementation that passed
 * conclusion: Like King ordering to kill after handovering by Soldiers(Who worked hard to find the thief) but king just say kill him infront of him
 
public class ClosuresExampleWith7 {

	public static void main(String[] args) {0
		int a = 10;
		int b = 20;//if you have JDK 7 then you have assign final in front of "final int b = 20;"
		doProcessJava7(a, new Process7() { //Here samething is implmented using lambda by adding lambda instead of the interface implementation
			@Override
			public void process7(int i) {
				 System.out.println(i+b);
			}
			
		}
	}
	
	public static void doProcessJava7(int i, Process7 p) {
		p.process7(i);
	}
	
}

interface Process7 {
	void process7(int i);
}*/