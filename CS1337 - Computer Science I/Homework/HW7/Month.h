// Homework 7 - Month Class
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/7/2015

#ifndef MONTH_H
#define MONTH_H

#include <string>
#include <fstream>
using namespace std;

class Month;

ostream& operator <<(ostream&, const Month&);
istream& operator >>(istream&, Month&);

class Month
{
private:
    string name;
    int monthNumber;
public:
    Month();
    Month(string);
    Month(int);

    Month operator++(); //prefis
    Month operator++(int); //postfix
    Month operator--(); //prefix
    Month operator--(int); // postfix

    void setName(string n)
    {   name = n;   }

    string getName() const
    {   return name;    }

    void setMonthNum(int num)
    {   monthNumber = num;    }

    int getMonthNum()
    {   return monthNumber; }

    friend ostream& operator <<(ostream&, const Month&);
    friend istream& operator >>(istream&, Month&);
};
#endif // MONTH_H
