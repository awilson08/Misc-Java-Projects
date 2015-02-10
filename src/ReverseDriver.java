import java.util.Scanner;



/*Create a driver class with an executable main method called ReverseDriver.java.  
 * Call a method from main called reverso (private static) that prints the reverse words 
 * to the console using System.out.println(). reverso may either return a String which 
 * you then print using System.out in main, or reverso may return void and call System.out 
 * itself.  Passing in "yoda says force the is strong" to reverso along with other possible 
 * parameters results in "strong is the force says yoda". You must implement this method 
 * recurisvely.*/

public class ReverseDriver {
	static String returned = null;
	public static void main(String[] args) {
		System.out.println("Please enter a String:");
		Scanner S = new Scanner(System.in);
		String uInput = S.nextLine();
		//String [] sArray = input.split(" ")
		System.out.println(reverso(uInput));
		
	}//end main

	private static String reverso(String input){
		int numwords = input.indexOf(" "); 
		
		if(numwords == -1){return input;}
		    
		return reverso(input.substring(numwords + 1)) + " " + input.substring(0, numwords);
	}
		
		
		
		//for (int i = 0; i<sArray.length; i++){ System.out.print(sArray[i] + " ");}
		
	
}//end class
