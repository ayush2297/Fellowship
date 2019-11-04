package com.bridgeit.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.brdigeit.structures.Dequeue;
import com.brdigeit.structures.Queue;
import com.brdigeit.structures.Stack;
import com.brdigeit.structures.Week;
import com.brdigeit.structures.WeekDay;


public class UtilityDataStructures {

	static Scanner sc = new Scanner(System.in);
	static UtilityFunctional utility = new UtilityFunctional();
	
	private static double cashBalance = 0;
	
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
	 * Purpose: accept file using scanner class
	 * 
	 * @return	file 
	 * @throws IOException
	 */
	public static Scanner acceptFileUsingScanner(String address) throws IOException {
//		System.out.println("enter your file address: ");
//		String fileAddress = readString();
		Path inputPath = Paths.get(address);
		Scanner file = new Scanner(inputPath);
		return file;
	}

	/**
	 * Purpose: read file contents
	 * 
	 * @param 	inputFile	file to be read
	 * @return				contents of file
	 */
	public static String readFileContents(Scanner inputFile) {
		String allFileContents = "";
	    inputFile.useDelimiter(" ");
		while(inputFile.hasNext()) {
			allFileContents += inputFile.next() + " " ;
			//System.out.println(allFileContents);
		}
		System.out.println(allFileContents);
		return allFileContents;
	}

	/**
	 * Purpose: display file contents
	 * 
	 * @param 	inputFile	file 	
	 */
	public static void showFileContents(Scanner inputFile) {
		inputFile.useDelimiter("\\n");
		while(inputFile.hasNext()) {
			System.out.println(inputFile.next());
		}	
	}

	/**
	 * Purpose: accept file with buffered reader 
	 * 
	 * @return	buffered reader object for the file
	 * @throws FileNotFoundException
	 */
	public static BufferedReader AcceptWithBuffReader(String path) throws FileNotFoundException {
		File fileOL = new File(path);
		FileReader fr = new FileReader(fileOL);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}

	/**
	 * Purpose: read file contents with help of buffered reader
	 * 
	 * @param 	br				buffered reader object containing file
	 * @return					string having all contents of the file 
	 * @throws IOException		
	 */
	public static String ReadWithBuffReader(BufferedReader br) throws IOException {
		String tempString = "";
		String finalString = "";
		while((tempString = br.readLine()) != null) {
			finalString += tempString+" ";
		}
		return finalString;
	}

	/**
	 * Purpose: check parentheses of an arithmatic expression using stack
	 * 
	 * @param 	arithExpr	arithmatic expression in the form of string
	 * @return				true - if parentheses are correct
	 * 						false - if parentheses are not correct
	 */						
	public static boolean parenthesisCheck(String arithExpr) {
		Stack<String> stack = new Stack<String>();
		char tokenizedExpression[] = arithExpr.toCharArray();
		String openingParentheses = "(";
		String closingParentheses = ")";
		for( int i = 0 ; i < tokenizedExpression.length ; i++) {
			if( openingParentheses.indexOf(tokenizedExpression[i]) >= 0) {
				stack.push(tokenizedExpression[i]);
				stack.size++;
			} else if(closingParentheses.indexOf(tokenizedExpression[i]) >= 0){
				stack.pop();
				stack.size--;
			}
			if(stack.size() == -1) {
				break;
			}
		}
		if(stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Purpose: perform bank counter operations using queue
	 */
	public static void startBankCounter() {
		Queue<Integer> q = new Queue<Integer>();
		int choice ;
		int custNo = 0;
		do {
			System.out.println("1.add customer in queue\n2.process customer request"
					+ "\n3.show queue size\n4.exit");
			choice = UtilityDataStructures.readInteger();
			switch (choice) {
			case 1:
				System.out.println("added to the end of the line!");
				q.enqueue(custNo++);
				break;
			case 2: 
				System.out.println("customer accepted at counter: ");
				int custToProcess = (int) q.dequeue();
				if(custToProcess==-1) {
					System.out.println("no more customers");
					return;
				}
				processCustomer(custToProcess);
				System.out.println("customer request processed successfully..NEXT!");
				break;
			case 3:
				System.out.println("\nnumber of customers reamaining: "+ q.size()+"\n");
				break;
			case 4:
				break;
			default:
				System.out.println("incorrect choice..");
				break;
			}
			System.out.println("cash balance: "+cashBalance);
		}while( choice != 4);
	}

	/**
	 * Purpose: Process the request of the customer on the bank counter
	 *
	 * @param 	custToProcess		customer on the front of the queue
	 */
	private static void processCustomer(int custToProcess) {
		int custChoice;
		do {
			System.out.println("1.Deposit money\n2.withdraw money\n3.done");
			custChoice = UtilityDataStructures.readInteger();
			switch (custChoice) {
			case 1:
				System.out.println("enter the amount to be deposited: ");
				double depositAmount = readDouble();
				cashBalance += depositAmount;
				System.out.println("customer "+(custToProcess+1)+" processed!");
				return;
			case 2: 
				System.out.println("enter the amount to be withdrawn: ");
				double withdrawAmount = readDouble();
				if(withdrawAmount > cashBalance ) {
					System.out.println("please enter amount less than "+cashBalance);
					break;
				}
				cashBalance -= withdrawAmount;
			case 3:
				break;
			default:
				System.out.println("incorrect choice..");
				break;
			}
		}while( custChoice!= 3);
	}

	/**
	 * Purpose: check if the given string is palindrome using dequeue
	 * 
	 * @param 		strToCheck		string to be checked for palindrome properties
	 * @return						true - if string is palindrome
	 *								false - if string is not a palindrome
	 */
	public static boolean isPalindrome(String strToCheck) {
		Dequeue<Character> dq = new Dequeue<Character>();
		for(int i = 0 ; i < strToCheck.length() ; i++) {
			char temp = strToCheck.charAt(i);
			dq.addFront(temp);
		}
		while(dq.size() > 1) {
			char front = dq.deleteFront();
			char end = dq.deleteRear();
			if(front != end) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Purpose: find max ways a BST can be built for given number of nodes
	 *
	 * @param 	numberOfNodes		number of nodes in the BST
	 * @return						max ways to build the BST
	 */
	public static int findBstPossibilities(int numberOfNodes) {
		UtilityAlgorithms util = new UtilityAlgorithms();
		@SuppressWarnings("static-access")
		int possibilities = util.factorial(numberOfNodes*2)/
				(util.factorial(numberOfNodes+1)*util.factorial(numberOfNodes));
		return possibilities;
	}

	/**
	 * @param startOfMonth
	 * @param month
	 * @param year
	 */
	public static void buildCalendar(int startOfMonth, int month, int year) {
		int daysInMonth = findDaysInMonth(month,year);
		int rows;
		if(daysInMonth+startOfMonth <= 35) {
			rows = 5;
		}else {
			rows = 6;
		}
		System.out.println("\t\t"+getMonth(month)+" "+ year);
		formCalendar(rows, startOfMonth, daysInMonth);
	}
	
	
	
	/**
	 * Purpose: Get the month name
	 * 
	 * @param 	month		month in mm
	 * @return				month in string 
	 */
	private static String getMonth(int month) {
		String [] monthNames = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE",
				"JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		return monthNames[month-1];
	}

	/**
	 * Purpose: start calender building 
	 * 	
	 * @param 	rows			number of rows to build calender
	 * @param 	startOfMonth	day on which month starts
	 * @param 	daysInMonth		number of days in the month
	 */
	private static void formCalendar(int rows, int startOfMonth, int daysInMonth) {
		int calendarFormat[][] = new int[rows][7];
		int count = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < 7 && count <= daysInMonth ; j++) {
				if(i ==0) {
					if(j >= startOfMonth) {
						calendarFormat[i][j] = count++;
					}else {
						continue;
					}
				}
				else {
					calendarFormat[i][j] = count++;
				}
			}
		}
		System.out.println("\nSun\tMon\tTue\tWed\tThu\tFri\tSat");
		for(int i =0;i<rows;i++) {
			for(int j=0; j < 7; j++) {
				if(calendarFormat[i][j] == 0) {
					System.out.print("\t");
				}else {
					System.out.print(calendarFormat[i][j]+"\t");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Purpose: To find number of days in the month 
	 * 
	 * @param 	month	month in mm
	 * @param 	year	year in yyyy
	 * @return			number of days in the month
	 */
	private static int findDaysInMonth(int month, int year) {
		int days;
		if(month < 7) {
			if(month == 2) {
				if(UtilityFunctional.isLeap(year)) {
					return days = 29;
				}
				else {
					return days = 28;
				}
			}
			if(month %2 != 0) {
				return days = 31;
			}
			else {
				return days = 30;
			}
		}
		else {
			if(month %2 !=0 ) {
				return days = 30;
			}
			else {
				return days = 31;
			}
		}
	}
	
	/**
	 * Purpose: form calendar using queue
	 * 
	 * @param 	month		month in mm
	 * @param 	year		year in yyyy
	 */
	public static void formMonth(int month, int year) {
		int startDate = UtilityAlgorithms.dayOfWeek(month, 1, year);
		int noOfdaysInMonth = findDaysInMonth(month, year);
		int tempMax = noOfdaysInMonth+7;
		int startCal = 1;
		Queue<Week> singleWeek = new Queue<Week>();
		while(startCal<=tempMax) {
			Week addWeek = new Week(startCal, month, year,noOfdaysInMonth);
			singleWeek.enqueue(addWeek);
			if(startCal == 1) {
				startCal = startCal + (7-startDate);
				continue;
			}
			startCal = startCal+7;
		}
		
		showCalendar(singleWeek);
	}

	/**
	 * Purpose: display calendar
	 * 
	 * @param 	singleWeek		Queue containing all weeks
	 */
	private static void showCalendar(Queue<Week> singleWeek) {
		System.out.println("Sun\tMon\tTues\tWed\tThurs\tFri\tSat");
		while(!singleWeek.isEmpty()) {
			Week week = singleWeek.dequeue();
			Queue<WeekDay> dayQ = week.singleDay;
			while(!dayQ.isEmpty()) {
				WeekDay data = (WeekDay) dayQ.dequeue();
				if(data.date!=0)
					System.out.print(data.date+"\t");
				else
					System.out.print("\t");
			}
			System.out.println();
		}
	}

	/**
	 * Purpose: form a calender using stack
	 * 
	 * @param 	month		month in mm
	 * @param 	year		year in yyyy
	 */
	public static void formCalendarStack(int month, int year) {
		int noOfdaysInMonth = findDaysInMonth(month, year);
		int endDay = UtilityAlgorithms.dayOfWeek(month, noOfdaysInMonth, year);
		int tempMin = -7;
		int currDate = noOfdaysInMonth;
		Stack<Week> singleWeekStack = new Stack<Week>();
		while(currDate>=tempMin) {
			Week addWeek = new Week(currDate, noOfdaysInMonth, month, year,true);
			singleWeekStack.push(addWeek);
			if(currDate == noOfdaysInMonth) {
				currDate = currDate - endDay;
				continue;
			}
			currDate = currDate - 7;
		}
		
		showCalendarStack(singleWeekStack);
		
	}

	/**
	 * Purpose: display calendar built with stack
	 * 
	 * @param 	singleWeekStack		stack containing a particular week
	 */
	private static void showCalendarStack(Stack<Week> singleWeekStack) {
		System.out.println("Sun\tMon\tTues\tWed\tThur\tFri\tSat");
		while(!singleWeekStack.isEmpty()) {
			Week week = singleWeekStack.pop();
			Stack<WeekDay> dayStack = week.singleDayStack;
			while(!dayStack.isEmpty()) {
				
				System.out.print((dayStack.pop()).date+"\t");
			}	
			System.out.println();
		}
	}
}
