/******************************************************************************
 *  Purpose: Palindrome finder using Dequeue
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   31-10-2019
 *
 ******************************************************************************/
package com.bridgeit.datastructures;

import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println("enter tyour string : ");
		String strToCheck = UtilityAlgorithms.readString();
		if( UtilityDataStructures.isPalindrome(strToCheck) ) {
			System.out.println("palindrome");
		}else {
			System.out.println("not a palindrome");
		}
	}

}
