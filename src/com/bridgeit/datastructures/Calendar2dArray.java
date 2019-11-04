package com.bridgeit.datastructures;

import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;

public class Calendar2dArray {

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		int day = 1;
		int dayToPrint=UtilityAlgorithms.dayOfWeek(month, day, year);
		UtilityDataStructures.buildCalendar(dayToPrint,month,year);
	}

}
