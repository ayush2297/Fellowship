/******************************************************************************
 *  Purpose: Search and sort the elements in file using binary search
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   21-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.UtilityAlgorithms;
import java.io.File;
import java.io.FileNotFoundException;


public class SearchInFile {

	public static void main(String[] args) throws FileNotFoundException {
		UtilityAlgorithms utility = new UtilityAlgorithms();
		File fileToSearch = utility.readFile();
		utility.findInFile(fileToSearch);
	}

}
