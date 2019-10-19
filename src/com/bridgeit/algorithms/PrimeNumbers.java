/******************************************************************************
 *  Purpose: To calculate wind chill (effective temperature
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   19-10-2019
 *
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.Util;

public class PrimeNumbers {

	public static void main(String[] args) {
		Util utility = new Util();
		System.out.println("enter lower limit of your range: ");
		int low = utility.readInteger();
		System.out.println("enter upper limit of your range: ");
		int high = utility.readInteger();
		/*
		 * for(int i =0; i<1000;i++) { if(utility.isPrime(i)) {
		 * System.out.println((i+1)+"prime"); } else { System.out.println("not prime");
		 * } }
		 */
		utility.primeBetweenRange(low, high);
	}

}
