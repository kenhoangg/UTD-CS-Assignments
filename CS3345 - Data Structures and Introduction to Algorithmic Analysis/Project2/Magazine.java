/**
 *	@author Kenny Hoang
 *	Class: CS3345 - Data Structures and Introduction to Algorithmic Analysis
 *	Section: 004
 *	Semester: Spring 2017
 *
 *	Assignment: Project 2
 **/

// Magazine.java defines Magazine class which implements IDedObject interface

public class Magazine implements IDedObject{
	private int magazineID;
	private String magazineName;
	private String publisherName;
	
	public Magazine(int id, String magName, String pubName){
		magazineID = id;
		magazineName = magName;
		publisherName = pubName;
	}
	
	public int getID() {
		return magazineID;
	}

	public void printID() {
		System.out.printf("Magazine ID: %d\nMagazine Name: %s\nPublisher Name: %s\n", magazineID, magazineName, publisherName);
	}
	
	public String getMagazineName(){
		return magazineName;
	}

	public String getPublisherName(){
		return publisherName;
	}
}
