package com.bridgeit.datastructures;

import com.bridgeit.utility.UtilityAlgorithms;
import com.bridgeit.utility.UtilityDataStructures;

public class BstPossibilities {

	public static void main(String[] args) {
		for(int i = 0; i < 6 ; i++) {
			int possibilities = 
					UtilityDataStructures.findBstPossibilities(i);
			System.out.println((i+1)+ " : "+possibilities);
		}
	}

}
