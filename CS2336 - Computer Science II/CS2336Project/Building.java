/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Term Project
 **/

// Building.java implements the Building class

import java.util.*;

public abstract class Building {
	private String name;
	private Date dateCreated;
	private static int numBuilding = 1;
	
	public Building(){
		numBuilding++;
		this.name = "Building #" + numBuilding;
		dateCreated = new Date();
	}
	
	public Building(String name){
		this.setName(name);
		numBuilding++;
	}
	
	// Get Methods
	public String getName(){
		return name;
	}
	
	public Date getDateCreated(){
		return dateCreated;
	}
	
	public int getNumberBuildings(){
		return numBuilding;
	}
	
	// Set Methods
	public void setName(String name){
		this.name = name;
	}
	
	// Modifier Methods
	public void subNumBuilding(){
		numBuilding--;
	}
}
