// Lab6_Optional
// Sum of all integers within a range
//
// Program by: Kenny Hoang

#include <iostream>
using namespace std;

int main()
{
   int larger; // variable of type int that holds the "larger"(first) integer inputted by the user
   int smaller;   // variable of type int that holds the "smaller"(second) integer inputted by the user
   int count;  // variable of type int that holds the smaller or larger integer depending on the numbers inputted
               // along with being the number being changed to calculate the sum of numbers within a range
   int sum = 0;   // variable of type int that holds the sum of numbers within a given range
   
   // Prompting the user to enter the larger number of the range [a,b]
   cout << "Please enter the larger number within the range: ";
   cin >> larger;
   
   // Prompting the user to enter the smaller number of the range [a,b]
   cout << "Please enter the smaller number within the range: ";
   cin >> smaller;

   if (smaller != larger && smaller < larger)
   {
      count = smaller;
      while (count <= larger)
      {
         sum += count;
         count++;
      }
      cout << "The sum of " << smaller << " and " << larger << " is " << sum << endl;
   }
   else if (smaller != larger && smaller > larger)
   {
      count = larger;
      while (count <= smaller)
      {
         sum += count;
         count++;
      }
      cout << "The sum of " << smaller << " and " << larger << " is " << sum << endl;
   }
   else
   {
      sum = smaller;
      cout << "The sum of " << smaller << " and " << larger << " is " << sum << endl;
   }
   system("pause");
}