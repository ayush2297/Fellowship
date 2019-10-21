package com.bridgeit.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import com.bridgeit.utility.Utility;

public class TryingGenericUtility {
	static Utility utility = new Utility();
	static Scanner sc = new Scanner(System.in);
	

	public <T> T readGeneric() {
		return (T) sc.next();
	}

	public static<T> void swap (T first, T second) {
		T temp = second;
		second = first;
		first = temp;
	}
	
	/**
	 * Purpose: read an array from the user
	 * 
	 * @return: array read from the user
	 */
	public <T> T[] getGenericArray() {
		System.out.println("enter the number of elements " + "you want to enter in you array: ");
		int elementsCount = utility.readInteger();
		T returnArray[] = (T[]) new Comparable[elementsCount];
		System.out.println("enter the elements:\n");
		for (int i = 0; i < elementsCount; i++) {
			returnArray[i] = readGeneric();
		}
		return returnArray;
	}
	
	/**
	 * Purpose: prints all the array elements
	 * 
	 * @param arrayName array to be printed
	 */
	public static <T> void showArray(T[] arrayName) {
		System.out.println("\nDisplaying all array elements:\n");
		for (int i = 0; i < arrayName.length; i++) {
			System.out.println(arrayName[i]);
		}
	}

	
	/**
	 * Purpose: Search an element from a sorted string or integer array using 
	 * 			binary search
	 *   
	 * @param 	<T>						using generic type
	 * @param 	arrayToBeSearched		input array
	 * @param 	numberToBeSearched		element to be searched in the array
	 * 
	 * @return							true if element is present in the array
	 * 									false if the element is not present in array
	 */
	public static <T extends Comparable<T>> boolean binarySearch(T[] arrayToBeSearched, T numberToBeSearched) {
		double start = Utility.timeInMillis()*10000;
		int low = 0;
		int high = arrayToBeSearched.length;
		int mid =(low + high) / 2;
		do {
			System.out.println("low:"+low+"\thigh:"+high+"mid:"
					+ ""+mid+"\tmid elem:"+arrayToBeSearched[mid]);
			if (arrayToBeSearched[mid].compareTo(numberToBeSearched) == 0) {
				System.out.println("number found at "+(mid+1)+" position");
				double end = utility.timeInMillis()*10000;
				System.out.println(utility.elapsedTime(start, end));
				return true;
			} else if (arrayToBeSearched[mid].compareTo(numberToBeSearched) < 0) {
				low = mid+1;
			} else {
				high = mid-1;
			}
			mid = (low + high) / 2;
		} while (low <= high);
		double end = utility.timeInMillis()*10000;
		System.out.println(utility.elapsedTime(start, end));
		System.out.println("not found!");
		return false;
	}
	
	/**
	 * Purpose: Sort an array using insertion sort algorithm
	 *   
	 * @param 	<T>						using generic type
	 * @param 	arrayToBeSearched		input array
	 * @return							sorted array
	 */
	public static<T extends Comparable<T>> T[] insertionSortGeneric(T[] arrayToBeSorted) {
		for(int i=1; i<arrayToBeSorted.length;i++) {
			T key = arrayToBeSorted[i];
			int j=i-1;
			while(j>=0 && (arrayToBeSorted[j].compareTo(key)>0)) {
				arrayToBeSorted[j+1]=arrayToBeSorted[j];
				j--;
				System.out.println("for j = "+j);
				showArray(arrayToBeSorted);
			}
			arrayToBeSorted[j+1]=key;
			System.out.println("for i = " +i);
			showArray(arrayToBeSorted);
		}
		return arrayToBeSorted;
	}

	/**
	 * Purpose: Sort an array using selection sort algorithm
	 *   
	 * @param 	<T>						using generic type
	 * @param 	arrayToBeSearched		input array
	 * @return							sorted array
	 */
	public static<T extends Comparable<T>>T[] selectionSortGeneric(T[] arrayToBeSorted) {
		for(int i=0; i<arrayToBeSorted.length-1;i++) {
			for(int j=i+1;j<arrayToBeSorted.length;j++) {
				if(arrayToBeSorted[j].compareTo(arrayToBeSorted[i])<0) {
					T temp = arrayToBeSorted[j];
					arrayToBeSorted[j] = arrayToBeSorted[i];
					arrayToBeSorted[i] = temp;
				}
			}
		}
		return arrayToBeSorted;
	}

	/**
	 * Purpose: Sort an array using bubble sort algorithm
	 *   
	 * @param 	<T>						using generic type
	 * @param 	arrayToBeSearched		input array
	 * @return							sorted array
	 */
	public static <T extends Comparable<T>>T[] bubbleSortGeneric(T[] arrayToBeSorted) {
		for(int i=0; i<arrayToBeSorted.length;i++)
		{
			for(int j=0; j<arrayToBeSorted.length-1;j++) {
				int k = j+1;
				if(arrayToBeSorted[j].compareTo(arrayToBeSorted[k])>0) {
					T temp = arrayToBeSorted[k];
					arrayToBeSorted[k] = arrayToBeSorted[j];
					arrayToBeSorted[j] = temp;	
				}
			}
		}
		return arrayToBeSorted;
	}

	/**
	 * Purpose: read file
	 * 
	 * @return	file
	 */
	public File readFile() {
		File file = new File("/home/user/example.txt");
		return file;
	}

	/**
	 * Purpose: find a word in a file usiin binary search algorithm
	 *   
	 * @param 	<T>						using generic type
	 * @param 	fileToSearch			input file
	 * @return							if word was found in file or not
	 */
	public <T extends Comparable<T>>void findInFile(File fileToSearch) throws FileNotFoundException {
		Scanner sc1 = new Scanner(fileToSearch);
		sc1.useDelimiter(",");
		String store = "";
		while(sc1.hasNext()) {
			store = store + sc1.next()+"," ;
		}
		T [] fileWords = (T[]) store.split(",");
		Arrays.sort(fileWords);
		System.out.println("enter the word you want to search in example.txt: ");
		T wordToBeFound = readGeneric();
		binarySearch(fileWords, wordToBeFound);
	}

	public int readInteger() {
		return sc.nextInt();
	}

}
