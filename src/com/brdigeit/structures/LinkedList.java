package com.brdigeit.structures;

public class LinkedList<T>{
	
	Node<T> head;

	public <T>boolean listIsEmpty() {
		if( head == null ) {
			System.out.println("Empty list!\n");
			return true;
		}
		return false;
	}
	
	public <T>boolean hasNext(Node<T> node){
		if( node.nextNode != null) {
			return true;
		}
		return false;
	}
	
	public <T>Node getNext(Node<T> node){
		if( hasNext(node) )
			return node.nextNode;
		return null;
	}
	
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
	}
	
	public <T>void addAtHead(int data) {
		Node newHead = new Node<T>(data);
		if( listIsEmpty() ) {
			head = newHead;
			return;
		}
		newHead.nextNode = head;
		head = newHead;
	}
	
	public <T>void addAtPos(int data , int insertPosition) {
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
	
	public <T>void addAtEnd(int data) {
		if ( listIsEmpty() ) {
			return;
		}
		Node<T> insertNode = new Node<T>(data);
		Node traversingNode = head;
		while( hasNext(traversingNode) ) {
			traversingNode = traversingNode.nextNode;
		}
		traversingNode.nextNode = insertNode;
	}
	
	public <T>void deleteAtHead(){
		if ( listIsEmpty() ) {
			return;
		}
		head = head.nextNode;
	}
	
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
	
}
