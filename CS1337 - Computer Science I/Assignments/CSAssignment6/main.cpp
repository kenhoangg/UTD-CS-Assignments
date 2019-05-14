/*  CS Assignment 6 - Classes
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 4/12/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include "Bank.h"
#include <iostream>
using namespace std;

// Function Prototypes
void displayAccountInfo(Bank);
void enterValues(int&, string&, double&);
void enterNums(int&, double&);
void checkDuplicate(int, Bank*);

int main()
{
    Bank *ptr;
    ptr = new Bank[10]; //array of pointers to Bank objects

    int menu = 0, counter = 0; // variable menu holds the menu selection of the user
                               // variable counter keeps track of the number of accounts created by the user
    int num;
    string name, str;
    double bal, amt;
    bool found;

    while(menu != 6)
    {
        found = false;
        cout << "Bank Menu: " << endl;
        cout << "1. Create Bank object with values for accountNumber, name, and balance." << endl;
        cout << "2. Create Bank object with no parameters." << endl;
        cout << "3. Deposit to Bank account (request account number and amount)." << endl;
        cout << "4. Withdraw from Bank account (request account number and amount)." << endl;
        cout << "5. Display information for all accounts." << endl;
        cout << "6. Exit the program." << endl;

        cin >> menu;

        switch(menu) // switch case to handle menu selection
        {
            case 1:
                {
                    enterValues(num, name, bal);
                    checkDuplicate(num, ptr);
                    Bank accnt(num, name, bal);
                    ptr[counter] = accnt;
                    counter++;
                    break;
                }
            case 2:
                {
                    Bank acct;
                    ptr[counter] = acct;
                    counter++;
                    break;
                }
            case 3:
                {
                    enterNums(num, amt);
                    for(int j = 0; j < 10; j++)
                    {
                        if(ptr[j].getAccountNumber() == num)
                        {
                            ptr[j].deposit(amt);
                            found = true;
                            break;
                        }
                    }
                    if(found == false)
                            cout << "Account number does not exist!" << endl;
                    break;
                }
            case 4:
                {
                    enterNums(num, amt);
                    for(int j = 0; j < 10; j++)
                    {
                        if(ptr[j].getAccountNumber() == num)
                        {
                            str = ptr[j].withdraw(amt);
                            found = true;
                            break;
                        }
                    }
                    if(found == false)
                        cout << "Account number does not exist!" << endl;
                    else
                        cout << str << endl;
                    break;
                }
            case 5:
                {
                    for(int i = 0; i < counter; i++)
                        displayAccountInfo(ptr[i]);
                    break;
                }
        }
        cout << endl;
    }
    delete ptr; // deleting dynaically allocated array of bank pointers
}

// function displayAccountInfo uses the public member functions of Bank objects to retrieve
// the account numbers, name on account, and balances, and then displays to console the values
// @param obj - displayAccountInfo is passed Bank objects to display the values of its account numbers, name on account, and balances
void displayAccountInfo(Bank obj)
{
    cout << "Account number: " << obj.getAccountNumber() << endl;
    cout << "Name on account: " << obj.getName() << endl;
    cout << "Balance of account: $" << obj.getBalance() << endl << endl;;
}

// function enterValues prompts the user to enter the values for a new Bank object
// @param numA is a int variable that will hold the value of the account number entered by the user
// @param n will hold a string input by the user to be the name on account
// @param b is a double variable that holds the balance of the account input by the user
void enterValues(int& numA, string& n, double& b)
{
    cout << "Please enter account number: ";
    cin >> numA;
    cout << "Please enter name: ";
    cin.ignore();
    getline(cin, n);
    cout << "Please enter balance: ";
    cin >> b;
}

// function enterNums prompts the user to enter the values for withdrawal or deposit
// @param numA is a int variable that will hold the value of the account number entered by the user
// @param balA is a double variable that will hold the amount being withdrawn/deposited
void enterNums(int& numA, double& balA)
{
    cout << "Please enter account number: ";
    cin >> numA;
    cout << "Please enter amount: ";
    cin >> balA;
}

// function checkDuplicate checks if the account number entered is a duplicate
// @param numA is a int variable that holds the value of the account number entered by the user
// @param *p is a pointer to a array of Bank objects
void checkDuplicate(const int numA, Bank *p)
{
    for(int k = 0; k < 10; k++)
        if((p+k)->getAccountNumber() == numA)
        {
            cout << "Error! Account number already exists!" << endl;
            break;
        }
}
