// Homework 7 - Month Class
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/7/2015

#include "Month.h"
#include <iostream>
using namespace std;


int main()
{
    Month M1;
    cin >> M1;
    cout << M1;

    Month M2("March");
    cout << "M2 Name of month: " << M2.getName() << endl;
    cout << "M2 Number of month: " << M2.getMonthNum() << endl << endl;

    Month M3(12);
    cout << "M3 Name of month: " << M3.getName() << endl;
    cout << "M3 Number of month: " << M3.getMonthNum() << endl << endl;

    M1 = M2++;
    cout << "M1 Name of month: " << M1.getName() << endl;
    cout << "M1 Number of month: " << M1.getMonthNum() << endl << endl;

    ++M2;
    cout << "M2 Name of month: " << M2.getName() << endl;
    cout << "M2 Number of month: " << M2.getMonthNum() << endl << endl;

    --M1;
    cout << "M1 Name of month: " << M1.getName() << endl;
    cout << "M1 Number of month: " << M1.getMonthNum() << endl << endl;

    M3--;
    cout << "M3 Name of month: " << M3.getName() << endl;
    cout << "M3 Number of month: " << M3.getMonthNum() << endl << endl;
}
