/******************************************************************************
 *  Purpose: From a String replace a word with another word specified by user 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class NameReplace {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String greetingString = "Hello USERNAME, how are you?";
		System.out.println("Enter the username: ");
		String username = utility.readString();
		System.out.println(utility.replaceString(greetingString,"Hello", username));	
	}
}
