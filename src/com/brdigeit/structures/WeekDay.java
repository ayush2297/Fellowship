/******************************************************************************
 *  Purpose: Day in a week implementation for calendar using Queue 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   4-11-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;

import com.bridgeit.utility.UtilityAlgorithms;

public class WeekDay {

	
	public String day = null;
	public int date = 0;
	
	/**
	 * Purpose: initialize Weekday object with default (null) values
	 */
	public WeekDay(){
		this.day = null;
		this.date = 0;
	}
	
	/**
	 * Purpose: Initialize Weekday object with with particular day and date
	 * @param dayToInsert
	 * @param dateToInsert
	 */
	public WeekDay(String dayToInsert, int dateToInsert){
		this.day = dayToInsert;
		this.date = dateToInsert;
	}

	
}
