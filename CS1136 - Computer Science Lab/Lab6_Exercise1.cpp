// Lab 6 Exercise 1
// Calculate the product
//
// Program by: Kenny Hoang

#include <iostream>
using namespace std;

int main()
{
   int number, product = 1, count = 0; // variables of type int that hold the number inputted, the product of the numbers inputted, 
                                       // and the number of times the loop has ran
   
   // Prompting the user to enter a number to determine a product
   cout << "Enter an integer number to be included in the product" 
      << endl << "or enter 0 to end the input: ";
   cin >> number;
   cout << endl;
   
   // do-while loop
   do
   {
      // if statement: if the number inputted is not 0, continue
      if (number != 0)
      {
      product = product * number; // calculating product
      count++; // the count variable increases each time the loop is ran
      // Prompting the user to input anumber to determine a product
      cout << "Enter an integer number to be included in the product" 
         << endl << "or enter 0 to end the input: ";
      cin >> number;
      cout << endl;
      }
   }
   while (number != 0);
   // if statement: if the count variable is greater than 0, continue
   if (count > 0)
   {
      // Printing out a stream that contains the product of the numbers inputted
      cout << endl << "The product is " << product << "." << endl;
   }

   system("pause");
}