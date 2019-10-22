/******************************************************************************
 *  Purpose: Play gambling game (simulation)
 *  
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.Util;

public class Gambler {

	public static void main(String[] args) {
			int inputs[]= Util.startGambling();
			int stake = inputs[0];
			int goal = inputs[1];
			Util.bet(stake, goal);
		}

}
