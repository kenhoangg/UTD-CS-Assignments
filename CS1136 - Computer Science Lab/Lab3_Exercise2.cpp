// Lab 3 Exercise 2 
// Calculate MPH (Miles Per Hour).
//
// Program by: Kenny Hoang

#include <iomanip>
#include <iostream>
using namespace std;

int main()
{
   double startMiles; // startMiles is assigned the miles at the start and is of type double
   double endMiles; // endMiles is assigned the miles at the end and is of type double
   double totalMiles; // totalMiles represents the calculated miles traveled and is of type double
   double hours; // hours represents the toal time of the trip and is of type double
   double mph; // mph is the calculated miles per hour traveled during the trip and is of type double
   
   // Asking the user the miles at the start and the end of the trip
   cout << "Enter the starting mileage: ";
   cin >> startMiles;
   
   cout << "Enter the ending mileage: ";
   cin >> endMiles;

   // Asking the user how many miles the trip took
   cout << "Enter the number of hours traveled: ";
   cin >> hours;

   // Calculating the total miles traveled
   totalMiles = endMiles - startMiles;   

   // Calculating the miles per hour during the trip
   mph = totalMiles / hours;
   
   // Printing the total miles and miles per hour
   cout << fixed << setprecision(1);
   cout << endl;
   cout << setw(13) << "Total miles " << setw(7) << totalMiles << endl;
   cout << setw(13) << "Miles/Hour " << setw(7) << mph << endl;
   system("pause");
}