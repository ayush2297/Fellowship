/******************************************************************************
 *  Purpose: flip a coin for specified number of times and display the result 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class FlipCoin {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("how many times you want to flip the coin? ");
		int count = utility.readInteger();
		utility.flipCoin(count);
	}

}
