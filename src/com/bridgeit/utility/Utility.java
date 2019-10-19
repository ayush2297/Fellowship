package com.bridgeit.utility;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Utility {
	
		HashSet<String> HsForCoupons = new HashSet<String>();
		static Random random = new Random();
		Scanner sc = new Scanner(System.in);
		PrintWriter printObj = new PrintWriter(System.out,true);
		
		/**
		 * Purpose: read String from the user using Scanner class
		 * 
		 * @return the String read from the user
		 */
		public String readString() {
			return sc.next();
		}
		
		/**
		 * Purpose: read integer from the user using Scanner class
		 * 
		 * @return the integer read from the user
		 */
		public int readInteger() {
			return sc.nextInt();
		}
		
		/**
		 * Purpose: read float from the user using Scanner class
		 * 
		 * @return the float read from the user
		 */
		public float readFloat() {
			return sc.nextFloat();
		}
		
		/**
		 * Purpose: read double from the user using Scanner class
		 * 
		 * @return the double read from the user
		 */
		public double readDouble() {
			return sc.nextDouble();
		}
		
		/**
		 * Purpose: read boolean from the user using Scanner class
		 * 
		 * @return the boolean read from the user
		 */
		public boolean readBoolean() {
			return sc.nextBoolean();
		}

	
		/**
		 * Purpose: Replaces word/phrase from the original string with specified word
		 * @param 	originalString		the original string
		 * @param 	stringToReplace		what we want to replace from the original string 
		 * @param 	replaceWith			with what we want to replace 
		 * @return						the original string with replaced
		 */
		public String replaceString(String originalString, String stringToReplace,
				String replaceWith) {
			return(originalString.replaceAll(stringToReplace, replaceWith));			
		}

		/**
		 * Purpose: Performs coin flipping simulation
		 * 
		 * @param 	count	the numbers of times you want to flip the coin	
		 */
		public void flipCoin(int count) {
			double toss;
			double heads = 0;
			double tails = 0;
			for(int i = 0; i < count; i++) {
				toss = random.nextDouble();
				if(toss<0.5) {
					System.out.println((i+1)+ " flip result : heads");
					heads++;
				} else {
					System.out.println((i+1)+ " flip result : tails");
					tails++;
				}
			}
			double tailsPercentage = tails/count;
			double headPercentage = heads/count;
			System.out.println("\nheads percentage : "+headPercentage);
			System.out.println("tails percentage : "+tailsPercentage);
		}
		
		/**
		 * Purpose: Get year as the input from the user in YYYY format
		 * 
		 * @return: the year read from the user
		 */
		public int getYear() {
			while(true) {
				int year = readInteger();
				int check = year;
				int count=0;
				for(; check != 0; check/=10, ++count);
				if(count==4) {
					return year;
				} else {
					System.out.println("Wrong input!! Year "
							+ "should be in the format YYYY");
				}
			}
		}
		
		/**
		 * Purpose: tells us whether the given {@value year} is leap year or not
		 * @param 		year	the year read from user as an input
		 * @return				true - if it is leap year 
		 * 						false - if it is not a leap year
		 */
		public boolean isLeap(int year) {
			if(year%4==0 && year%100!=0)
				return true;
			return false;
		}

		/**
		 * Purpose: print all values 2^n ; where n = power 
		 * 
		 * @param 		power	limit of n in 2^n read from the user	
		 */
		public void twoRaisedTo(int power) {
			for(int i = 0; i <= power; i++) {
				System.out.println("2^"+(i)+"\t= "+Math.pow(2, i));
			}
		}

		/**
		 * Purpose: To calculate nth harmonic number
		 * 
		 * @param 		num		harmonic value read from user
		 * @return				returns nth harmonic number
		 */
		public double calculateHarmonicValue(double num) {
			double harmonicValue=0;
			for(int i = 1; i <= num; i++) {
				harmonicValue+=(1/(double)i);
			}
			return harmonicValue;
		}

		/**
		 * Purpose: To determine whether the number is prime or not
		 * 
		 * @param 		number	check if this integer is prime 
		 * @return				true if "number" is prime number
		 * 						false if "number" is not a prime number
		 */
		public boolean isPrime(int number) {
			for(int i = 2; i < number/2; i++) {
				if(number%i==0)
					return false;
			}
			return true;
		}

		/**
		 * Purpose: To find and print prime factors of a number
		 * 
		 * @param 		number	calculate prime factors of this integer
		 */
		public void primeFactors(int number) {
			int tempNumber = number;
			boolean print = false;
			for(int i =2; i*i <= number; i++) {
				int rem = tempNumber%i;
				while(rem==0 && tempNumber!=0) {
					tempNumber/=i;
					rem = tempNumber%i;
					print =true;
				}
				if(print) {
					System.out.println(i);
					print = false;
				}
			}
		}

		/**
		 * Purpose: Generates coupons 
		 * 
		 * @return	coupon
		 */
		public static String generateCouponCode() {
			String generatedCoupon= "";
			String possibleCouponInputs = "123456789";
			int length = possibleCouponInputs.length();
			for(int i = 0 ;i < 3; i++) {
				generatedCoupon+=
						possibleCouponInputs.charAt(random.nextInt(length));
			}
			System.out.print("\n"+ generatedCoupon);
			return generatedCoupon;
		}

		/**
		 * Purpose: Check whether the coupon is unique or not
		 * 
		 * @param 		newCoupon	the coupon to be checked for uniqueness
		 * @return					true if coupon is unique
		 * 							false if coupon is not unique
		 */
		public boolean checkCouponForDuplicates(String newCoupon) {
			if(HsForCoupons.add(newCoupon)) {
				//System.out.println("yay!");
				return true;
			}
			//System.out.println("nay!");
			return false;
		}

		/**
		 * Purpose: Read 2D integer array
		 * @param 		rows	number of rows for 2D array
		 * @param 		cols	number of columns for 2D array
		 * @return				2D integer-array
		 */
		public Integer[][] readTwoDimIntArray(int []  dimensions) {
			int rows = dimensions[0];
			int cols = dimensions[1];
			Integer [][]tempArray = new Integer [rows][cols];
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j <cols; j++) {
					tempArray[i][j] = readInteger();
				}
			}
			return tempArray;
		}
		
		/**
		 * Purpose: Read 2D double array
		 * @param 		rows	number of rows for 2D array
		 * @param 		cols	number of columns for 2D array
		 * @return				2D double-array
		 */
		public Double[][] readTwoDimDoubleArray(int []  dimensions) {
			int rows = dimensions[0];
			int cols = dimensions[1];
			Double [][]tempArray = new Double[rows][cols];
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j <cols; j++) {
					tempArray[i][j] = readDouble();
				}
			}
			return tempArray;
		}
		
		/**
		 * Purpose: Read 2D boolean array
		 * @param 		rows	number of rows for 2D array
		 * @param 		cols	number of columns for 2D array
		 * @return				2D boolean-array
		 */
		public Boolean [][] readTwoDimBooleanArray(int[] dimensions) {
			int rows = dimensions[0];
			int cols = dimensions[1];
			Boolean  [][]tempArray = new Boolean [rows][cols];
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j <cols; j++) {
					tempArray[i][j] = readBoolean();
				}
			}
			return tempArray;
		}

		/**
		 * Purpose: Prints 2D array of any type in matrix format
		 * @param 		<T>			Generic type class T
		 * @param 		intArray	array of type T 
		 */
		public <T>void showTwoDimIntArray(T[][] tempArray) {
			for(int i =0; i<tempArray.length; i++) {
				for(int j=0; j<tempArray[0].length; j++) {
					printObj.print(tempArray+" ");;
				}
				printObj.println();
			}
		}

		/**
		 * Purpose: Get dimensions for a 2D array
		 * @return	an array of dimensions for 2D array
		 */
		public int[] getTwoDimensions() {
			int [] dimensions = new int [2];
			System.out.println("Enter the number of rows and columns: \n");
			dimensions[0] = readInteger();
			dimensions[1] = readInteger();
			return dimensions;
		}

		/**
		 * Purpose: read an array from the user
		 * 
		 * @return:	array read from the user
		 */
		public int[] getArray() {
			System.out.println("enter the number of elements "
					+ "you want to enter in you array: ");
			int elementsCount = readInteger();
			int returnArray[] = new int[elementsCount];
			for(int i=0; i<elementsCount; i++) {
				returnArray[i] =readInteger();
			}
			return returnArray;
		}

		/**
		 * Purpose: find triples in the given array 
		 * 
		 * @param 		numberArray		array containing numbers
		 */
		public void findTriples(int[] numberArray) {
			int count =0;
			for(int i=0 ; i<numberArray.length-2; i++) {
				for(int j=0; j<numberArray.length-1; j++) {
					for(int k=0; k<numberArray.length; k++) {
						if((numberArray[i]+numberArray[j]+numberArray[k])==0) {
							count++;
							System.out.println(numberArray[i]+" + "+numberArray);
						}
					}
				}
			}
			if(count==0)
				System.out.println("No triplets found");
			else
				System.out.println(count+" triplets found!");
		}

		/**
		 * Purpose: Calculate euclidean distance of (x,y) from (0,0)
		 * 
		 * @param 		coordinates		an array consisting of coordinates x and y
		 * @return						euclidean distance
		 */
		public double euclideanDistance(int[] coordinates) {
			int xCoord = coordinates[0];
			int yCoord = coordinates[1];
			double xsq = Math.pow(xCoord, 2);
			double ysq = Math.pow(yCoord, 2);
			double sqrOfxNy = Math.sqrt((xsq+ysq));
			return sqrOfxNy;
		}

}
