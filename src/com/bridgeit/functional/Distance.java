/******************************************************************************
 *  Purpose: Find the a euclidean distance of a coordinate (x,y) from (0,0)
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   18-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class Distance {

	public static void main(String[] args) {
		Utility utility = new Utility();
		int [] coordinates = new int[2];
		coordinates[0] =  Integer.parseInt(args[0]);
		coordinates[1] =  Integer.parseInt(args[1]);
		System.out.println(utility.euclideanDistance(coordinates));
	}
}
