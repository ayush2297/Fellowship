/******************************************************************************
 *  Purpose: To create and display two dimensional arrays of various data types
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   18-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class TwoDimArrays {

	public static void main(String[] args) {
		Utility utility = new Utility();
		int choice;
		do {
			System.out.println("1.integer array\n2.double array\n"
					+ "3.boolean array\n0.exit\nENTER YOUR CHOICE::");
			choice = utility.readInteger();
			switch(choice) {
			case 1:
				int[] dimI = utility.getTwoDimensions();
				Integer intArray[][] = utility.readTwoDimIntArray(dimI);
				utility.showTwoDimIntArray(intArray);
				break;
			case 2:
				int[] dimD = utility.getTwoDimensions();
				Double[][] doubleArray = utility.readTwoDimDoubleArray(dimD);
				utility.showTwoDimIntArray(doubleArray);
				break;
			case 3:
				int[] dimB = utility.getTwoDimensions();
				Boolean boolArray[][] = utility.readTwoDimBooleanArray(dimB);
				utility.showTwoDimIntArray(boolArray);
				break;
			default:
				System.out.println("wrong choice !! Try again..");	
			}
		}while(choice!=0);
	}
}
