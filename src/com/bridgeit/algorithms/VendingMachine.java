/******************************************************************************
 *  Purpose: Money vending machine
 *  
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class VendingMachine {

	public static void main(String[] args) {
		int note = 0;
		System.out.println("enter the amount that you want to withdraw: ");
		int amount = UtilityAlgorithms.readInteger();
		UtilityAlgorithms.getMoney(amount,note);
	}

}
