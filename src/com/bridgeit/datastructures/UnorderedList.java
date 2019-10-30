package com.bridgeit.datastructures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import com.brdigeit.structures.LinkedList;
import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;
import com.bridgeit.utility.UtilityFunctional;

public class UnorderedList {

	public static void main(String[] args) throws IOException {
		LinkedList<String> list = new LinkedList<String>();
		Scanner inputFile = UtilityDataStructures.acceptFileUsingScanner();
		//UtilityDataStructures.showFileContents(inputFile);
		String contentsOfFile = UtilityDataStructures.readFileContents(inputFile);
		System.out.println(contentsOfFile);
		String[]  inputArray = contentsOfFile.split(" ");
		list.addAll(inputArray);
		list.show();
		System.out.println("enter the string you want to search: ");
		String find = UtilityAlgorithms.readString();
		list.searchNode(find);
	}

}
