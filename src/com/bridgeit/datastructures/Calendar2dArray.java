package com.bridgeit.datastructures;

import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;

public class Calendar2dArray {

	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		int day = 1;
		int year = Integer.parseInt(args[1]);
		int monthStartDay = UtilityAlgorithms.dayOfWeek(month, day, year);
		UtilityDataStructures.formCalendar(monthStartDay,month,year);
	}

}
