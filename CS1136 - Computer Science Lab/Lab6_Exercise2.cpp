// Lab 6 Exercise 2
// Calculate investment amount
//
// Program by: Kenny Hoang

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
   double initialAmount;   // variable of type doulbe that holds the initial investment value
   double interestRate; // variable of type doulbe that holds the annual interest rate
   double monthlyRate;  // variable of type double that holds the monthly interest rate
   double monthlyInterest; // variabe of type double that holds the interest earned per month
   double investmentBal = 0;  // variabe of type double that holds the total worth of the investment
   int numMonths; // variable of type int that holds the number of months invested
   
   // Prompting the user to enter the initial investment amount
   cout << "Please enter an initial investment amount of $10,000.00 or more: ";
   cin >> initialAmount;
   while (initialAmount < 10000)
   {
      cout << "Error! The minimum investment amount is $10,000.00 \n";
      cout << "Please enter the amount of the investment: ";
      cin >> initialAmount;
   }
   
   // Prompting the user to enter the annual interest rate
   cout << "Please enter an annual interest rate: ";
   cin >> interestRate;
   while (interestRate < 0)
   {
      cout << "Error! The interest rate should be positive. \n";
      cout << "Please enter an annual interest rate: ";
      cin >> interestRate;
   }
   
   // Prompting the user to enter the number of months of the investment
   cout << "Please enter the number of months of the investment: ";
   cin >> numMonths;
   while (numMonths < 0)
   {
      cout << "Error! The number of months should be positive. \n";
      cout << "Please enter the number of months of the investment: ";
      cin >> numMonths;
   }
   
   // Calulating the monthly interest rate
   monthlyRate = interestRate / 12.0 / 100.0;
   // Saving the initial amount invested into the amount invested
   investmentBal = initialAmount; 
   int count = 0; // Variable of type int that acts as a counter for the while loop
   while (count < numMonths)
   {
      monthlyInterest = investmentBal * monthlyRate;
      investmentBal += monthlyInterest;
      count++;
   }
   // Printing out a stream containing the initial amount and the resulting amount the investment is worth
   cout << fixed << setprecision(2);
   cout << "After 12 months your investment of $" << initialAmount << " will be worth $" << investmentBal << endl;

   system("pause");
}