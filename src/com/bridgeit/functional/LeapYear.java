/******************************************************************************
 *  Purpose: To find out whether the year entered is a leap year or not 
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class LeapYear {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the year : ");
		int year = utility.getYear();
		if(utility.isLeap(year)) 
			System.out.println(year+ " is a leap year!");
		else	
			System.out.println(year+" is not a leap year!");
	}
}