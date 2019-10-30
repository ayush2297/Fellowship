package com.bridgeit.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class UtilityDataStructures {

	static Scanner sc = new Scanner(System.in);
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
	

	public static Scanner acceptFileUsingScanner() throws IOException {
//		System.out.println("enter your file address: ");
//		String fileAddress = readString();
		Path inputPath = Paths.get("/home/user/file.txt");
		Scanner file = new Scanner(inputPath);
		return file;
	}

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

	public static void showFileContents(Scanner inputFile) {
		inputFile.useDelimiter("\\n");
		while(inputFile.hasNext()) {
			System.out.println(inputFile.next());
		}	
	}

	public static BufferedReader AcceptWithBuffReader() throws FileNotFoundException {
		File fileOL = new File("/home/user/fileForOrderedList.txt");
		FileReader fr = new FileReader(fileOL);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}

	public static String ReadWithBuffReader(BufferedReader br) throws IOException {
		String tempString = "";
		String finalString = "";
		while((tempString = br.readLine()) != null) {
			finalString += tempString+" ";
		}
		return finalString;
	}

}
