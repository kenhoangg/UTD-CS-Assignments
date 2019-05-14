/*  CS Assignment 6 - Classes
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 4/12/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#ifndef BANK_H
#define BANK_H

#include <iostream>
using namespace std;

class Bank
{
private:
    int accountNum;
    string name;
    double balance;
public:
    // Constructors
    Bank();
    Bank(int, string, double);

    // Mutator functions
    string withdraw(double);
    void deposit(double);

    void setName(string n)
    {   name = n;   }

    // Accessor Functions
    int getAccountNumber() const
    {   return accountNum;    }

    string getName() const
    {   return name;    }

    double getBalance() const
    {   return balance; }
};

#endif // BANK_H
