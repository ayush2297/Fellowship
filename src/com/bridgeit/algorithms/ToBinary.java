/******************************************************************************
 *  Purpose: Find the binary representation of the decimal number
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class ToBinary {

	public static void main(String[] args) {
		UtilityAlgorithms utility = new UtilityAlgorithms();
		System.out.println("Enter a number : ");
		int number = utility.readInteger();
		utility.toBinary(number);
	}

}
