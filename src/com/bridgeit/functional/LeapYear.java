/******************************************************************************
 *  Purpose: To find out whether the year entered is a leap year or not 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   17-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityFunctional;

public class LeapYear {

	public static void main(String[] args) {
		UtilityFunctional utility = new UtilityFunctional();
		System.out.println("Enter the year : ");
		int year = utility.getYear();
		if(utility.isLeap(year)) 
			System.out.println(year+ " is a leap year!");
		else	
			System.out.println(year+" is not a leap year!");
	}
}
