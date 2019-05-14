// Lab 5 Exercise 2
// Convert to Roman numerals
//
// Program by: Kenny Hoang

#include <iostream>
using namespace std;

int main()
{
   int number; // variable of type int that holds the number inputted by user
   
   // Prompting user to enter a number
   cout << "Enter a number from 1 to 5: ";
   cin >> number;
   
   // switch statement converting the number inputted by the user
   // into the Roman numeral equivalent
   switch (number)
   {
      // First case: if number inputted is equal to 1, output I
      case 1:
         cout << "The Roman numeral equivalent is: I";
         cout << endl;
         break;
      // Second case: if number inputted is equal to 2, output II
      case 2:
         cout << "The Roman number equivalent is: II";
         cout << endl;
         break;
      // Third case: if number inputted is equal to 3, output III
      case 3:
         cout << "The Roman numeral equivalent is: III";
         cout << endl;
         break;
      // Fourth case: if number inputted is equal to 4, output IV
      case 4:
         cout << "The Roman numeral equivalent is: IV";
         cout << endl;
         break;
      // Fifth case: if number inputted is equal to 5, output V
      case 5:
         cout << "The Roman numeral equivalent is: V";
         cout << endl;
         break;
      // default: if number inputted is not between 1 and 5 inclusive, output statement
      default:
         cout << "The number must be in the range of 1 through 5 inclusive.";
         cout << endl;
   }
   system("pause");
}