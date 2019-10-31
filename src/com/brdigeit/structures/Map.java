/******************************************************************************
 *  Purpose: Map implementation using Linked list
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   31-10-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;

import com.bridgeit.datastructures.OrderedList;

public class Map<T> {

	LinkedList<T> mapList = new LinkedList<T>(true);
	int keyCount = 0;
	int valCount = 0;
	
	/**
	 * Purpose: create a map of having specific number of keys
	 * 
	 * @param 	<T>				generic definition
	 * @param 	sizeOfMap		number of keys
	 */
	public <T>Map(int sizeOfMap){
		int som = sizeOfMap;
		while(som != 0 ) {
			keyCount++;
			mapList.addAtEnd(null);
			som--;
		}
	}
	
	/**
	 * Purpose: add element to the map
	 * 
	 * @param 	<T>			generic definition
	 * @param 	value		element to be inserted
	 */
	public <T> void add(T value) {
		int key = generateHash(value);
		addElement(key, value);
		valCount++;
	}
	
	/**
	 * Purpose: generate hash/key for the data to be inserted
	 * 
	 * @param 	<T>				generic definition
	 * @param 	inputValue		calculate hash/key of this value
	 * @return					hash/key
	 */
	public <T> int generateHash(T inputValue) {
		int modLocation = (int)inputValue%keyCount;
		return modLocation;
	}
	
	/**
	 * Purpose: add the key- value pair to the map
	 * 
	 * @param 	<T>						generic definition
	 * @param 	modLocationation		key
	 * @param 	inputValue				value
	 */
	public <T>void addElement(int modLocation, T inputValue){
		Node tempNode = mapList.returnNode(modLocation);
		if(tempNode.data == null) {
			LinkedList<T> innerL = new LinkedList<T>();
			innerL.addOrdered((Comparable)inputValue);
			tempNode.data = innerL;
			return;
		}
		LinkedList innerList = (LinkedList) tempNode.data;
		innerList.addOrdered((Comparable<T>)inputValue);
	}
	
	/**
	 * Purpose: show all elements of the map
	 */
	public <T> void showMap() {
		if(mapList.listIsEmpty()) {
			System.out.println("no such map!");
			return;
		}
		int key = 0 ;
		Node tempNodeForKey = mapList.head;
		while(tempNodeForKey != null) {
			System.out.println("\nfor key: "+(key++));
			LinkedList tempListForVal = (LinkedList) tempNodeForKey.data;
			Node tempNodeForVal = tempListForVal.head;
			int c = 0;
			while(tempNodeForVal != null) {
				System.out.println("val"+(++c)+" "+tempNodeForVal.data);
				tempNodeForVal = tempNodeForVal.nextNode;
			}
			tempNodeForKey = tempNodeForKey.nextNode;
		}
	}
	
	/**
	 * Purpose: search an element in the map
	 * 
	 * @param 	elementToBeSearched		search this element in the map
	 * @return							true - if element is found
	 * 									false - if element is not found
	 */
	public <T> boolean searchMap(T elementToBeSearched) {
		int locationToSearch = generateHash(elementToBeSearched);
		Node tempNode = mapList.returnNode(locationToSearch);
		if(tempNode.data == null) {
			System.out.println("does not contain a list");
			add(elementToBeSearched);
			return false;
		}
		LinkedList innerList = (LinkedList) tempNode.data;
		System.out.println("searching at key: " +locationToSearch);
		if(innerList.popIfFound(elementToBeSearched)) {
			valCount--;
			return true;
		}
		return false;
	}
	
	/**
	 * Purpose: print the number of keys and values in the map
	 */
	public <T> void totalElements() {
		System.out.println("keys: "+keyCount);
		System.out.println("values: "+valCount);
	}

	/**
	 * Purpose: add all the elements of the string array to the map
	 * 
	 * @param 	stringArr		array having all the elements to be inserted
	 */
	public void addAll(String[] stringArr) {
		for(int i = 0 ; i < stringArr.length ; i++) {
			add(Integer.parseInt(stringArr[i]));
		}
	}
	
}
