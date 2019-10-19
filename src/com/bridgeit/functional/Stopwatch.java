/******************************************************************************
 *  Purpose: Perform stopwatch operations
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   19-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class Stopwatch {

	public static void main(String[] args) {
		Utility utility = new Utility();
		
		System.out.println("press any key to start stopwatch: ");
		String str = utility.readString();
		double startTime = utility.timeInMillis();
		
		System.out.println("\npress any key to stop stopwatch: ");
		String str1 = utility.readString();
		double endTime = utility.timeInMillis();
		
		System.out.println("\n\nELAPSED TIME:\n"
				+ "Milliseconds:\t"+utility.elapsedTime(startTime, endTime)
				+"\nSeconds:\t"+(utility.elapsedTime(startTime, endTime)/1000));
	}

}
