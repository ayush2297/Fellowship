/******************************************************************************
 *  Purpose: Play gambling game (simulation)
 *  
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   22-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;

public class Gambler {

	public static void main(String[] args) {
			int inputs[]= UtilityAlgorithms.startGambling();
			int stake = inputs[0];
			int goal = inputs[1];
			UtilityAlgorithms.bet(stake, goal);
		}

}
