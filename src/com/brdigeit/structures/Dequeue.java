package com.brdigeit.structures;

public class Dequeue <T>{
int size;
	
	public Dequeue() {
		this.size = 0;
	}
	
	LinkedList<T> list = new LinkedList<T>();
	
	/**
	 * Purpose: add element to the rear end of the dequeue
	 * 
	 * @param 	<T>		generic definition
	 * @param 	item	element to be added to the queue
	 */
	public <T>void addRear(T item){
		list.addAtEnd(item);
		size++;
	}
	
	/**
	 * Purpose: add element to the front end of the dequeue
	 * 
	 * @param 	<T>		generic definition
	 * @param 	item	element to be added to the dequeue
	 */
	public <T>void addFront(T item){
		list.addAtHead(item);
		size++;
	}
	
	
	/**
	 * Purpose: return and remove the element from the rear end of the dequeue
	 * 
	 * @param 	<T>		generic definition
	 * @return			element at the front of the dequeue
	 */
	public <T>T deleteFront(){
		if(isEmpty())
			return null;
		Node temp = list.deleteNreturnHead();
		size--;
		return (T) temp.data;
	}
	
	/**
	 * Purpose: return and remove the element from the front end of the dequeue
	 * 
	 * @param 	<T>		generic definition
	 * @return			element at the front of the dequeue
	 */
	public <T>T deleteRear(){
		if(isEmpty())
			return null;
		Node temp = list.deleteNreturnEnd();
		size--;
		return (T)temp.data;
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
