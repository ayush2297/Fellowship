/******************************************************************************
 *  Purpose: Find the square root of the given number
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   21-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class SquareRoot {

	public static void main(String[] args) {
		UtilityAlgorithms utility = new UtilityAlgorithms();
		System.out.println("enter the number you want to find square root of: ");
		double number = utility.readDouble();
		double root = utility.sqrt(number);
	}

}
