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
