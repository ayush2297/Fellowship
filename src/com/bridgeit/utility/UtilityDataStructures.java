package com.bridgeit.utility;

import java.awt.List;
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


public class UtilityDataStructures {

	static Scanner sc = new Scanner(System.in);

	private static double cashBalance = 0;
	File fileOL = new File("/home/user/fileForOrderedList.txt");
	
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
	public static Scanner acceptFileUsingScanner() throws IOException {
//		System.out.println("enter your file address: ");
//		String fileAddress = readString();
		Path inputPath = Paths.get("/home/user/file.txt");
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
	    sc.useDelimiter(" ");
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
	public static BufferedReader AcceptWithBuffReader() throws FileNotFoundException {
		File fileOL = new File("/home/user/fileForOrderedList.txt");
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

	public static void startBankCounter() {
		Queue q = new Queue();
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

}
