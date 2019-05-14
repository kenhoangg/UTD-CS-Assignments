/*  CS Assignment 5 - Recursion
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 4/20/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
#include <string>

using namespace std;

// function Prototypes
bool isPalindrome(string);
void sameCase(string&);
void ignorePunctSpace(string&);

int main()
{
    string input, temp;
    bool check;

    while(true)
    {
        cout << "Please enter a string of characters: ";
        getline(cin, input);

        if(input == "")
            break;

        temp = input;
        sameCase(temp);
        ignorePunctSpace(temp);
        check = isPalindrome(temp); // Pass temp because the string will be modified, keeping input as the original
                                    // string passed by the user

        if(check == true)
            cout << input << " is a palindrome." << endl;
        else
            cout << input << " is not a palindrome." << endl;
    }
}

// function isPalindrome is passed a string and checks whether it is a palindrome or not and returns a boolean value
// @param s - holds the string input by the user
// @return - isPalindrome returns true if string is a palindrome or false if it is not
bool isPalindrome(string s)
{
    int length = s.length();
    if(length == 1) // if the length is 1 then the string is a palindrome
        return true;
    else if(s.at(0) == s.at(length-1)) // check if the characters at the beginning is equal to the end
        isPalindrome(s.substr(1,(length - 2)));
    else
        return false;
}

// function sameeCase is padded a string and changes all letters in the string to the same case for palindrome check
// @param s - holds the string input by the user
void sameCase(string &s)
{
    int length = s.length();

    for(int i = 0; i < length; i++)
        s[i] = tolower(s[i]);
}

// function ignorePunctSpace modifies the string input by the user by removing the punctuation and spaces in the string
// @param s - holds the string input by the user
void ignorePunctSpace(string &s)
{
    int length = s.length(), ignored = 0, counter = 0; // ignored is a flag that will set to 1(true) when at least one punctuation is removed from the string
    string tempString, sub;                            // counter is a variable that keeps track of how many times punctuation has been removed
    tempString = sub = s;
    for(int i = 0; i < length; i++)
        if(ispunct(s[i]) || isspace(s[i]))
        {
            if(ignored == 0)
            {
                tempString = sub.substr(0, i);
                ignored = 1;
            }
            else
                tempString = sub.substr(0, i - counter);
            tempString.append(s, i + 1, s.npos);
            sub = tempString;
            counter++;
        }
    s = tempString;
}
