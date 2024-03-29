/******************************************************************************
 *  Purpose: To generate unique coupon codes
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   18-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.UtilityFunctional;

public class CouponGenerator {

	public static void main(String[] args) {
		UtilityFunctional utility = new UtilityFunctional();
		System.out.println("enter the number of coupouns you want to generate: ");
		int numberOfCoupons=utility.readInteger();
		int totalCouponsgenerated = 0;
		int couponNumber = 0;
		while(couponNumber<numberOfCoupons) {
			String newCoupon = utility.generateCouponCode();
			if(utility.checkCouponForDuplicates(newCoupon)) {
				couponNumber++;
				System.out.print("\tsuccessfully added!");
			}else {
				System.out.print("\tnot added!");
			}			
			totalCouponsgenerated++;			
		}
		System.out.println("\n"+couponNumber+" generated in "+totalCouponsgenerated+" attempts!");
	}

}
