package edu.ycp.cs320.hobbyhub.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> package because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is not translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 * 
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
	public static boolean isValidPassword(String password) {
		// Create an array of characters based on the password
		char[] pass = new char[password.length()];
		pass = password.toCharArray();
		boolean letter = false;
		boolean number = false;
	
		// check to make sure it contains at least 1 number and letter
		// return false if it doesn't, else return true
		// put password into an array, compare each index to numbers
		for(int i = 0; i < pass.length; i++){
			if (pass[i] == '0' || pass[i] == '1' || pass[i] == '2'  ||  pass[i] == '3' || pass[i] == '4' 
					|| pass[i] == '5' || pass[i] == '6' || pass[i] == '7' || pass[i] == '8' || pass[i] == '9') {
				number = true;
			} 
			if (pass[i] == 'A' || pass[i] == 'B' || pass[i] == 'C'  ||  pass[i] == 'D' || pass[i] == 'E' 
					|| pass[i] == 'F' || pass[i] == 'G' || pass[i] == 'H' || pass[i] == 'I' || pass[i] == 'J' || pass[i] == 'K' 
					|| pass[i] == 'L' || pass[i] == 'M'  ||  pass[i] == 'N' || pass[i] == 'O' || pass[i] == 'P' 
					|| pass[i] == 'Q' || pass[i] == 'R' || pass[i] == 'S' || pass[i] == 'T' || pass[i] == 'U' || pass[i] == 'V' 
					|| pass[i] == 'W' || pass[i] == 'X' || pass[i] == 'Y' || pass[i] == 'Z') {
				letter = true;
			}
			if (pass[i] == 'a' || pass[i] == 'b' || pass[i] == 'c'  ||  pass[i] == 'd' || pass[i] == 'e' 
					|| pass[i] == 'f' || pass[i] == 'g' || pass[i] == 'h' || pass[i] == 'i' || pass[i] == 'j' || pass[i] == 'k' 
					|| pass[i] == 'l' || pass[i] == 'm'  ||  pass[i] == 'n' || pass[i] == 'o' || pass[i] == 'P' 
					|| pass[i] == 'q' || pass[i] == 'r' || pass[i] == 's' || pass[i] == 't' || pass[i] == 'u' || pass[i] == 'v' 
					|| pass[i] == 'w' || pass[i] == 'x' || pass[i] == 'y' || pass[i] == 'z') {
				letter = true;
			}
		}
		if(number == true && letter == true && password.length() > 5 == true){
			return true;
		}
		return false;
	}
}
