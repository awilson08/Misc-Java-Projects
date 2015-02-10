import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/* ReflectDriver.  (10 points)  Create a class that takes a string from the user in the form of a 
 * fully-qualified class name. Modify the code from edu.uchicago.cs.java.lec05.reflection from lec05.tar. 
 * ReflectDriver will use reflection to inspect and print out any constants or normal fields of a class 
 * like so:
 * input> java.lang.Math
 * output> class java.lang.Math
{
//PUBLIC STATIC FINAL FIELDS (CONSTANTS)
   public static final double E;
   public static final double PI;
//OTHER FIELDS
   private static java.util.Random randomNumberGenerator;
   private static long negativeZeroFloatBits;
   private static long negativeZeroDoubleBits;
 */
public class ReflectDriver {

	public static void main(String[] args) {
		while (true) {
			String strInput;
			Scanner scn = new Scanner(System.in);
			
			System.out.println("Enter class name (e.g. 'java.util.Date') or 'exit' to quit: ");		
			strInput = scn.next();
			if (strInput.equalsIgnoreCase("exit"))
				break;


			try {
				// print class name and superclass name (if != Object)

				//instantiate the class and superclass objects 
				Class cls = Class.forName(strInput);
				Class clsSuper = cls.getSuperclass();

				//first line
				System.out.print("class " + strInput);
				//if (clsSuper != null && clsSuper != Object.class)
				if (clsSuper != null)


				System.out.print("\n{\n");
				System.out.println("PUBLIC STATIC FINAL FIELDS (CONSTANTS)");
				printFinalFields(cls);
				System.out.println("//OTHER FIELDS");
				printOtherFields(cls);

				System.out.println("}");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				continue;
			}
			System.exit(0);
		}//end while
		System.out.println("Thank you for playing.");
	}


	/**
	 * Prints all fields of a class
	 * 
	 * @param cls
	 *            a class
	 */
	public static void printFinalFields(Class cls) {
		Field[] fldFields = cls.getDeclaredFields();

		for (Field fld : fldFields) {
			//let's check for final
			//String strMods = Modifier.toString(fld.getModifiers());
			Class clsType = fld.getType();
			String strName = fld.getName();
			
			if (Modifier.isFinal(fld.getModifiers())){
			System.out.print(" " + Modifier.toString(fld.getModifiers()) +  " ");
			System.out.println(" " + clsType.getName() + " " + strName + ";");
			}
			
		}
	}
	public static void printOtherFields(Class cls) {
		
		Field[] fldFields = cls.getDeclaredFields();
		for (Field fld : fldFields) {
			Class clsType = fld.getType();
			String strName = fld.getName();
			
			if (!Modifier.isFinal(fld.getModifiers())){
			System.out.print(" " + Modifier.toString(fld.getModifiers()) +  " ");
			System.out.println(" " + clsType.getName() + " " + strName + ";"); 
			}
			
		}
	}

}
