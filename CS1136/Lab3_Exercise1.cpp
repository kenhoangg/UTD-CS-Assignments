// Lab 3 exercise 1
// Input Using cin >>
//
// Program by: Kenny Hoang

#include <iostream>
#include <string>
using namespace std;

int main()
{
   // create the variables to be read in.
   // we are looking at the behavior when reading in the following
   // types
   float floatValue; // floatValue contains a floating point value and is of type float
   int intValue;  // intValue constains a assigned integer is of the type int
   char ch1, ch2; // ch1 and ch2 are assigned characters are of the type char
   string name;   // name is a string of characters of the type string

   // read one character from the user
   cout << "Enter a character: ";
   cin >> ch1;
   
   // read in an int value from the user
   cout << "Enter a number: ";
   cin >> intValue;
   
   // read another character
   cout << "Enter another character: ";
   cin >> ch2;
   
   //  now read in a string
   cout << "Enter a name: ";
   cin >> name;
   
   // finally read in a float type
   cout << "Enter a floating point value: ";
   cin >> floatValue;

   // Display the values read
   cout << endl << "ch1 = " << ch1 << endl;
   cout << "intValue =" << intValue << endl;
   cout << "ch2 = " << ch2 << endl;
   cout << "Name is " << name << endl;
   cout << "floatValue = " << floatValue << endl;
   
   system("pause");
   
   return 0;
}