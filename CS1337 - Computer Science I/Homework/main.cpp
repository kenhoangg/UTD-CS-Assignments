// Homework 6 - Driver Program
// Written by: Kenny Hoang
// CS1337.001
// Professor Smith
// 11/16/2015

#include "Scores.h"
#include <iostream>

using namespace std;

int main()
{
    TestScores T1;
    int i = 1;
    int test;
    while(i < 4)
    {
        cout << "Please enter test score number " << i << ": ";
        cin >> test;
        T1.setScores(test, i);
        cout << endl;
        i++;
    }

    int average = T1.avgScores();
    cout << "The average of these three scores is: " << average << endl;

}
