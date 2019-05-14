// Lab 4 Exercise 2
// History grading project
//
// Program by: Kenny Hoang

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
   int testScore1;   // variable of type int with a value representing the first test score
   int testScore2;   // variable of type int with a value representing the second test score
   int testScore3;   // variable of type int with a value representing the third test score
   int totalScore;   // variable of type int with a value representing the total score after dropping one test
   
   // Prompting user for the first test score
   cout << "Enter the score for test #1: ";
   cin >> testScore1;
   cout << endl;
   
   // Prompting user for the second test score
   cout << "Enter the score for test #2: ";
   cin >> testScore2;
   cout << endl;
   
   // Prompting user for the third test score
   cout << "Enter the score for test #3: ";
   cin >> testScore3;
   cout << endl;
   
   // Printing out the three test scores
   cout << "First test:" << setw(6) << testScore1 << endl;
   cout << "Second test:" << setw(5) << testScore2 << endl;
   cout << "Third test:" << setw(6) << testScore3 << endl;
   cout << endl;
   
   // If statement to determine which test to drop and calculating the total score
   if (testScore1 >= testScore2)
   {
      totalScore = testScore1 + testScore3;
      cout << "After dropping test #2, the points earned are " << totalScore << "." << endl;
      cout << endl;
   }
   else
   {
      totalScore = testScore2 + testScore3;
      cout << "After dropping test #1, the points earned are " << totalScore << "." << endl;
      cout << endl;
   }
   
   // If statement comparing the total score to the grading scale
   // to see at letter grade the student received
   if (totalScore >= 92)
   {
      cout << "The letter grade is A." << endl;
   }
   else if (totalScore < 92 && totalScore >= 82)
   {
      cout << "The letter grade is B." << endl;
   }
   else if (totalScore < 82 && totalScore >= 72)
   {
      cout << "The letter grade is C." << endl;;
   }
   else
   {
      cout << "The letter grade is F." << endl;
   }
   
   system("pause");
}