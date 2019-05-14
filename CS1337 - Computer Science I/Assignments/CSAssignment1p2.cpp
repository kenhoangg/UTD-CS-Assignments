/*  CS Assignment 1 Part 2
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 1/27/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
using namespace std;

int main()
{
    char c = 'o'; // character literal used to print pattern
    int counter = 0; // variable of type int that is used as a counter to output the correct amount of characters to make the pattern per row
    for(int i = 1; i <= 5; i++) // for loop that will control the row currently outputing to
    {
        counter = 0; // reset counter to 0 after every pass
        while(counter < i) // while counter is less the the number of the current row
        {
            cout << 'o'; // print out character literal
            counter++;
        }
        cout << endl; // after reaching the number of the row move to next line for next row
    }
}
