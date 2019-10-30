/******************************************************************************
 *  Purpose: Node implementation
 *
 *  @author  Ayush Saraf
 *  @version 1.0
 *  @since   25-10-2019
 *
 ******************************************************************************/
package com.brdigeit.structures;



public class Node<T>{
	T data;
	Node nextNode;
	
	Node(){
		this.data = null;
		this.nextNode = null;
	}
	
	Node(T data){
		this.data = data;
		this.nextNode = null;
	}

};
