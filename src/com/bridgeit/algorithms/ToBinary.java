/******************************************************************************
 *  Purpose: Find the binary representation of the decimal number
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   20-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.Util;

public class ToBinary {

	public static void main(String[] args) {
		Util utility = new Util();
		System.out.println("Enter a number : ");
		int number = utility.readInteger();
		utility.toBinary(number);
	}

}
