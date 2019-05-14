// Homework 7 - Month Class
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/7/2015

#include "Month.h"
#include <string>
#include <iostream>
using namespace std;

Month::Month()
{
    name = "";
    monthNumber = 0;
}

Month::Month(string n)
{
    name = n;
    if(n == "January")
    {
        monthNumber = 1;
    }
    else if(n == "February")
    {
        monthNumber = 2;
    }
    else if(n == "March")
    {
        monthNumber = 3;
    }
    else if(n == "April")
    {
        monthNumber = 4;
    }
    else if(n == "May")
    {
        monthNumber = 5;
    }
    else if(n == "June")
    {
        monthNumber = 6;
    }
    else if(n == "July")
    {
        monthNumber = 7;
    }
    else if(n == "August")
    {
        monthNumber = 8;
    }
    else if(n == "September")
    {
        monthNumber = 9;
    }
    else if(n == "October")
    {
        monthNumber = 10;
    }
    else if(n == "November")
    {
        monthNumber = 11;
    }
    else if(n == "December")
    {
        monthNumber = 12;
    }
}

Month::Month(int num)
{
    monthNumber = num;
    if(monthNumber == 1)
    {
        name = "January";
    }
    else if(monthNumber == 2)
    {
        name = "February";
    }
    else if(monthNumber == 3)
    {
        name = "March";
    }
    else if(monthNumber == 4)
    {
        name = "April";
    }
    else if(monthNumber == 5)
    {
        name = "May";
    }
    else if(monthNumber == 6)
    {
        name = "June";
    }
    else if(monthNumber == 7)
    {
        name = "July";
    }
    else if(monthNumber == 8)
    {
        name = "August";
    }
    else if(monthNumber == 9)
    {
        name = "September";
    }
    else if(monthNumber == 10)
    {
        name = "October";
    }
    else if(monthNumber == 11)
    {
        name = "Novemeber";
    }
    else if(monthNumber == 12)
    {
        name = "December";
    }
}

// prefix notation ++
Month Month::operator++()
{
    string months[12] = {"January", "February", "March", "April"
    "May", "June", "July", "August", "September", "October", "November", "December"};
    if(monthNumber == 12)
    {
        monthNumber = 1;
        name = "January";
    }
    else
    {
        monthNumber += 1;
        name = months[monthNumber];
    }
    return *this;
}

// postfix notation ++
Month Month::operator++(int)
{
    string months[12] = {"January", "February", "March", "April"
    "May", "June", "July", "August", "September", "October", "November", "December"};
    Month temp = *this;
    if(monthNumber == 12)
    {
        monthNumber = 1;
        name = "January";
    }
    else
    {
        monthNumber += 1;
        name = months[monthNumber];
    }
    return temp;
}

Month Month::operator--()
{
    string months[12] = {"January", "February", "March", "April"
    "May", "June", "July", "August", "September", "October", "November", "December"};
    if(monthNumber == 1)
    {
        monthNumber = 12;
        name = "December";
    }
    else
    {
        monthNumber -= 1;
        name = months[monthNumber];
    }
    return *this;
}

Month Month::operator--(int)
{
    string months[12] = {"January", "February", "March", "April"
    "May", "June", "July", "August", "September", "October", "November", "December"};
    Month temp = *this;
    if(monthNumber == 1)
    {
        monthNumber = 12;
        name = "December";
    }
    else
    {
        monthNumber -= 1;
        name = months[monthNumber];
    }
    return temp;
}

ostream& operator << (ostream& str, const Month &obj)
{
    str << "Name of month: " << obj.name << "\nNumber of Month: " << obj.monthNumber << endl << endl;
    return str;
}

istream& operator >> (istream& str, Month &obj)
{
    cout << "Please enter name of the month: ";
    getline(cin, obj.name);

    cout << "Please enter number of the month: ";
    cin >> obj.monthNumber;

    cout << endl;

    return str;
}


