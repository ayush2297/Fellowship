package com.bridgeit.utility;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.Clock;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Utility {
	
	static Random random = new Random();
	static String[][] ticTacToeBoard = new String [3][3];
	
	static Clock clock = Clock.systemDefaultZone();
	HashSet<String> HsForCoupons = new HashSet<String>();
	PrintWriter printObj = new PrintWriter(System.out,true);
	Scanner sc = new Scanner(System.in);
	
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

	/**
	 * Purpose: get the current time in milliseconds
	 * 
	 * @return	time in milliseconds
	 */
	public static double timeInMillis() {
		return clock.millis();
	}

	/**
	 * Purpose: Calculates elapsed time(in milliseconds)
	 * 
	 * @param 		startTime		stopwatch start time			
	 * @param 		endTime			stopwatch end time
	 * @return						time elapsed 
	 */
	public double elapsedTime(double startTime, double endTime) {
		return endTime-startTime;
	}

	/**
	 * Purpose: Start the game of Tic-Tac-Toe
	 */
	public void playTicTacToe() {
		reset();
		for(int i=0;i<9;i++) {
			if(i%2==0) {
				computerChance();
				showTicTacToeBoard();
				if(i>3) {
					checkWinCondition();
				}
			} else {
				userChance();
				showTicTacToeBoard();
				if(i>3) {
					checkWinCondition();
				}
			}
		}
		System.out.println("It's a draw!!!!");
		gameOver();
	}


	/**
	 * Purpose: Initialize the Tic-Tac-Toe board
	 */
	private void reset() {
		for(int i=0;i<3;i++) {
			for(int j=0; j<3; j++) {
				ticTacToeBoard[i][j]=null;
			}
		}
		System.out.println("board resetted!\n");
	}

	/**
	 * Purpose: computer plays it's chance by selecting random 
	 * 			place to play on the board
	 */
	private void computerChance() {
		System.out.println("Computers chance: ");
		while(true) {
			int compI = random.nextInt(3);
			int compJ = random.nextInt(3);
			if(ticTacToeBoard[compI][compJ]!=null) {
				continue;
			} else {
				ticTacToeBoard[compI][compJ] = "X";
			}
		}
	}
	
	/**
	 * Purpose: Displays the current state of the Tic-Tac-Toe board
	 */
	private void showTicTacToeBoard() {
		for(int i=0; i<3;i++) {
			for(int j=0; i<3; j++) {
				System.out.print(ticTacToeBoard[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Purpose: User's chance 
	 */
	private void userChance() {
		int userI;
		int userJ;
		while(true) {
			System.out.println("enter your row between 0 to 2: ");
			userI = readInteger();
			if(userI>2){
				System.out.println("wrong input!! enter row in the range or 0 to 2");
				continue;
			}
			System.out.println("enter your column between 0 to 2: ");
			userJ = readInteger();
			if(userJ>2){
				System.out.println("wrong input!! enter column in the range or 0 to 2");
				continue;
			}
			if(ticTacToeBoard[userI][userJ]!=null) {
				System.out.println("place already occupied!! try other coordinates!");
				continue;
			} else {
				ticTacToeBoard[userI][userJ] = "O";
			}
		}
	}

	/**
	 * Purpose: To check if the user or computer have won the game
	 */
	private void checkWinCondition() {
		checkTttDiagonals();
		checkTttRows();
		checkTttColumns();
	}

	/**
	 * Purpose: Checks both the diagonals for winning conditions
	 */
	private void checkTttColumns() {
		for(int col=0; col<3; col++) {
			if(ticTacToeBoard[0][col] == ticTacToeBoard[1][col]) {
				if(ticTacToeBoard[0][col] == ticTacToeBoard[2][col]) {
					if(ticTacToeBoard[0][col]=="X") {
						System.out.println("Computer won!!!!!!");
						gameOver();
					} else if(ticTacToeBoard[0][col]=="O"){
						System.out.println("User won!!!!!!");
						gameOver();
					}
				}
			}
		}
	}

	/**
	 * Purpose: Checks all the rows for winning conditions
	 */
	private void checkTttRows() {
		for(int row =0; row<3; row++) {
			if(ticTacToeBoard[row][0] == ticTacToeBoard[row][1]) {
				if(ticTacToeBoard[row][0] == ticTacToeBoard[row][2]) {
					if(ticTacToeBoard[row][0]=="X") {
						System.out.println("Computer won!!!!!!");
						gameOver();
					} else if(ticTacToeBoard[row][0]=="O"){
						System.out.println("User won!!!!!!");
						gameOver();
					}
				}
			}
		}
	}

	/**
	 * Purpose: Checks all the columns for winning conditions
	 */
	private void checkTttDiagonals() {
		if(ticTacToeBoard[0][0] == ticTacToeBoard[1][1]) {
			if(ticTacToeBoard[0][0] == ticTacToeBoard[2][2]) {
				if(ticTacToeBoard[0][0]=="X") {
					System.out.println("Computer won!!!!!!");
					gameOver();
				} else if(ticTacToeBoard[0][0]=="O"){
					System.out.println("User won!!!!!!");
					gameOver();
				}
			}
		} else if(ticTacToeBoard[0][0] == ticTacToeBoard[1][1]) {
			if(ticTacToeBoard[0][0] == ticTacToeBoard[2][2]) {
				if(ticTacToeBoard[0][0]=="X") {
					System.out.println("Computer win!!!!!!");
					gameOver();
				} else if(ticTacToeBoard[0][0]=="O"){
					System.out.println("User won!!!!!!");
					gameOver();
				}
			}
		}
	}
	
	/**
	 * Purpose: Game menu after the game is won by someone
	 */
	private void gameOver() {
		System.out.println("1. Play again\n2. Exit");
		int choice = readInteger();
		switch (choice) {
		case 1:
			playTicTacToe();
			break;
		case 2:
			endGame();
			break;
		default:
			System.out.println("wrong choice! try again!");
			gameOver();
			break;
		}
	}

	/**
	 * Purpose: To quit the game
	 */
	private void endGame() {
		System.out.println("\n\nThank you for playing my game!!");
		return;
	}

	/**
	 * Purpose: calculate the discriminant of ax^2+bx+c
	 * 
	 * @param 	a	a from ax^2+bx+c
	 * @param 	b	b from ax^2+bx+c
	 * @param 	c	c from ax^2+bx+c
	 * @return		discriminant
	 */
	public double calculateDelta(double a, double b, double c) {
		return ((b*b)-(4*a*c));
	}

	/**
	 * Purpose: Find the roots of ax^2+bx+c
	 * 
	 * @param 	delta	discriminant of ax^2+bx+c
	 * @param 	a		a from ax^2+bx+c
	 * @param 	b		b from ax^2+bx+c
	 * @return			Root(s) of ax^2+bx+c
	 */
	public double[] findRoots(double delta, double a, double b) {
		double [] tempRoots = new double [2];
		tempRoots[0] = (-b+Math.sqrt(delta))/(2*a);
		tempRoots[1] = (-b-Math.sqrt(delta))/(2*a);
		return tempRoots;
	}

	/**
	 * Purpose: Calculate the wind chill (effective temperature
	 * 
	 * @param 	temperature		temperature in fahrenheit
	 * @param 	speed			velocity in miles per hour
	 * @return
	 */
	public double calculateWindChill(Double temperature, Double speed) {
		return ( 35.4 +(0.6215*temperature - 35.75) * Math.pow(speed, 0.16));
	}

}
