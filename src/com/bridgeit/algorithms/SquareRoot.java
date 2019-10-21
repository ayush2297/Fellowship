/******************************************************************************
 *  Purpose: Find the square root of the given number
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   20-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.Util;

public class SquareRoot {

	public static void main(String[] args) {
		Util utility = new Util();
		System.out.println("enter the number you want to find square root of: ");
		double number = utility.readDouble();
		double root = utility.sqrt(number);
	}

}
