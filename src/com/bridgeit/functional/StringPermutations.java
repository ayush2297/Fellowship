/******************************************************************************
 *  Purpose: permutations of a string
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Util;

public class StringPermutations {

	public static void main(String[] args) {
		System.out.println("enter the string for which you want permutations:");
		String originalString = Util.readString();
		String differentPermutations = "";
		Util.formPermutations(differentPermutations,originalString);
	}

}
