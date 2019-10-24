/******************************************************************************
 *  Purpose: Find the day for a particular date
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class DaysOfWeek {

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int day = Integer.parseInt(args[1]);
		int year = Integer.parseInt(args[2]);
		int dayToPrint = UtilityAlgorithms.dayOfWeek(month, day, year);
		System.out.println(day+"/"+month+"/"+year+
				" falls on "+UtilityAlgorithms.printDay(dayToPrint));
	}

}
