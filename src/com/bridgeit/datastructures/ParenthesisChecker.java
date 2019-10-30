/******************************************************************************
 *  Purpose: checking parentheses using stack implementation
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   30-10-2019
 *
 ******************************************************************************/
package com.bridgeit.datastructures;

import com.brdigeit.structures.Stack;
import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;

public class ParenthesisChecker {

	public static void main(String[] args) {
		UtilityDataStructures util = new UtilityDataStructures();
		System.out.println("enter you arithmatic expression:");
		String arithExpr = UtilityAlgorithms.readString();
		if(util.parenthesisCheck(arithExpr)) {
			System.out.println("parentheses are correct!");
		} else {
			System.out.println("incorrect parentheses!");
		}
	}

}
