import java.util.Scanner;

	/**
	 Create a driver class with an executable main method called FibonacciDriver.java.  
	 Call a method from main called fibonacci (private static) that prints the sum of 
	 a fibonacci sequence  to the console using System.out.print. 
	 Get a number from the user and call System.out.println(fibonacci(nUserNumber)); 
	 from within main.  You must implement this method recurisvely. 
	 
	 	Example input: fib(13)
		Example output: 233

	 */


public class FibonacciDriver {
	
	public static void main(String[] args) {
		int nUserNumber=0;
	
		System.out.println("Please input a number:");
		Scanner S = new Scanner(System.in);
		try {nUserNumber = S.nextInt();}
		catch (Exception e){
			System.out.println("Please input a valid integer");
			System.exit(0);}
		
		
		System.out.println("Sum of fibonacci sequence: " + fib(nUserNumber));
		

	} //end main

	public static int fib (int n){
		if (n<=2){return 1;}
		else {return fib(n-1)+ fib(n-2);}
	}
	
}//end class
