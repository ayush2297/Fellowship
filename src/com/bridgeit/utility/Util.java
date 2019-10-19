package com.bridgeit.utility;

import java.util.Arrays;
import java.util.Scanner;

public class Util {
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
	 * 
	 * @param 	firstString		first string entered by user
	 * @param 	secondString	second string entered by user
	 * @return					true if strings are anagrams
	 * 							false if strings are not anagrams
	 */
	public static boolean checkAnagram(String firstString, String secondString) {
		char [] charArrForFirstString = firstString.toCharArray();
		char [] charArrForSecondString = secondString.toCharArray();
		int firstArrLen = charArrForFirstString.length;
		int secondArrLen = charArrForSecondString.length;
		if(firstArrLen!=secondArrLen)
			return false;
		Arrays.sort(charArrForFirstString);
		Arrays.sort(charArrForSecondString);
		for(int i=0; i<firstArrLen; i++) {
			if(charArrForFirstString[i]!=charArrForSecondString[i])
				return false;
		}
		return true;
	}

	/**
	 * Purpose: To provide prime numbers between range low to high
	 * @param 	low		lower range
	 * @param 	high	upper range
	 */
	public void primeBetweenRange(int low, int high) {
		int storePrimes[] = new int [(high - low)/2];
		int count=0;
		for(int i=low;i<high;i++) {
			if(isPrime(i)) {
				storePrimes[count++]=i;
			}
		}
	}

	/** 
	 * Purpose: Determine whether the given number is prime or not 
	 * @param 	i		number to be checked for prime number condition
	 * @return			true if i is a prime number
	 * 					false if i is not a prime number
	 */
	public static boolean isPrime(int i) {
		for(int j=2; j<i/2; j++) {
			if(i%j==0)
				return false;
		}
		return true;
	}
	
	 
}
