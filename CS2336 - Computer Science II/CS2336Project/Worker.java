/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Term Project
 **/

// Worker.java implements the worker class;

public class Worker extends Person{
	private double wage;
	private double hours;
	
	public Worker(String name, double wage, double hours){
		super(name);
		this.setWage(wage);
		this.setHours(hours);
	}
	
	// Get Methods
	public double getWage(){
		return wage;
	}
	
	public double getHours(){
		return hours;
	}
	
	public double getSalary(){
		return this.wage * this.hours;
	}
	
	// Set Methods
	public void setWage(double wage){
		this.wage = wage;
	}
	
	public void setHours(double hours){
		this.hours = hours;
	}
}
