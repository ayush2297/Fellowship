/******************************************************************************
 *  Purpose: Week implementation for calendar using Queue and Week class
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   4-11-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;

import com.bridgeit.utility.UtilityAlgorithms;

public class Week {
	
	WeekDay addDay = new WeekDay();
	
	public Queue<WeekDay> singleDay = new Queue<WeekDay>();
	public Stack<WeekDay> singleDayStack = new Stack<WeekDay>();
	
	
	String daysOfWeek[] = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};
	
	int month;
	int year;
	int maxDays;
	int lastDate;
	private int minDate;
	
	/**
	 * Purpose: get day for the given date in integer
	 * 
	 * @param 	date		input date in dd
	 * @return				0-sun, 1-mon, 2-tues, ....
	 */
	public int getDayForDate(int date) {
		return UtilityAlgorithms.dayOfWeek(month, date, year);
	}
	
	/**
	 * Purpose: based on output of getDayForDate() prints day as string
	 * 
	 * @param 	input		integer between 0-6								
	 * @return				"sunday","monday","tuesday",......
	 */
	public String getDay(int date) {
		return daysOfWeek[date];
	}
	
	/**
	 * Purpose: initialize parameters for calendar using stack
	 * 
	 * @param 	endDate				this week ends with this date
	 * @param 	noOfDaysInMonth		max days in this month
	 * @param 	month				month in mm
	 * @param 	year				year in yyyy
	 * @param 	b					identifier for using stack to build calendar 
	 */
	public Week(int endDate, int noOfDaysInMonth,  int month, int year, boolean b) {
		this.month = month;
		this.year = year;
		this.minDate = 0;
		this.maxDays = noOfDaysInMonth;
		this.singleDayStack =  formWeekStack(endDate);
	}

	/**
	 * Purpose: form a week using stack
	 * 
	 * @param 	endDate		this week ends with this date
	 * @return				a week in stack
	 */
	private Stack<WeekDay> formWeekStack(int endDate) {
		if(endDate == maxDays) {
			enterLastWeekStack(endDate);
		} else {
			enterRemWeekStack(endDate);
		}
		return singleDayStack;
	}

	/**
	 * Purpose: forms weeks other than last week using stack
	 * 
	 * @param 	endDate		this week ends with this date
	 */
	private void enterRemWeekStack(int endDate) {
		int count =6;
		while(count>=0) {
			if(endDate<1) {
				WeekDay addDay = new WeekDay(daysOfWeek[count], 0);
				singleDayStack.push(addDay);
				count--;
			}else {
				WeekDay addDay = new WeekDay(daysOfWeek[count], endDate);
				singleDayStack.push(addDay);
				count--;
				endDate--;
			}
		}
	}

	/**
	 * Purpose: forms last week of calender using stack
	 *  
	 * @param 	endDate		last week ends with this date
	 */
	private void enterLastWeekStack(int endDate) {
		int temp = getDayForDate(endDate);
		int count =6;
		while(count>=0) {
			if(count>temp) {
				WeekDay addDay = new WeekDay(daysOfWeek[count], 0);
				singleDayStack.push(addDay);
				count--;
			}else {
				WeekDay addDay = new WeekDay(daysOfWeek[count], endDate);
				singleDayStack.push(addDay);
				count--;
				endDate--;
			}
		}
	}
	
//	**************Queue implementation
	
	/**
	 * Purpose: start building the week
	 * 
	 * @param 	startDate			the date at which this week starts
	 * @param 	month				month of calendar
	 * @param 	year				year of calendar
	 * @param 	noOfdaysInMonth		max days in this month
	 */
	public Week(int startDate, int month , int year, int noOfdaysInMonth) {
		this.month = month;
		this.year = year;
		this.maxDays = noOfdaysInMonth;
		this.singleDay =  formWeek(startDate);
	}
	
	/**
	 * Purpose: build a week
	 * 
	 * @param 	startDate	start date for the week
	 * @return				queue containing all the details of the week
	 */
	public Queue<WeekDay> formWeek(int startDate) {
		if(startDate == 1) {
			enterFirstWeek(startDate);
		} else {
			enterTheWeek(startDate);
		}
		return singleDay;
	}

	/**
	 * Purpose: first week of the month creation
	 * 
	 * @param 	startDate	start date of the week
	 */
	public void enterFirstWeek(int startDate) {
		int start = getDayForDate(startDate);
		int count = 0;
		while(count<7) {
			if(count<start) {
				addToWeek(daysOfWeek[count++],0);
			} else {
				addToWeek(daysOfWeek[count++],startDate++);
			}
		}
	}
	
	/**
	 * Purpose: form remaining weeks of the month
	 * 
	 * @param 	startDate	start date of the week
	 */
	public void enterTheWeek(int startDate) {
		int weekStart = startDate;
		int weekEnd = startDate+7;
		while(weekStart < weekEnd && weekStart<=maxDays) {
			int dayForDate = getDayForDate(weekStart);
			WeekDay addDay = new WeekDay(daysOfWeek[dayForDate], weekStart);
			singleDay.enqueue(addDay);
			weekStart++;
		}
	}
	
	/**
	 * Purpose: Date insertion logic for first week
	 * 
	 * @param 	daysOfWeek		day of week as in "sunday"/"monday"/....
	 * @param 	dateToEnter		date in dd
	 */
	public void addToWeek(String daysOfWeek, int dateToEnter) {
		WeekDay dayToAdd = new WeekDay(daysOfWeek, dateToEnter);
		singleDay.enqueue(dayToAdd);
	}
}
