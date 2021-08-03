package com.java8.features;

public class TypeInferenceExample {
   public static void main(String[] args) {
	  
	   StringLengthLambda myLambda = (String s) -> s.length();//like assigning implementation to the interface
	   System.out.println(myLambda.getLength("Hello Lambda!"));//From here the string is passed to the getLength() method from there to above line and "returns" lengtho
	   
	   //OR 
	   
	   StringLengthLambda myLambda1 = s -> s.length();// you dont need to add this  (String s) ->  Java will understand that you are passing string 
	   //since Functional interface only have one method, after you assign the "s -> s.length()" to interface, java will match to the available interface method,which is getLength
	   System.out.println(myLambda1.getLength("Hello Lambda!EEE"));
	 //-----------------------------------------------------------------------------------------------------------------------------------------------
   
   }
   
   interface StringLengthLambda {
	   int getLength(String s);
   }
   
   
}
