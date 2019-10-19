/******************************************************************************
 *  Purpose: To calculate wind chill (effective temperature
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   19-10-2019
 *
 ******************************************************************************/
package com.bridgeit.functional;

import com.bridgeit.utility.Utility;

public class WindChill {

	public static void main(String[] args) {
		Utility utility =  new Utility();
		Double temperature = Double.parseDouble(args[0]);
		Double speed = Double.parseDouble(args[1]);
		
		if(temperature>50 || speed>120 || speed<3) {
			System.out.println("calculation of wind chill not possible!!");
		} else {
			System.out.println(utility.calculateWindChill(temperature, speed));
		}
	}

}
