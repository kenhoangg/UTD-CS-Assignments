// Lab 5 Exercise 1
// Financial aid program
//
// Program by: Kenny Hoang

#include <iostream>
using namespace std;

int main()
{
   char studentStatus;  // variable of type char that holds the answer to the undergraduate student question
   int annualIncome; // variable of type int that holds the annual income of the undergraduate
   
   // Prompting the user for their student status
   cout << "Are you an undergraduate student? ";
   cin >> studentStatus;
   cout << endl;

   // if statement to determine if the student is qualified for $1000 or $500 in financial aid
   if (studentStatus == 'y' || studentStatus == 'Y')
   {  
      // Prompting the user for their yearly income
      cout << "What is your current yearly income? ";
      cin >> annualIncome;
      cout << endl;
      
      // if statement to determine how much financial aid the studen qualifies for
      if (annualIncome <= 15000 && annualIncome >= 0)
      {
         cout << "You qualify for $1000 in financial aid." << endl;
      }
      else if (annualIncome < 0)
      {
         cout << "Income inputted must be greater than or equal to zero." << endl;
      }
      else
      {
         cout << "You qualify for $500 in financial aid." << endl;
      }
   }
   else if (studentStatus == 'n' || studentStatus == 'N')
   {
      cout << "You do not qualify for financial aid." << endl;
   }
   else
   {
      cout << "Error! Rerun program and please enter y or n. " << endl;
   }
   system("pause");
}