/******************************************************************************
 *  Purpose: To calculate and print the nth harmonic number 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityFunctional;

public class HarmonicNumber {

	public static void main(String[] args) {
		UtilityFunctional utility = new UtilityFunctional();
		while(true) {
			System.out.println("enter n for calculating the nth harmonic number: ");
			double num = utility.readDouble();
			if(num!=0) {
				System.out.println(utility.calculateHarmonicValue(num));
				break;
			}
			else
				System.out.println("n should not be zero!! Try again");
		}
	}

}
