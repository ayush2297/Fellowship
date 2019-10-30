package com.bridgeit.datastructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.brdigeit.structures.LinkedList;
import com.bridgeit.utility.UtilityDataStructures;

public class OrderedList {

	public static void main(String[] args) throws IOException {
		LinkedList<Double> list = new LinkedList<Double>();
		BufferedReader br = UtilityDataStructures.AcceptWithBuffReader();
		String fileContents = UtilityDataStructures.ReadWithBuffReader(br);
		System.out.println(fileContents);
		list.addAllOrdered(fileContents);
		list.show();
		list.searchNode(12.0);
	}

}
