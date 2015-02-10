/*VarArgsDriver2. (10 points)  Create a driver class with an executable main method called 
 * VarArgsDriver2.java.  Call a method from main called getReverseHigh() with the following signature: 
 * private static String getReverseHigh(String... strArgs). 
 * getReverseHigh should be implemented iteratively.  
 * Also, getReverseHigh calls a helper method called reverseCharsRec with the following signature 
 * public static String reverseCharsRec(String str) and this mehtod must be implemented recursively. 
 * getReverseHigh returns a string that represents the reverse characters of the high value of a 
 * variable series of strings, for example
 * System.out.println(getReverseHigh("Vancouver", "Philly", "New York", "Chicago", "Los Angeles", "Miami", "Oakland")); 
 * will print:
 * revuocnaV
 * to the console. 
*/
public class VarArgsDriver2 {

	
	public static void main(String[] args) {
		System.out.println(getReverseHigh("Vancouver", "Philly", "New York", "Chicago", "Los Angeles", "Miami", "Oakland"));

	}//end main
	
	private static String getReverseHigh(String... strArgs){
		String high = strArgs[0];
		for (int i=0; i<strArgs.length; i++){
			if(high.compareTo(strArgs[i]) < 0) {high = strArgs[i];}
		}
			return reverseCharsRec(high);
	}//end getReverseHigh
	
	public static String reverseCharsRec(String str){
		if ((str.length() <= 1)) {
			return str;
		}
		
		return reverseCharsRec(str.substring(1)) + str.charAt(0);
	}

}//end class
