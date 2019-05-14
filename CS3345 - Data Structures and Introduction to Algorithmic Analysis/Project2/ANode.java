/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 2
 **/

// ANode.java defines the ANode class

public class ANode<AnyType>{
	AnyType data;
	ANode<AnyType> next;
	
	public ANode(AnyType data){
		this.data = data;
	}
}
