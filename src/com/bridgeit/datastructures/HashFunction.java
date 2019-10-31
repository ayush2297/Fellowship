/******************************************************************************
 *  Purpose: Map class use example
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   31-10-2019
 *
 ******************************************************************************/
package com.bridgeit.datastructures;

import java.io.IOException;
import java.util.Scanner;

import com.brdigeit.structures.Map;
import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;

public class HashFunction {

	public static void main(String[] args) throws IOException {
		Map<Integer> map = new Map<Integer>(3);
		Scanner scanner = UtilityDataStructures.acceptFileUsingScanner
				("/home/user/numbersForHasg.txt");
		scanner.useDelimiter("\\Z");
		String fileContents = scanner.next();
		String [] stringArr = fileContents.split(" ");
		map.addAll(stringArr);
		map.totalElements();
		map.showMap();
		System.out.println("element to search: ");
		int searchThisint = UtilityAlgorithms.readInteger();
		if(map.searchMap(searchThisint)) {
			System.out.println("found!");
		}else {
			System.out.println("element wasnt found! updated the list");
		}
		map.showMap();
	}

}
