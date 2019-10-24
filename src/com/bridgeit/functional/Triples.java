/******************************************************************************
 *  Purpose: Find the triplets from an array
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   18-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityFunctional;

public class Triples {

	public static void main(String[] args) {
			UtilityFunctional utility = new UtilityFunctional();
			int[] numberArray = utility.getArray();
			utility.findTriples(numberArray);
	}
}
