/******************************************************************************
 *  Purpose: To calculate roots of quadratic functions ax^2+bx+c
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   19-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityFunctional;

public class Quadratic {

	public static void main(String[] args) {
		UtilityFunctional utility = new UtilityFunctional();
		System.out.println("Enter a, b and c: ");
		double a = utility.readDouble();
		double b = utility.readDouble();
		double c = utility.readDouble();
		
		double delta = utility.calculateDelta(a,b,c);		
		double [] roots = utility.findRoots(delta, a, b);
		System.out.println("\nRoots of "+a+"x^2+"+b+"x+"+c+" are: \n"
				+ "root 1 : "+roots[0]+"  and  "+roots[1]);	
	}

}
