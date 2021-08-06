package com.java8.features;


public class ThisReferenceExample {
	
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		
		thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i is:"+i);
			//System.out.println(this);//this is possible in below anonymous inner class
			//lambda almost replaces anonymous inner class but not sure why it is not able to pass this reference
			//saying this cannot be used in static context
			//**important: You cannot use 'this' inside Lambda and inside static method, it cannot refer to the object reference, it is intentional 	
			//but you can use anonymous inner class
			});
		thisReferenceExample.execute();
	
	}
	public void doProcess(int i, ProcessThis p) {
		p.process(i);
	}
	public void execute() {
		System.out.println(this);//Here it will work
		//What we have say is this is always points to reference object 
		//you cannot use in above method because it is within static and it is not using reference at that point
	}
}

interface ProcessThis {
	void process(int i);
}

























/*public class ThisReferenceExample {
	
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, new ProcessThis() {
			@Override
			public void process(int i) {
				System.out.println("Value of i is"+i);
				System.out.println(this);
				//you can use 'this' at this point as you already created object and using that
				//object creation 'thisReferenceExample', this reference fot that is created 
			}
			
			public String toString() {
				return "This is the anonymous inner class";
			}
		});
	}
	
	public void doProcess(int i, ProcessThis p) {
		p.process(i);
	}
}

interface ProcessThis {
	void process(int i);
}
*/