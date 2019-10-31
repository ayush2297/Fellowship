/******************************************************************************
 *  Purpose: Ordered list implementation
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   29-10-2019
 *
 ******************************************************************************/
package com.bridgeit.datastructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.brdigeit.structures.LinkedList;
import com.bridgeit.utility.UtilityDataStructures;

public class OrderedList {

	public static void main(String[] args) throws IOException {
		LinkedList<Double> list = new LinkedList<Double>();
		String path = "/home/user/fileForOrderedList.txt";
		BufferedReader br = UtilityDataStructures.AcceptWithBuffReader(path);
		String fileContents = UtilityDataStructures.ReadWithBuffReader(br);
		System.out.println(fileContents);
		list.addAllOrdered(fileContents);
		list.show();
		list.searchNodeOL(12);
	}

}
