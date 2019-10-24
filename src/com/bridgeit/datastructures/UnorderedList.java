package com.bridgeit.datastructures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import com.bridgeit.utility.UtilityDataStructures;

public class UnorderedList {

	public static void main(String[] args) throws IOException {
		Scanner inputFile = UtilityDataStructures.acceptFileUsingScanner();
		UtilityDataStructures.showFileContents(inputFile);
		String contentsOfFile = UtilityDataStructures.readFileContents(inputFile);
		
	}

}
