/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Assignment 5 - Linear Equation
 *	Program Description: This program creates the LinearEquation class
 *	that calculates X and Y, a system of linear equations.
 **/

public class LinearEquation {
	private double a = 0,b = 0,c = 0,d = 0,e = 0,f = 0;
	
	// Construct a LinearEquation object with the input values
	public LinearEquation(double a, double b, double c, double d, double e, double f)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	
	// Get methods
	public double getA()
	{
		return this.a;
	}
	
	public double getB()
	{
		return this.b;
	}
	
	public double getC()
	{
		return this.c;
	}
	public double getD()
	{
		return this.d;
	}
	public double getE()
	{
		return this.e;
	}
	public double getF()
	{
		return this.f;
	}
	
	// Check if equation is solvable (avoids divide by 0 error)
	public boolean isSolvable()
	{
		if(a * d - b * c == 0)
			return false;
		return true;
	}
	
	public double getX()
	{
		return ((this.e * this.d) - (this.b * this.f)) / ((this.a * this.d) - (this.b * this.c));
	}
	
	public double getY()
	{
		return ((this.a * this.f) - (this.e * this.c)) / ((this.a * this.d) - (this.b * this.c));
	}
}
