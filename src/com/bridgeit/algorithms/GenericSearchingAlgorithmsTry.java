/******************************************************************************
 *  Purpose: Trying generic functions for searching and sorting algorithms
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   20-10-2019
 *
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.TryingGenericUtility;

public class GenericSearchingAlgorithmsTry {

	public static <T extends Comparable<T>> void main(String[] args) {
		TryingGenericUtility utility = new TryingGenericUtility();
		int choice;
		do {
			System.out.println("\n\n1.Binary search (integers)\n2.Binary search (string)"
					+ "\n3.Insertion sort (integers)\n4.Insertion sort (string)"
					+ "\n5.Selection sort(integers)\n6.Selection sort(string)\n"
					+ "7.Bubble sort(integers)\n8.Bubble sort(string)\n"
					+ "0.EXIT\nEnter your choice: ");
			choice = utility.readInteger();
			switch(choice) {
			case 1:
			case 2:
				{
					T[] arrayToBeSearched = utility.getGenericArray();
					System.out.println("enter you number to be searched: ");
					T numberToBeSearched = utility.readGeneric();
					System.out.println("searching");
					if(utility.binarySearch(arrayToBeSearched, numberToBeSearched))
						System.out.println();
					else
						System.out.println("not found");
					break;
				}
			case 3:
			case 4:
				{
					T[] arrayToBeSorted = utility.getGenericArray();
					T[] sorted = utility.insertionSortGeneric(arrayToBeSorted);
					utility.showArray(sorted);
					break;
				}
			case 5: 
			case 6:
				{
					T[] arrayToBeSorted = utility.getGenericArray();
					T[] sorted = utility.selectionSortGeneric(arrayToBeSorted);
					utility.showArray(sorted);
					break;
				}
			case 7: 
			case 8:
				{
					T[] arrayToBeSorted = utility.getGenericArray();
					T[] sorted = utility.bubbleSortGeneric(arrayToBeSorted);
					utility.showArray(sorted);
					break;
				}
			}
		}while(choice!=0);
		
	}

}
