/*  CS Assignment 1 Part 3
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 1/27/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
using namespace std;

int main()
{
    int value1 = 2000000000;// int value1 = 3000000000; Line 4, int value1 should be assigned a lower value because 3000000000 will cause an overflow due to it being too large for an int
    int value2, value3;
    char middleInitial = 'G'; // char middleInitial = "G"; Line 6, G is a single character and should be in single quotes and not double
    bool forme=true;// boolean 4me=true; Line 7, boolean is not a data type, 4me is an invalid variable name
    double capacity=54.89;
    string name = "Michele"; //string name = 'Michele'; Line 9, string literals should be in double quotes not single quotes
    cout << "value1 = " << value1 << endl;
    value2 = capacity;
    cout << "value2 = " << value2 << endl;
    cout << "middleInitial = " << middleInitial << endl;
    value3 = 13;// 13 = value3; Line 15, assignment should be in the form variableName = value;
    cout << "value3 = " << value3 << endl;
    cout << "forme = " << forme << endl;
    cout << "name = " << name << endl;
    return 0;
}
