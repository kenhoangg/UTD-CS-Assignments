/*  CS Assignment 6 - Classes
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 4/12/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include "Bank.h"
#include <string>
#include <sstream>

using namespace std;

// Bank object default constructor
Bank::Bank()
{
    accountNum = 9999;
    name = "";
    balance = 0;
}

// Bank object constructor with parameters for the account number, name on account, and balance
Bank::Bank(int aNum, string n, double bal)
{
    accountNum = aNum;
    name = n;
    balance = bal;
}

// withdraw memeber function
// @param amt - a double variable that holds the amount being withdrawn from the account
string Bank::withdraw(double amt)
{
    string message, amount;
    ostringstream s;
    if(amt <= balance) // checking if the amount withdrawn is less than the amount in the account
    {
        balance -= amt;
        message = "Current balance: $";
        s << balance;
        amount = s.str();
        message.append(amount);
        return message; // return the current balance of the account
    }
    else
        return "Insufficient balance."; // return error message if the amount is larger than available
}

// deposit member function
// @param amt - a double variable that holds the amount being deposited to the account
void Bank::deposit(double amt)
{
    balance += amt;
}
