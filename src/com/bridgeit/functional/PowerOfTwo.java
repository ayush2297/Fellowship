/******************************************************************************
 *  Purpose: To calculate and print all values from 2^0 to 2^n 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityFunctional;

public class PowerOfTwo {

	public static void main(String[] args) {
		UtilityFunctional utility = new UtilityFunctional();
		int power = Integer.parseInt(args[0]);
		if(power<31 && power>=0)
			utility.twoRaisedTo(power);
		else
			System.out.println("wrong input!! Max power allowed is 32");
	}

}
