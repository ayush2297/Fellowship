/******************************************************************************
 *  Purpose: Calendar implementation using Stack Week and WeekDays class
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   4-11-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;

import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;

public class CalendarStack {

	public static void main(String[] args) {
		System.out.println("enter the month: ");
		int month = UtilityAlgorithms.readInteger();
		System.out.println("enter the year: ");
		int year = UtilityAlgorithms.readInteger();
		UtilityDataStructures.formCalendarStack(month,year);
	}

}
