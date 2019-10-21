/******************************************************************************
 *  Purpose: Search and sort the elements in file using binary search
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   20-10-2019
 ******************************************************************************/
package com.bridgeit.algorithms;

import com.bridgeit.utility.Util;
import java.io.File;
import java.io.FileNotFoundException;


public class SearchInFile {

	public static void main(String[] args) throws FileNotFoundException {
		Util utility = new Util();
		File fileToSearch = utility.readFile();
		utility.findInFile(fileToSearch);
	}

}
