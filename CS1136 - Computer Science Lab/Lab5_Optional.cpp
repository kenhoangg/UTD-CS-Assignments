// Lab 5 Optional Exercise
// Convert to Roman numerals
//
// Program by: Kenny Hoang

#include <iostream>
using namespace std;

int main()
{
   int number; // variable of type int that holds the number inputted by user
   
   // Prompting the user to enter a number
   cout << "Enter a number from 1 to 5: ";
   cin >> number;
   
   // if statement to determine what the roman numeral equivalent is
   if (number == 1)
   {
      // Printing out the Roman numeral equivalent of 1
      cout << "The Roman numeral equivalent is: I \n";
   }
   else if (number == 2)
   {
      // Printing out the Roman numeral equivalent of 2
      cout << "The Roman numeral equivalent is: II \n";
   }
   else if (number == 3)
   {
      // Printing out the Roman numeral equivalent of 3
      cout << "The Roman numeral equivalent is: III \n";
   }
   else if (number == 4)
   {
      // Printing out the Roman numeral equivalent of 4
      cout << "The Roman numeral equivalent is: IV \n";
   }
   else if (number == 5)
   {
      // Printing out the Roman numeral equivalent of 5
      cout << "The Roman numeral equivalent is: V \n";
   }
   else
   {  
      // Printing out the statement due to the number being outside of range
      cout << "The number must be in the range of 1 through 5 inclusive. \n";
   }
   system("pause");
}