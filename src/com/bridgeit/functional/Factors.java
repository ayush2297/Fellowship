/******************************************************************************
 *  Purpose: To print the factors of the number 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityFunctional;

public class Factors {

	public static void main(String[] args) {
		UtilityFunctional utility = new UtilityFunctional();
		System.out.println("Enter the number: ");
		int number = utility.readInteger();
		if(utility.isPrime(number))
			System.out.println("There are no prime factors of prime number!");
		else
			utility.primeFactors(number);
	}

}
