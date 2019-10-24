/******************************************************************************
 *  Purpose: To find whether two strings are anagram or not
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   19-10-2019
 *
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class Anagram {

	public static void main(String[] args) {
		UtilityAlgorithms utility = new UtilityAlgorithms();
		System.out.println("Enter two strings to check if they are anagram or not: ");
		String firstString = utility.readString();
		String secondString = utility.readString();
		
		//boolean isAnagram = utility.checkAnagram(firstString, secondString);
		if(utility.checkAnagram(firstString, secondString)) {
			System.out.println("ANAGRAM!!");
		} else {
			System.out.println("NOT AN ANAGRAM!!");
		}
	}

}
