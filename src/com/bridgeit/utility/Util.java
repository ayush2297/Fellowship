package com.bridgeit.utility;

import com.bridgeit.utility.Utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Util {
	
	static Utility utility = new Utility();
	
	File file = new File("/home/user/example.txt");
	Scanner sc = new Scanner(System.in);

	/**
	 * Purpose: Read String from the user using Scanner class
	 * 
	 * @return the String read from the user
	 */
	public String readString() {
		return sc.next();
	}

	/**
	 * Purpose: Read integer from the user using Scanner class
	 * 
	 * @return the integer read from the user
	 */
	public int readInteger() {
		return sc.nextInt();
	}

	/**
	 * Purpose: Read float from the user using Scanner class
	 * 
	 * @return the float read from the user
	 */
	public float readFloat() {
		return sc.nextFloat();
	}

	/**
	 * Purpose: Read double from the user using Scanner class
	 * 
	 * @return the double read from the user
	 */
	public double readDouble() {
		return sc.nextDouble();
	}

	/**
	 * Purpose: Read boolean from the user using Scanner class
	 * 
	 * @return the boolean read from the user
	 */
	public boolean readBoolean() {
		return sc.nextBoolean();
	}
	
	/**
	 * Purpose: read an integer array from the user
	 * 
	 * @return: integer array
	 */
	public int[] getIntegerArray() {
		System.out.println("enter the number of elements " + "you want to enter in you array: ");
		int elementsCount = readInteger();
		int returnArray[] = new int[elementsCount];
		for (int i = 0; i < elementsCount; i++) {
			returnArray[i] = readInteger();
		}
		return returnArray;
	}
	
	/**
	 * Purpose: Read a string array from user
	 * 
	 * @return	string array
	 */
	public String[] getStringArray() {
		System.out.println("enter the number of elements you want to insert: ");
		int num =readInteger();
		String[] arrToBeReturned = new String[num]; 
		for(int i=0;i<num ; i++) {
			arrToBeReturned[i] = readString();
		}
		return arrToBeReturned;
	}
	
	public void showIntegerArray(int[] arrayName) {
		for(int i=0; i<arrayName.length;i++) {
			System.out.println(arrayName[i]);
		}
	}
	
	public void showStringArray(String[] arrayName) {
		for(int i=0; i<arrayName.length;i++) {
			System.out.println(arrayName[i]);
		}
	}

	/**
	 * 
	 * @param firstString  first string entered by user
	 * @param secondString second string entered by user
	 * @return true if strings are anagrams false if strings are not anagrams
	 */
	public static boolean checkAnagram(String firstString, String secondString) {
		char[] charArrForFirstString = firstString.toCharArray();
		char[] charArrForSecondString = secondString.toCharArray();
		int firstArrLen = charArrForFirstString.length;
		int secondArrLen = charArrForSecondString.length;
		if (firstArrLen != secondArrLen)
			return false;
		Arrays.sort(charArrForFirstString);
		Arrays.sort(charArrForSecondString);
		for (int i = 0; i < firstArrLen; i++) {
			if (charArrForFirstString[i] != charArrForSecondString[i])
				return false;
		}
		return true;
	}

	/**
	 * Purpose: check whether a given string is palindrome or not
	 * 
	 * @param firstString String to be checked for palindrome condition
	 * @return true if firstString is palindrome false if firstString is not
	 *         palindrome
	 */
	public static boolean checkPalindrome(String firstString) {
		int firstStringLen = firstString.length();
		if (firstStringLen == 0 || firstStringLen == 1)
			return false;
		for (int i = 0; i < firstStringLen; i++, firstStringLen--) {
			if (firstString.charAt(i) != firstString.charAt(firstStringLen - 1))
				return false;
		}
		return true;
	}

	/**
	 * Purpose: To provide prime numbers between range low to high
	 * 
	 * @param low  lower range
	 * @param high upper range
	 */
	public int[] primeBetweenRange(int low, int high) {
		int storePrimes[] = new int[(high - low) / 2];
		Integer count = 0;
		for (int i = low; i < high; i++) {
			if (isPrime(i)) {
				storePrimes[count++] = i;
			}
		}
		return storePrimes;
	}

	/**
	 * Purpose: Determine whether the given number is prime or not
	 * 
	 * @param i number to be checked for prime number condition
	 * @return true if i is a prime number false if i is not a prime number
	 */
	public static boolean isPrime(int i) {
		if (i == 0 || i == 1) {
			return false;
		}
		for (int j = 2; j < i / 2; j++) {
			if (i % j == 0)
				return false;
		}
		return true;
	}

	/**
	 * Purpose: prints the array without zeros
	 * 
	 * @param arrayName array to be printed
	 */
	public static void showArrayWithoutZeros(int[] arrayName) {
		System.out.println("\nDisplaying all array elements:\n");
		for (int i = 0; i < arrayName.length && arrayName[i] != 0; i++) {
			System.out.println(arrayName[i]);
		}
	}

	/**
	 * Purpose: print all the anagrams from an array containing integers(prime nos)
	 * 
	 * @param primeArray integer array containing all prime numbers
	 */
	public static void primeAnagrams(int[] primeArray) {
		System.out.println();
		System.out.println("anagrams amongs all the obtained prime numbers are: \n");
		for (int i = 0; i < primeArray.length - 1 && primeArray[i] != 0; i++) {
			String original = Integer.toString(primeArray[i]);
			for (int j = i + 1; j < primeArray.length && primeArray[j] != 0; j++) {
				String checkAnagram = Integer.toString(primeArray[j]);
				if (checkAnagram(original, checkAnagram)) {
					System.out.println(original + " and " + checkAnagram + " are anagrams");
				}
			}
		}
	}

	/**
	 * Purpose: finds all the palindromes from an integer array
	 * 
	 * @param primeArray integer array
	 */
	public static void primePalindromes(int[] primeArray) {
		System.out.println();
		System.out.println("following are the palindromes : ");
		for (int i = 0; i < primeArray.length; i++) {
			String numberToString = Integer.toString(primeArray[i]);
			if (checkPalindrome(numberToString)) {
				System.out.println(numberToString + " is a prime palindrome number!");
			}
		}
	}

	
	
    /**
     * Purpose: Search an element in an integer array using binary search
     * 
     * @param 	arrayToBeSearched		input array
	 * @param 	numberToBeSearched		element to be searched in the array
	 * 
	 * @return							true if element is present in the array
	 * 									false if the element is not present in array
     */
 	public static boolean binarySearchInteger(int[] numberArray, int numberToSearch) {
		double start=Utility.timeInMillis();
		int low=0;
		int high=numberArray.length-1;
		int mid=(low+high)/2;
		
		while(low<=high) {
			
			if(numberArray[mid]<numberToSearch) {
				low=mid+1;
			} else if(numberArray[mid]==numberToSearch) {
				System.out.println("Element found at "+(mid+1)+"th position");
				double end=Utility.timeInMillis();
				System.out.println(utility.elapsedTime(start, end));
				return true;
			} else {
				high=mid-1;
			}
			mid=(low+high)/2;
		}
		
		if(low>high) {
			double end=Utility.timeInMillis();
			System.out.println("\nelapsed time: "+utility.elapsedTime(start, end));
			System.out.println("\nElement not found ");
		}
		return false;
	}

	/**
	 * Purpose: Searches a string element in a string array
	 * 
	 * @param 	stringArray			array of strings
	 * @param 	wordToSearch		string to be searched in string array
	 */
	public static boolean binarySearchString(String[] stringArray, String wordToSearch) {
		double start=Utility.timeInMillis();
		int low=0;
		int high=stringArray.length-1;
		int mid=(low+high)/2;
		while(low<=high) {
			if(stringArray[mid].compareTo(wordToSearch)<0) {
				low=mid+1;
			} else if(stringArray[mid].compareTo(wordToSearch)==0) {
				System.out.println("String found at "+(mid+1)+" position");
				double end=Utility.timeInMillis();
				System.out.println("\nelapsed time: "+utility.elapsedTime(start, end));
				return true;
			} else {
				high=mid-1;
			}
			mid=(low+high)/2;
		}
		if(low>high) {
			double end=Utility.timeInMillis();
			System.out.println(utility.elapsedTime(start, end));
			System.out.println("\nString not found ");
		}
		return false;
	}

	/**
	 * Purpose:	Sorts integer array using insertion sort
	 * 
	 * @param 		numberArray		array of integers
	 */
	public static int[] insertionSortInteger(int[] numberArray) {
		double start=Utility.timeInMillis();
		for(int i=1;i<numberArray.length;i++) {
			int key=numberArray[i];
			int j=i-1;
			while(j>=0 && numberArray[j]>key) {
				numberArray[j+1]=numberArray[j];
				j--;
			}
			numberArray[j+1]=key;
		}
		double end=Utility.timeInMillis();
		System.out.println("\nelapsed time: "+utility.elapsedTime(start, end));
		System.out.println();
		return numberArray; 
	}

	/**
	 * Purpose:	Sorts string array using insertion sort
	 * 
	 * @param 		stringArray		array of strings
	 */
	public static String[] insertionSortString(String[] stringArray) {
		double start=Utility.timeInMillis();
		for(int i=1;i<stringArray.length;i++) {
			String key=stringArray[i];
			int j=i-1;
			while(j>=0 && stringArray[j].compareTo(key)>0) {
				stringArray[j+1]=stringArray[j];
				j--;
			}
			stringArray[j+1]=key;
		}
		double end=Utility.timeInMillis();
		System.out.println("\nelapsed time: "+utility.elapsedTime(start, end));
		System.out.println();
		return stringArray;
	}

	/**
	 * Purpose: Sorts an integer array using bubble sort
	 * @param 		numberArray			array of integers
	 */
	public static int[] bubbleSortInteger(int[] numberArray) {
		double start=Utility.timeInMillis();
		for(int i=0;i<numberArray.length;i++) {
			for(int j=0;j<numberArray.length-1;j++) {
				int k=j+1;
				if(numberArray[j]>numberArray[k]) {
					int temp=numberArray[j];
					numberArray[j]=numberArray[k];
					numberArray[k]=temp;	
				}
			}
		}
		double end=Utility.timeInMillis();
		System.out.println("\nelapsed time: "+utility.elapsedTime(start, end));
		return numberArray;
	}

	/**
	 * Purpose: Sorts a string array using bubble sort
	 * @param 		stringArray		array of strings
	 */
	public static String[] bubbleSortString(String[] stringArray) {
		double start=Utility.timeInMillis();
		for(int i=0;i<stringArray.length;i++) {
			for(int j=0;j<stringArray.length-1;j++) {
				int k=j+1;
				if(stringArray[j].compareTo(stringArray[k])>0) {
					String temp=stringArray[j];
					stringArray[j]=stringArray[k];
					stringArray[k]=temp;	
				}
			}
		}
		double end=Utility.timeInMillis();
		System.out.println("\nelapsed time: "+utility.elapsedTime(start, end));
		return stringArray;
	}

	/**
	 * Purpose: Reads a file
	 * 
	 * @return	file
	 */
	public File readFile() 
	{
		return file;
	}

	/**
	 * Purpose: Perform search and sort operations on files
	 *  
	 * @param 		fileToSearch			the file to be used	
	 * @throws 		FileNotFoundException	if no file present
	 */
	public void findInFile(File fileToSearch) throws FileNotFoundException {
		Scanner sc=new Scanner(fileToSearch);
		sc.useDelimiter(",");
		String store="";
		while(sc.hasNext()) {
			store=store+sc.next()+",";
		}
		String[] fileWords = store.split(",");
		Arrays.sort(fileWords);
		System.out.println("\nenter the word you want to search : ");
		String wordToSearch=readString();
		System.out.println("\nBinary search:");
		binarySearchString(fileWords, wordToSearch);
		System.out.println("\nsorting the words in the file using insertion sort::::");
		insertionSortString(fileWords);
		System.out.println("\nSorting the words in the file using bubble sort:::");
		bubbleSortString(fileWords);
	}

	/**
	 * Purpose: perform temperature conversion
	 */
	public void temperatureConverter() {
		int ch;
		do {
			System.out.println("\n\nEnter a choice:\n1.deg.celc. to farh.\n2.fahr. to deg.celc.\n3.EXIT\n");
			ch = readInteger();
			switch(ch){
				case 1: 
					System.out.println("enter temperature in degree celsius: ");
					int deg = readInteger();
					int f = (deg*9/5)+32;
					System.out.println("\nTemperature in Fahrenheit: "+f);
					break;
				case 2:
					System.out.println("enter temperature in Fahrenheit: ");
					int fah = readInteger();
					int c = (fah-32)*5/9;
					System.out.println("\nTemperature in Degree Celsius: "+c);
					break;
				case 3:
					break;
				default:
					System.out.println("\nWrong input ..... please try again\n");	
			}
		}while(ch!=3);
	}

	/**
	 * Purpose: Find the square root of a number
	 * @param 	number		number whose square root is to be found
	 * @return				square root of the number
	 */
	public double sqrt(double number) {
		double t= number;
		double eps = 1e-15;
		double epst = eps*t;
		do {
			t =((number/t)+t)/2;
		}while(Math.abs(t-(number/t))>epst);
		return t;	
	}

	/**
	 * Purpose: To convert decimal to binary and swap nibbles
	 * @param 	number		decimal number input
	 */
	public void toBinary(int number) {
		int i=0;
		int binArray[] = new int[15] ;
		while(number!=0) {
			int a = number%2;
			binArray[i] = a;
			number = number/2;
			i++;
		}
		System.out.println("binary representation:");
		for(int j = 7 ; j>=0 ; j--) {
			System.out.print(binArray[j]);
			if(j==4) {
				System.out.print("\n");
			}
		}
		System.out.println("\nAfter swapping\n");
		
		for(int j = 0 ; j<=7 ; j++) {
			System.out.print(binArray[j]);
			if(j==3) {
				System.out.print("\n");
			}
		}
		System.out.println("\n again to number:");
		double sum =0;
		int l =7 ;
		for(int k = 0; k<=7;k++) {
			sum = sum + binArray[k] * Math.pow(2.00, (double)l);
			l--;
		}
		System.out.println("\nnumber is "+sum);
	}
	 
}
