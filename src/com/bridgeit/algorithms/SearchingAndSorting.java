/******************************************************************************
 *  Purpose: Searching and sorting operations on arrays
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   20-10-2019
 *
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.Util;

public class SearchingAndSorting {

	public static void main(String[] args) {

		Util utility = new Util();
		int choice;
		do {
			System.out.println("\n\n1.Binary search (integers)\n2.Binary search (string)"
					+ "\n3.Insertion sort (integers)\n4.Insertion sort (string)\n"
					+ "5.Bubble sort(integers)\n6.Bubble sort(string)\n"
					+ "0.EXIT\nEnter your choice: ");
			choice = utility.readInteger();
			switch(choice) {
			case 1:
			{
				int[] arrayToBeSearched = utility.getIntegerArray();
				System.out.println("enter you number to be searched: ");
				int numberToBeSearched = utility.readInteger();
				System.out.println("searching");
				if(utility.binarySearchInteger(arrayToBeSearched, numberToBeSearched))
					System.out.println();
				else
					System.out.println("not found");
				break;
			}
			case 2:
			{
				String[] arrayToBeSearched = utility.getStringArray();
				System.out.println("enter you number to be searched: ");
				String stringToBeSearched = utility.readString();
				System.out.println("searching");
				if(utility.binarySearchString(arrayToBeSearched, stringToBeSearched))
					System.out.println();
				else
					System.out.println("not found");
				break;
			}
			case 3:
			{
				int[] arrayToBeSorted = utility.getIntegerArray();
				int[] sorted = utility.insertionSortInteger(arrayToBeSorted);
				utility.showIntegerArray(sorted);
				break;
			}
			case 4:
			{
				String[] arrayToBeSorted = utility.getStringArray();
				String[] sorted = utility.insertionSortString(arrayToBeSorted);
				utility.showStringArray(sorted);
				break;
			}	
			case 5:
			{
				int[] arrayToBeSorted = utility.getIntegerArray();
				int[] sorted = utility.bubbleSortInteger(arrayToBeSorted);
				utility.showIntegerArray(sorted);
				break;
			}
			case 6:
			{
				String[] arrayToBeSorted = utility.getStringArray();
				String[] sorted = utility.bubbleSortString(arrayToBeSorted);
				utility.showStringArray(sorted);
				break;
			}
			}
		}while(choice!=0);
	}
}
