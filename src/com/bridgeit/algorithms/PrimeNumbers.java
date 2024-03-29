/******************************************************************************
 *  Purpose: To find all the prime numbers in a range and display all the 
 *  		 anagrams and palindromes in them
 *
 *  @author  Ayush Saraf
 *  @version 1.0, 1.1
 *  @since   19-10-2019, 20-10-2019
 *
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class PrimeNumbers {

	public static void main(String[] args) {
		UtilityAlgorithms utility = new UtilityAlgorithms();
		System.out.println("enter lower limit of your range: ");
		int low = utility.readInteger();
		System.out.println("enter upper limit of your range: ");
		int high = utility.readInteger();
		int primeArray[]= utility.primeBetweenRange(low, high);
		utility.showArrayWithoutZeros(primeArray);
		utility.primeAnagrams(primeArray);
		utility.primePalindromes(primeArray);
	}

}
