/******************************************************************************
 *  Purpose: permutations of a string
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityAlgorithms;

public class StringPermutations {

	public static void main(String[] args) {
		System.out.println("enter the string for which you want permutations:");
		String originalString = UtilityAlgorithms.readString();
		String differentPermutations = "";
		//Util.formPermutationsRecursion(differentPermutations,originalString);
		UtilityAlgorithms.formPermutationsIteration(originalString);
	}

}
