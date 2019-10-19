/******************************************************************************
 *  Purpose: To calculate and print the nth harmonic number 
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class HarmonicNumber {

	public static void main(String[] args) {
		Utility utility = new Utility();
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
