/******************************************************************************
 *  Purpose: Utility class for all algorithmic functions
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   18-10-2019
 *
 ******************************************************************************/
package com.bridgeit.utility;

import com.bridgeit.algorithms.MergeSort;
import com.bridgeit.utility.Utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Util {
	
	static Utility utility = new Utility();
	static Scanner sc = new Scanner(System.in);
	static int []  notes = {1000,500,100,50,20,10,5,2,1};
	
	static File file = new File("/home/user/example.txt");
	
	/**
	 * Purpose: Read String from the user using Scanner class
	 * 
	 * @return the String read from the user
	 */
	public static String readString() {
		return sc.next();
	}

	/**
	 * Purpose: Read integer from the user using Scanner class
	 * 
	 * @return the integer read from the user
	 */
	public static int readInteger() {
		return sc.nextInt();
	}

	/**
	 * Purpose: Read float from the user using Scanner class
	 * 
	 * @return the float read from the user
	 */
	public static float readFloat() {
		return sc.nextFloat();
	}

	/**
	 * Purpose: Read double from the user using Scanner class
	 * 
	 * @return the double read from the user
	 */
	public static double readDouble() {
		return sc.nextDouble();
	}

	/**
	 * Purpose: Read boolean from the user using Scanner class
	 * 
	 * @return the boolean read from the user
	 */
	public static boolean readBoolean() {
		return sc.nextBoolean();
	}
	
	/**
	 * Purpose: read an integer array from the user
	 * 
	 * @return: integer array
	 */
	public static int[] getIntegerArray() {
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
	public static String[] getStringArray() {
		System.out.println("enter the number of elements you want to insert: ");
		int num =readInteger();
		System.out.println("enter the elements: \n");
		String[] arrToBeReturned = new String[num]; 
		for(int i=0;i<num ; i++) {
			arrToBeReturned[i] = readString();
		}
		return arrToBeReturned;
	}
	
	public static void showIntegerArray(int[] arrayName) {
		for(int i=0; i<arrayName.length;i++) {
			System.out.println(arrayName[i]);
		}
	}
	
	public static void showStringArray(String[] arrayName) {
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
	public static int[] primeBetweenRange(int low, int high) {
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
	public static File readFile() 
	{
		return file;
	}

	/**
	 * Purpose: Perform search and sort operations on files
	 *  
	 * @param 		fileToSearch			the file to be used	
	 * @throws 		FileNotFoundException	if no file present
	 */
	public static void findInFile(File fileToSearch) throws FileNotFoundException {
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
	public static void temperatureConverter() {
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
	public static double sqrt(double number) {
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
	public static void toBinary(int number) {
		int binArray[] = new int[8] ;
		int arrLen = binArray.length;
		int position = arrLen-1;
		while(number!=0) {
			int a = number%2;
			binArray[position] = a;
			number = number/2;
			position--;
		}
		printBinary(binArray);
		System.out.println("\nAfter swapping\n");
		for(int j = 0; j<8/2;j++) {
			int temp = binArray[j];
			binArray[j] = binArray[4+j];
			binArray[4+j] = temp;
		}
		printBinary(binArray);
		System.out.println("\n again to number:");
		printToDecimal(binArray);
	}

	private static void printToDecimal(int[] binArray) {
		double sum =0;
		int l =7 ;
		for(int k = 0; k<binArray.length;k++) {
			sum = sum + binArray[k] * Math.pow(2.00, (double)l);
			l--;
		}
		System.out.println("\nnumber is "+sum);
	}

	private static void printBinary(int[] binArray) {
		System.out.println("binary representation:");
		for(int j = 0 ; j<binArray.length; j++) {
			System.out.print(binArray[j]);
			if(j==3) {
				System.out.print("\t");
			}
		}
	}

	/**
	 * Purpose: Find the day of the week for particular date
	 * @param 	month	mm
	 * @param 	day		dd
	 * @param	year	yyyy
	 * @return			0-sunday, 1-monday,....7-saturday
	 */
	public static int dayOfWeek(int month, int day, int year) {
		int y = year - (14-month)/12;
		int x = y+y/4-y/100+y/400;
		int m = month+12*((14-month)/12)-2;
		int d = (day+x+31*m/12);
		int finalDay= d%7;
		return finalDay;
	}

	/**
	 * Purpose: Display the day based on the output of dayOfWeek()
	 * @param 	dayToPrint		output from dayOfWeek()
	 * @return					day name
	 */
	public static String printDay(int dayToPrint) {
		switch (dayToPrint) {
		case 0:
			return "Sunday";
		case 1:
			return "monday";
		case 2:
			return "tuesday";
		case 3:
			return "wednesday";
		case 4:
			return "thursday";
		case 5:
			return "friday";
		case 6:
			return "saturday";
		}
		return null;
	}

	/**
	 * Purpose: Calculates the monthly payment
	 * 
	 * @param 	principal			initial amount
	 * @param 	year				number of years to repay
	 * @param 	rateOfInterest		interest per year on initial amount
	 * @return						monthly payment
	 */
	public static double monthlyPayment(double principal, double year, double rateOfInterest) {
		double rate = rateOfInterest/(12*100);
		double years = 12*year;
		double payment = (principal*rate)/(1-Math.pow((1+rate),(-years)));
		return payment;
	}

	/**
	 * Purpose: Begins the merge sort process
	 */
	public static void beginMergeSort() {
		String [] arrayToSort = getStringArray();
		int low =0;
		int high = arrayToSort.length-1;
		mergeSort(arrayToSort,low,high);
		for(String s : arrayToSort)
			System.out.print(s+" ");
	}
	
	/**
	 * Purpose: Produces sub arrays till smallest units (single elements) 
	 * 			are formed
	 *   
	 * @param 	arrayToSort		array to be divided into sub arrays
	 * @param 	low				lower bound
	 * @param 	high			upper bound
	 */
	private static void mergeSort(String[] arrayToSort, int low, int high) {
		if(low < high) {
			int mid = (low+high)/2;
			mergeSort(arrayToSort, low, mid);
			mergeSort(arrayToSort, mid+1, high);
			
			mergeIt(arrayToSort,low,mid,high);
		}
	}

	/**
	 * Purpose: Merges the sub-arrays obtained from mergeSort()
	 * 			 in sorted manner
	 *  
	 * @param 	arrayToSort		sub-array 
	 * @param 	low				lower bound
	 * @param 	mid				middle position
	 * @param 	high			upper bound 
	 */
	private static void mergeIt(String[] arrayToSort, int low, int mid, int high) {
		int sizeOfLeftArr = mid-low+1;
		int sizeOfRightArr = high-mid;
		String[] leftSubArr = new String[sizeOfLeftArr];
		String[] rightSubArr = new String[sizeOfRightArr];
		for(int i=0;i<sizeOfLeftArr;i++) {
			leftSubArr[i]= arrayToSort[low+i];
		}
		for(int i=0;i<sizeOfRightArr;i++) {
			rightSubArr[i]= arrayToSort[mid+1+i];
		}
		int j=0;
		int i=0;
		int k=low;
		while(i<sizeOfLeftArr && j<sizeOfRightArr) {
			if(leftSubArr[i].compareTo(rightSubArr[j])<=0)
				arrayToSort[k++] = leftSubArr[i++];
			else
				arrayToSort[k++] = rightSubArr[j++];
		}
		while(i<sizeOfLeftArr)
			arrayToSort[k++] = leftSubArr[i++];
		while(j<sizeOfRightArr)
			arrayToSort[k++] = rightSubArr[j++];
	}
	
	 /**
	  * Purpose: Start the gambling game. Take inital inputs from the player
	  * 
	  * @return: stake and goal 
	  */ 
	public static int[] startGambling() {
		int initialValues[] = new int [2];
		System.out.println("Enter you initial amount/stake: ");
		initialValues[0] = readInteger();
		System.out.println("Enter you goal: ");
		initialValues[1] = readInteger();
		System.out.println("Lets begin game simulation: ");
		return initialValues;
	}
	
	/**
	 * Purpose: Start the betting simulation 
	 * 
	 * @param 	stake	the initial amount (stake) read from the user
	 * @param 	goal	the goal set by the user, which if achieved, 
	 * 					ends the game;
	 */
	public static void bet(int stake, int goal) {
		int chances =0;
		double loss=0,win=0;
		int results[][] = new int[20][2];
		while(stake>0 && stake!=goal && chances<20) {
			double num = Math.random();
			if(num<0.5) {
				loss++;
				results[chances][0]=0;
				results[chances++][1]=chances;
				stake--;
			}
			else {
				win++;
				results[chances][0]=0;
				results[chances++][1]=chances;
				stake++;
			}
		}
		
		double winPerc = (win/(double)chances)*100;
		double lossPerc = (loss/(double)chances)*100;
		System.out.println("Win percentage: "+winPerc);
		System.out.println("Loss percentage: "+lossPerc);
		result(stake,goal,chances);
	}

	/**
	 * Purpose: After all simulations are completed, results are displayed
	 * 
	 * @param 	stake		Final amount remaining with user after the game 
	 * @param 	goal		the target set by user
	 * @param 	chances		the number of simulations performed
	 */
	private static void result(int stake,int goal, int chances) {
		if(stake==goal) {
			System.out.println("Congratulations!! .... your goal has been accomplished in "+ chances+" simulations");
		}
		else if(stake==0) {
			System.out.println("Sorry!! .... Better luck next time..you lost all your money in "+ chances+" simulations");
		}
		else {
			System.out.println("You've played enough chances... your final amount is "+stake+" rupees");
		}
	}

	/**
	 * Purpose: Find the number within n guesses
	 * 
	 * @param 	numberChoice	the number chosen by user
	 * @param 	range			max range to select from
	 */
	public static void findNumber(double numberChoice, double range) {
		double low = 0;
		int count = 0;
		double high = range;
		while(low<high) {
			count++;
			int mid = (int) ((low+high)/2);
			System.out.println("is this you number? :"+mid+
					"\ntrue or false?");
			boolean correctChoice = readBoolean();
			if(!correctChoice) {
				System.out.println("is your number less than this number? :"
						+ "\ntrue or false?");
				boolean lessThan = readBoolean();
				if(lessThan) {
					high = mid-1 ;
					continue;
				} else {
					low = mid+1 ;
					continue;
				}
			} else {
				System.out.println("we found you number in "+ count+ " chances!");
				break;
			}
		}
	}

	/**
	 * Purpose: Gives minimum notes from a vending machine for a given amount
	 * 
	 * @param: 	amount		amount to be withdrawn
	 * @param:	noteType	type of note (refer to {@value notes[]} 
	 */
	public static void getMoney(int amount,int noteType) {
		int count=0;
		int notesToBeDeducted=notes[noteType];
		while(amount/notesToBeDeducted>0) {
			count++;
			amount = amount-notes[noteType];
		}
		System.out.println(notes[noteType]+" rs notes : "+count);
		if(amount!=0) {
			noteType++;
			getMoney(amount, noteType);
		}
	}

	/**
	 * Purpose: Form permutations of a string
	 * 
	 * @param 	differentPermutations	formed permutations
	 * @param 	originalString			reamining elements to be added to permutations
	 */
	public static void formPermutations(String differentPermutations,
			String originalString) {
		int remainingElements = originalString.length();
		if(remainingElements==0) {
			System.out.println(differentPermutations);
		} else {
			for(int i=0;i<remainingElements;i++) {
				String pendingElements = originalString.substring(0,i)+
						originalString.substring(i+1,remainingElements);
				String formedString = differentPermutations+originalString.charAt(i);
				formPermutations(formedString,pendingElements); 		}
		}
	}

}
