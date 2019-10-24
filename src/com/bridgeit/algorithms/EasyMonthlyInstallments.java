/******************************************************************************
 *  Purpose: Find monthly installments for a given principal 
 *  		 amount, years and rate of interest. 
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class EasyMonthlyInstallments {

	public static void main(String[] args) {
		double principal = Double.parseDouble(args[0]);
		double year = Double.parseDouble(args[1]);
		double rateOfInterest = Double.parseDouble(args[2]);
		System.out.println("Principal amount: "+principal);
		System.out.println("\nEMI for "+year+" years, at an "
				+ "interest rate of "+rateOfInterest+" is : "+
				UtilityAlgorithms.monthlyPayment(principal, year, rateOfInterest));
	}

}
