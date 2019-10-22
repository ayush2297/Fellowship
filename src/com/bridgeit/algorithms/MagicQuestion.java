/******************************************************************************
 *  Purpose: Play number question game
 *  
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.Util;

public class MagicQuestion {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double range = Math.pow(2, n);
		System.out.println("select your number between 0 to "+(range-1));
		int numberChoice = Util.readInteger();
		Util.findNumber(numberChoice, range);
	}

}
