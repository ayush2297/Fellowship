/******************************************************************************
 *  Purpose: Find the triplets from an array
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   18-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class Triples {

	public static void main(String[] args) {
			Utility utility = new Utility();
			int[] numberArray = utility.getArray();
			utility.findTriples(numberArray);
	}
}
