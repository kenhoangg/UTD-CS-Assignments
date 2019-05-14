/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Term Project
 **/

// Person.java implements the Person class

public abstract class Person {
	private String name;
	private double height = 180;
	private double weight = 160;
	private char gender;
	
	// Does not have a no-arg constructor, as a person has to have a name
	public Person(String name){
		this.name = name;
		this.gender = 'M';
	}
	
	public Person(String name, double height, double weight, char gender)
	{
		this.name = name;
		this.setHeight(height);
		this.setWeight(weight);
		this.setGender(gender);
	}
	
	// Get Methods
	public String getName(){
		return name;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public char getGender(){
		return gender;
	}
	
	// Set Methods
	public void setHeight(double height){
		this.height = height;
	}
	
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	public void setGender(char gender){
		this.gender = gender;
	}
}
