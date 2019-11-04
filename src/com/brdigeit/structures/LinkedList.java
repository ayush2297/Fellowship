/******************************************************************************
 *  Purpose: List implementation using Node
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   29-10-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.ls.LSInput;

public class LinkedList<T>{
	
	static int outer = 1;
	static int inner = 1;
	
	Node<T> head;
	String pathForUnorderedList = "/home/user/file.txt";
	String pathForOrderedList = "/home/user/fileForOrderedList.txt";
	
	public <T> LinkedList() {
//		System.out.println("creating inner list :"+(outer++));
	}
	public <T> LinkedList(boolean b) {
//		System.out.println("creating Outer list :"+(inner++));
	}

	/**
	 * Purpose: to check if given list has any elements in it
	 * 
	 * @param 	<T>		generic definition
	 * @return			true - if list has atleast one element
	 * 					false - if list has no elements
	 */
	public <T>boolean listIsEmpty() {
		if( head == null ) {
			//System.out.println("Empty list!\n");
			return true;
		}
		return false;
	}
	
	/**
	 * Purpose: checks if a element points to another element
	 * 
	 * @param 	<T>		generic definition
	 * @param 	node	to check if this element points to another element
	 * @return			true - if element points to another element
	 * 					false - if element does not point to another element
	 */
	public <T>boolean hasNext(Node<T> node){
		if( node.nextNode != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Purpose: get next element from the list
	 * 
	 * @param 	<T>		generic definition
	 * @param 	node	to return the element after this element
	 * @return			next element
	 */
	public <T>Node getNext(Node<T> node){
		if( hasNext(node) )
			return node.nextNode;
		return null;
	}
	
	/**
	 * Purpose: returns the size of the list
	 * 
	 * @param 	<T>		generic definition
	 * @return			number of elements in the list
	 */
	public <T>int size(){
		if( listIsEmpty() )
			return 0;
		int size = 1;
		Node sizeCountingNode = head;
		while( hasNext(sizeCountingNode) ) {
			sizeCountingNode = sizeCountingNode.nextNode;
			size++;
		}
		return size;
	}
	
	/**
	 * Purpose: get the element from the specified position in the list
	 * 
	 * @param 	<T>				generic definition
	 * @param 	position		element position given by user
	 * @return					element at the position
	 */
	public <T> Node returnNode(int position) {
		if( listIsEmpty() ) {
			return null;
		}
		int currPos = 0;
		Node traverse = head;
		while( currPos < position) {
			traverse = traverse.nextNode;
			currPos++;
		}
		return traverse;
	}
	/**
	 * Purpose: displaying all elements of the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>void show(){
		if( listIsEmpty() ) {
			System.out.println("Nothing to display\n");
			return;
		}
		Node traversingNode = head;
		while( hasNext(traversingNode) ) {
			System.out.println( traversingNode.data );
			traversingNode = traversingNode.nextNode;
		}
		System.out.println(traversingNode.data);
	}
	
	/**
	 * Purpose: adding an element at the head of the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>void addAtHead(T data) {
		Node newHead = new Node<T>(data);
		if( listIsEmpty() ) {
			head = newHead;
//			System.out.println("added at head");
			return;
		}
		newHead.nextNode = head;
		head = newHead;
//		System.out.println("added at head");
	}
	
	/**
	 * Purpose: adding an element at the specified postion in the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>void addAtPos(T data , int insertPosition) {
		if( listIsEmpty() ) {
			return;
		}
		Node<T> insertNode = new Node<T>(data);
		Node tempNode = head;
		int currentPosition = 1;
		while ( hasNext(tempNode) && (currentPosition < insertPosition) ) {
			tempNode = tempNode.nextNode;
			currentPosition++;
		}
		insertNode.nextNode = getNext(tempNode);
		tempNode.nextNode = insertNode;
	}
	
	/**
	 * Purpose: adding an element at the end of the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>void addAtEnd(T data) {
		if ( listIsEmpty() ) {
//			System.out.println("adding at head");
			addAtHead(data);
			return;
		}
		Node<T> insertNode = new Node<T>(data);
		Node traversingNode = head;
		while( hasNext(traversingNode) ) {
			traversingNode = traversingNode.nextNode;
		}
		traversingNode.nextNode = insertNode;
//		System.out.println("added at end");
	}
	
	/**
	 * Purpose: deleting the head element of the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>void deleteAtHead(){
		if ( listIsEmpty() ) {
			return;
		}
		head = head.nextNode;
	}
	
	/**
	 * Purpose: deleting the head element of the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>T deleteNreturnHead(){
		if ( listIsEmpty() ) {
			return null;
		}
		Node tempHead = head;
		head = head.nextNode;
		return (T)tempHead;
	}
	/**
	 * Purpose: deleting the element at a particular position in the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>void deleteAtPos(int deletePosition){
		if( listIsEmpty() ) {
			return;
		}
		Node tempNode = head;
		int currentPosition = 1;
		while ( hasNext(tempNode) && (currentPosition < deletePosition) ) {
			tempNode = tempNode.nextNode;
			currentPosition++;
		}
		tempNode.nextNode = (tempNode.nextNode).nextNode;		
	}

	/**
	 * Purpose: deleting the element at the end of the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>void deleteAtEnd(){
		if( listIsEmpty() ) {
			return;
		}
		Node tempNode = head;
		while ( hasNext(tempNode.nextNode) ) {
			tempNode = tempNode.nextNode;
		}
		tempNode.nextNode = null;
	}
	
	/**
	 * Purpose: deleting the element at the end of the list
	 * 
	 * @param 	<T>		generic definition
	 */
	public <T>T deleteNreturnEnd(){
		if( listIsEmpty() ) {
			return null;
		}
		Node tempNode = head;
		while ( hasNext(tempNode.nextNode) ) {
			tempNode = tempNode.nextNode;
		}
		Node temp = tempNode.nextNode;
		tempNode.nextNode = null;
		return (T)temp;
	}
	
	/**
	 * Purpose: find and delete the element from the list
	 * 
	 * @param 	<T>					generic definition
	 * @param 	valueToDelete		delete this element fromthe list	
	 */
	public <T> void deleteElement(T valueToDelete) {
		if(head.data == valueToDelete) {
			head = head.nextNode;
			return;
		}
		Node tempNode = head;
		while((tempNode.nextNode).data != valueToDelete 
				&& tempNode.nextNode != null) {
			tempNode = tempNode.nextNode;
		}
		tempNode.nextNode = (tempNode.nextNode).nextNode;
	}
	
	/**
	 * Purpose: deletes the element if found in the map, else adds it to the map
	 * 
	 * @param 	<T>					generic definition
	 * @param 	valueToSearch		search for this element
	 * @return						true - if element is found 
	 * 								false - if element not found			
	 */
	public <T> boolean popIfFound(T valueToSearch) {
		if(searchElement(valueToSearch)) {
			deleteElement(valueToSearch);
			return true;
		} else {
			System.out.println("no such element present.. "
					+ "added the element to the list");
			return false;
		}
	}
	
	/**
	 * Purpose: check whether element is present in the map 
	 *  
	 * @param 	<T>					generic definition
	 * @param 	valueToSearch		search for this element
	 * @return						true - if element is found
	 * 								false - if element not found
	 */
	public <T> boolean searchElement(T valueToSearch) {
		if ( listIsEmpty() ) {
			addAtEnd(valueToSearch);
			return false;
		}
		Node traversalNode = head;
		int position = 1;
		while( traversalNode != null ) {
			if( (traversalNode.data).equals(valueToSearch) ) {
				System.out.println("found at " + position+ " and popped out!" );
				return true;
			}
			traversalNode = traversalNode.nextNode;
			position++;
//			System.out.println("not present at " + position );
		}
		addOrdered((Comparable)valueToSearch);
		return false;
	}
	
	/**
	 * Purpose: add all elements from a file
	 * 
	 * @param 	<T>				generic definition
	 * @param 	inputArray		file elements stored in an array
	 */
	public <T>void addAll(T[] inputArray){
		for(int i = 0 ; i < inputArray.length ; i++) {
			System.out.println((i+1)+". adding all");
			addAtEnd(inputArray[i]);
		}
	}
	
	/**
	 * Purpose: add an element in the list
	 * 
	 * @param 	<T>			generic definition
	 * @param 	data		value to be added
	 */
	public <T>void add(T data){
		addAtEnd(data);
	}
	
	/**
	 * Purpose: search the list for a specific element
	 * 
	 * @param 	<T>				generic definition
	 * @param 	dataToSearch	element to be searched
	 * @throws	IOException		if file handling fails
	 */
	public <T>void searchNodeOL(T dataToSearch) throws IOException {
		if ( listIsEmpty() ) {
			return;
		}
		Node traversalNode = head;
		int position = 1;
		while( traversalNode != null ) {
			if( (traversalNode.data).equals(dataToSearch) ) {
				System.out.println("found at " + position );
				return;
			}
			traversalNode = traversalNode.nextNode;
			position++;
			System.out.println("not present at " + position );
		}
		addAtEnd(dataToSearch);
		File file = new File(pathForOrderedList);
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		String writeToFile = dataToSearch.toString()+ " ";
		br.write(writeToFile);

		br.close();
		fr.close();
	}
	
	/**
	 * Purpose: search the list for a specific element
	 * 
	 * @param 	<T>				generic definition
	 * @param 	dataToSearch	element to be searched
	 * @throws	IOException		if file handling fails
	 */
	public <T>void searchNodeUL(T dataToSearch) throws IOException {
		if ( listIsEmpty() ) {
			return;
		}
		Node traversalNode = head;
		int position = 1;
		while( traversalNode != null ) {
			if( (traversalNode.data).equals(dataToSearch) ) {
				System.out.println("found at " + position );
				return;
			}
			traversalNode = traversalNode.nextNode;
			position++;
			System.out.println("not present at " + position );
		}
		addAtEnd(dataToSearch);
		File file = new File(pathForUnorderedList);
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		String writeToFile = dataToSearch.toString()+ " ";
		br.write(writeToFile);

		br.close();
		fr.close();
	}
	
	/**
	 * Purpose: search the list for a specific element
	 * 
	 * @param 	<T>				generic definition
	 * @param 	dataToSearch	element to be searched
	 * @throws	IOException		if file handling fails
	 */
	public <T>void searchNodeMap(T dataToSearch) throws IOException {
		if ( listIsEmpty() ) {
			return;
		}
		Node traversalNode = head;
		int position = 1;
		while( traversalNode != null ) {
			if( (traversalNode.data).equals(dataToSearch) ) {
				System.out.println("found at " + position );
				return;
			}
			traversalNode = traversalNode.nextNode;
			position++;
			System.out.println("not present at " + position );
		}
		addAtEnd(dataToSearch);
//		File file = new File(pathForUnorderedList);
//		FileWriter fr = new FileWriter(file, true);
//		BufferedWriter br = new BufferedWriter(fr);
//		String writeToFile = dataToSearch.toString()+ " ";
//		br.write(writeToFile);
//
//		br.close();
//		fr.close();
	}
	
	/**
	 * Purpose: return the index of the specified element
	 * 
	 * @param 	<T>		generic definition
	 * @param 	data	element to be found
	 * @return			index of the element
	 */
	public <T>int indexOf(T data){
		if ( listIsEmpty() ) {
			System.out.println("no such list");
			return -1;
		}
		Node traversalNode = head;
		int position = 1;
		while( traversalNode != null ) {
			if( (traversalNode.data).equals(data) ) {
				System.out.println("found at " + position );
				return position;
			}
			traversalNode = traversalNode.nextNode;
			position++;
		}
		System.out.println("not found in the list");
		return -1;
	}
	
	/**
	 * Purpose: remove and return the last element of the list
	 * 
	 * @param 	<T>	generic definition
	 */
	public <T>T pop(){
		if( listIsEmpty() ) {
			System.out.println("nothing to pop!!");
			return null;
		}
		Node traversingNode = head;
		while((traversingNode.nextNode).nextNode != null){
			traversingNode = traversingNode.nextNode;
		}
		Node found = traversingNode.nextNode;
		traversingNode.nextNode = null;
		return (T) found.data;
	}
	
	/**
	 * Purpose: remove and return the element at specified position
	 *  
	 * @param 	<T>			generic definition
	 * @param 	position	position of the element that we want to pop
	 * @return				element at the specified postion
	 */
	public <T>T pop(int position){
		if( listIsEmpty() ) {
			System.out.println("nothing to pop!!");
			return null;
		}
		Node traversingNode = head;
		int tempPos = 1;
		while((tempPos+1) != position){
			traversingNode = traversingNode.nextNode;
		}
		Node found = traversingNode.nextNode;
		T dataToReturn = (T) found.data;
		traversingNode.nextNode = found.nextNode;
		return dataToReturn;
	}
	
	/**
	 * Purpose: add an element in the list after the specified element
	 * 
	 * @param 	<T>			generic definition
	 * @param 	thisNode	the element after which we want to add the new element
	 * @param 	data		the new element to be added
	 */
	public <T>void addAfter(Node thisNode, T data){
		if (listIsEmpty()) {
			return;
		}
		Node tempNode = head;
		Node addNode = new Node<T>(data);
		while(tempNode != thisNode ) {
			tempNode = tempNode.nextNode;
		}
		addNode.nextNode = tempNode.nextNode;
		tempNode.nextNode = addNode;
	}
	/**
	 * Purpose: add an element to the list in sorted manner
	 * 
	 * @param 	<T>		generic definition
	 * @param 	data	element to be added	
	 */
	public <T extends Comparable<T>>void addOrdered(T data){
		if(listIsEmpty()) {
			addAtHead(data);
			return;
		}
		Node tempNode = head;
		if(((Comparable<T>) head.data).compareTo(data) > 0) {
			addAtHead(data);
			return;
		} 
		while(tempNode != null && tempNode.nextNode != null) {
			if(((Comparable<T>) tempNode.data).compareTo(data) == 0) { 
				addAfter(tempNode,data);
				return;
			}
			if(((Comparable<T>) tempNode.data).compareTo(data) < 0 
					&& ((Comparable<T>) (tempNode.nextNode).data).compareTo(data) > 0) {
				addAfter(tempNode,data);
				return;
			}
			tempNode = tempNode.nextNode;
		}
		addAtEnd(data);
	}

	/**
	 * Purpose: add all elements of a file to a list in sorted manner
	 * 
	 * @param: 	fileContents	data from file
	 */
	public void addAllOrdered(String fileContents) {
		String[] tempArray = fileContents.split(" ");
		int[] inputArray = new int[tempArray.length]; 
		for(int i=0; i<inputArray.length; i++) {
			addOrdered(Integer.parseInt(tempArray[i]));
		}
	}
}
