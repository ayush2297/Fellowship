/******************************************************************************
 *  Purpose: Stack implementation using list
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   30-10-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;

public class Stack<T> {

	int top;
	public int size;
	
	/**
	 * Purpose: Initialize a stack
	 */
	public Stack(){
		this.size = 0;
		this.top = -1;
	}
	LinkedList<T> list =  new LinkedList<T>(); 
	
	/**
	 * Purpose: push a character into the stack
	 * 
	 * @param 	tokenizedExpression	element to be pushed into the stack
	 */
	public <T>void push(T tokenizedExpression) {
		list.addAtHead(tokenizedExpression);
		size++;
	}
	
	/**
	 * Purpose: return and remove the top element from the stack
	 * 
	 * @return	top element from the stack
	 */
	public T pop() {
		if(isEmpty()) {
			System.out.println("stack underflow!!");
			return null;
		}
		Node popElement = list.head;
		list.deleteAtHead();
		size--;
		return (T) popElement.data;
	}
	
	/**
	 * Purpose: return the top element from the stack
	 * 
	 * @return	top element from the stack
	 */
	public T peek() {
		Node popElement = list.head;
		return (T) popElement.data;
	}
	
	/**
	 * Purpose: checks if the stack has atleast one element
	 * 
	 * @return	true - if stack has atleast one element
	 * 			false - if stack has no elements
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Purpose: number of elements in the stack
	 * 
	 * @return size of stack
	 */
	public int size() {
		return size;
	}
}
