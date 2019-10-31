/******************************************************************************
 *  Purpose: Queue implementation using list
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   30-10-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;

public class Queue <T>{
	
	int size;
	
	public Queue() {
		this.size = 0;
	}
	
	LinkedList<T> list = new LinkedList<T>();
	
	/**
	 * Purpose: add element to the end of the queue
	 * 
	 * @param 	<T>		generic definition
	 * @param 	item	element to be added to the queue
	 */
	public <T>void enqueue(T item){
		list.addAtEnd(item);
		size++;
	}
	
	
	/**
	 * Purpose: return and remove the element from the front/head of the queue
	 * 
	 * @param 	<T>		generic definition
	 * @return			element at the front of the queue
	 */
	public <T>T dequeue(){
		if(isEmpty())
			return null;
		Node temp = list.head;
		list.deleteAtHead();
		size--;
		return (T) temp.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if( size == 0 ) {
			return true;
		}
		return false;
	}
	
}
