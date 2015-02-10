/*VarArgsDriver.  (10 points)  Create a driver class with an executable main method 
 * called VarArgsDriver.java.  Call a method from main called getLowHigh with 
 * the following signature: 
 * private static String getLowHigh(String... strArgs)
 * getLowHigh returns a string that represents the low and high values of a variable 
 * series of strings, for example
 * System.out.println(getLowHigh("Vancouver", "Philly", "New York", "Chicago", "Los Angeles", "Miami", "Oakland")); 
 * will print: Chicago and Vancouver
 * to the console.  
 */
public class VarArgsDriver {

	public static void main(String[] args) {
		System.out.println(getLowHigh("Vancouver", "Philly", "New York", "Chicago", "Los Angeles", "Miami", "Oakland"));

	}//end main
	
	
	private static String getLowHigh(String... strArgs){
		String low = strArgs[0];
		String high = strArgs[0];
		
		for (int i=0; i<strArgs.length; i++){
			if (low.compareTo(strArgs[i]) > 0){low = strArgs[i];}
			if(high.compareTo(strArgs[i]) < 0) {high = strArgs[i];}
		}
			return low + " and " + high;
		
	}



}//end class
