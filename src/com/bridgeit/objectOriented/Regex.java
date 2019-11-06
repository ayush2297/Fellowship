package com.bridgeit.objectOriented;

import com.bridgeit.utility.OopUtility;

public class Regex {

	public static void main(String[] args) {
		String ipString = "Hello <<name>>, We have your full\n" + 
				"name as <<full name>> in our system. your contact number is 91­-xxxxxxxxxx .\n" + 
				"Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.\n";
		OopUtility.useRegex(ipString);
	}

}
