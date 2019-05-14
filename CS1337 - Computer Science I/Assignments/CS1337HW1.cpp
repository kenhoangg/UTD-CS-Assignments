/*  CS Homework 1
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 3/7/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
#include <string>
#include <cstring>
#include <cctype>
using namespace std;

// Function prototypes
int checkLength(string);
int checkUpper(char*, int);
int checkLower(char*, int);
int checkDigit(char*, int);
int checkSpecial(char*, int);
int checkSpaces(char*, int);

int main()
{
    string pass;
    int lengthStatus, upperStatus, lowerStatus, digitStatus, specialStatus, spaceStatus, status;
    lengthStatus = upperStatus = lowerStatus = digitStatus = specialStatus = spaceStatus = status = 0;

    do
    {
    cout << "Please enter a password: ";
    getline(cin, pass);

    char* cstr = new char[pass.length() + 1];
    strcpy(cstr, pass.c_str());

    // Calling functions to check the password requirements
    lengthStatus = checkLength(pass);
    upperStatus = checkUpper(cstr, pass.length());
    lowerStatus = checkLower(cstr, pass.length());
    digitStatus = checkDigit(cstr, pass.length());
    specialStatus = checkSpecial(cstr, pass.length());
    spaceStatus = checkSpaces(cstr, pass.length());

    if(lengthStatus == 1 && upperStatus == 1 && lowerStatus == 1 && digitStatus == 1 && specialStatus == 1 && spaceStatus == 1)
        status = 1;

     // Printing corresponding valid and invalid messages
    if(status == 0)
        cout << "Invalid Password!" << endl;
    else
        cout << "Password is valid." << endl;

    delete[] cstr;
    }while(status == 0);

    return 0;
}

int checkLength(string password)
{
    if(password.length() < 8)
        return 0;
    else
        return 1;
}

int checkUpper(char* c, int length)
{
    for(int i = 0; i < length; i++)
        if(isupper(*(c + i)))
            return 1;
    return 0;
}

int checkLower(char* c, int length)
{
    for(int i = 0; i < length; i++)
        if(islower(*(c + i)))
            return 1;
    return 0;
}

int checkDigit(char* c, int length)
{
     for(int i = 0; i < length; i++)
        if(isdigit(*(c + i)))
            return 1;
    return 0;
}

int checkSpecial(char* c, int length)
{
    int i = 0;
    do
    {
        if((*(c + i)) == '~' || (*(c + i)) == '!' || (*(c + i)) == '@' || (*(c + i)) == '#' || (*(c + i)) == '$' || (*(c + i)) == '%' || (*(c + i)) == '^' || (*(c + i)) == '&' || (*(c + i)) == '*' || (*(c + i)) == '('
            || (*(c + i)) == ')' || (*(c + i)) == '_' || (*(c + i)) == '+' || (*(c + i)) == '=' || (*(c + i)) == '-' || (*(c + i)) == '<' || (*(c + i)) == '>' || (*(c + i)) == '{' || (*(c + i)) == '}' || (*(c + i)) == '['
            || (*(c + i)) == ']' || (*(c + i)) == ',' || (*(c + i)) == '.')
            return 1;
        i++;
    }while(*(c + i) != '\0');
    return 0;
}

int checkSpaces(char* c, int length)
{
    int i = 0, blank = 0;
    do
    {
        if((isspace(*(c + i))) && blank == 0)
            blank = 1;
        i++;
    }while(*(c + i) != '\0');

    if(blank == 1)
        return 0;
    else
        return 1;
}
