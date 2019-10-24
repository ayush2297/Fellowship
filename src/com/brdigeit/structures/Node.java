package com.brdigeit.structures;

public class Node<T> {
//	implements Comparable <T>
	int data;
	Node nextNode;
	
	Node(){
		this.data = (Integer) null;
		this.nextNode = null;
	}
	
	Node(int data){
		this.data = data;
		this.nextNode = null;
	}

//	@Override
//	public <T>int compareTo(int data) {
//		if()
//	}
};
