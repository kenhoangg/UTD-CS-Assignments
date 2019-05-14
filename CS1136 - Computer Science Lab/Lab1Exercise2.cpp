//	CS 1136 Lab 1 Exercise 2
//	A program to calculate the user's age
//	in dog years
//
// Program by: Kenny Hoang

#include <iostream>
using namespace std;
int main()
{
	int humanAge, dogAge;

	cout << "How old are you? ";
	cin >> humanAge;

	dogAge = humanAge * 7;
	
	cout << "Wow, in dog years that is " << dogAge << ".\n";

	// UPDAYE THE FOLLOWING CODE TO DISPLAY YOUR NAME

	cout << "Hello. My name is Kenny Hoang\n";

	return 0;
}