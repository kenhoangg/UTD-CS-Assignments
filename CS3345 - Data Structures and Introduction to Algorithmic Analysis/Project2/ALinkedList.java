/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 2
 **/

// ALinkedList.java defines the ALinkedList class

public class ALinkedList<AnyType extends IDedObject>{
	private ANode<AnyType> head;
	private int size;
	
	public ALinkedList(){
		head = null;
		size = 0;
	}
	
	public void makeEmpty(){
		this.head = null;
		this.size = 0;
		System.out.println("List is now empty.");
	}
	
	public AnyType findID(int ID){
		if(size == 0){
			System.out.printf("Could not find Magazine ID#%d in the list.\n", ID);
			return null;
		}
		ANode<AnyType> pointer = head;
		while(pointer != null){
			if(pointer.data.getID() == ID)
				return pointer.data;
			pointer = pointer.next;
		}
		return null;
	}
	
	public boolean insertAtFront(AnyType x){
		ANode<AnyType> pointer = head;
		while(pointer != null){
			if(pointer.data.getID() == x.getID())
				return false;
			pointer = pointer.next;
		}
		ANode<AnyType> temp = new ANode<AnyType>(x);
		temp.next = head;
		head = temp;
		this.size++;
		return true;
	}
	
	public AnyType deleteFromFront(){
		if(head == null){
			System.out.println("The list is empty, cannot delete any records.");
			return null;
		}
		ANode<AnyType> temp = head;
		head = head.next;
		this.size--;
		return temp.data;
	}
	
	public AnyType delete(int ID){
		ANode<AnyType> pointer = head;
		ANode<AnyType> temp = head;
		if(head == null){
			System.out.println("The list is empty, cannot delete any records.");
			return null;
		}
		if(size == 1 && pointer.data.getID() == ID){
			this.head = null;
			this.size--;
			return pointer.data;
		}
		while(pointer != null){
			if(pointer.data.getID() == ID){
				temp.next = pointer.next;
				this.size--;
				return pointer.data;
			}
			temp = pointer;
			pointer = pointer.next;
		}
		System.out.printf("Could not find Magazine ID#%d in the list.\n", ID);
		return null;
	}
	
	public void printAllRecords(){
		if(head == null)
			System.out.println("The list is empty.");
		ANode<AnyType> pointer = head;
		while(pointer != null){
			pointer.data.printID();
			pointer = pointer.next;
		}
	}
}