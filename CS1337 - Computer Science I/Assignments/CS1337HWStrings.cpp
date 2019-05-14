/*  CS Homework - Strings
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 3/9/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
#include <string>
#include <cctype>
#include <cstring>
#include <cstdlib>

using namespace std;

// Function Prototypes
int sumDigits(string);
int numConsonants(string);
int numVowels(string);
int numSpace(string);

int main()
{
    int choice; // choice will hold a integer corresponding to the selected function
    int check = 0; // check is a sentinel value which is true if chioce is a valid option and false if chioce is not
    string s; // string s will hold the string input by user
    int value; // value will hold the integer values returned by the functions

    do
    {
    // Print menu
    cout << "Please select a function: " << endl;
    cout << "1. Sum the digits in a string. " << endl;
    cout << "2. Count the number of consonants in a string. " << endl;
    cout << "3. Count the number of vowels in a string. " << endl;
    cout << "4. Count the whitespace characters in a string. " << endl;
    cin >> choice;

    // checking if choice is valid
    if(choice == 1 || choice == 2 || choice == 3 || choice == 4)
        check = 1;
    else
        cout << "Invalid menu selection! " << endl; // else print error message
    }while(check == 0);

    cin.ignore(1000, '\n'); // ignore the next line left by the cin statement for the choice

    // Prompt user for input of string
    cout << "Please enter a string: ";
    getline(cin, s); // using getline read in a string from the console.

    switch(choice) // switch statement to determine which function to call based on the choice read in earlier
    {
    case 1:
        value = sumDigits(s);
        cout << "The sum of digits in \"" << s << "\" is: " << value << endl;
        break;
    case 2:
        value = numConsonants(s);
        cout << "The number of consonants in \"" << s << "\" is: " << value << endl;
        break;
    case 3:
        value = numVowels(s);
        cout << "The number of vowels in \"" << s << "\" is: " << value << endl;
        break;
    case 4:
        value = numSpace(s);
        cout << "The number of spaces in \"" << s << "\" is: " << value << endl;
        break;
    }
}

// function sumDigits calculates the sum of the digits in a string and returns the sum
// @param str - a string entered by user is passed to function for calculation number of digits in the string
// @return int - returns the sum of the digits in a string
int sumDigits(string str)
{
    int sum = 0, i = 0;
    char *ptr = new char[str.length() + 1];
    strcpy(ptr, str.c_str());

    do
    {
        if(isdigit(*(ptr+i))) // if the value we are pointing to is a digit
            sum += *(ptr+i) - '0'; // add to sum the value of the character and subtract '0' to get the integer value of the sum
        i++;
    }while(*(ptr+i) != '\0'); // while value we are pointing to is not the null terminating character

    delete [] ptr;
    return sum;
}

// function numConsonants calculates the number of consonants in a string and returns that number
// @param str - a string entered by user is passed to function for calculation for number of consonants in the string
// @return int - returns the number of the digits in the string
int numConsonants(string str)
{
    int length = str.length(), num = 0;
    char comp; // comp of variable type char holds the character being compared
    for(int i = 0; i < length; i++)
    {
        comp = toupper(str[i]); // converting the compared character to uppercase for easiness of comparison
        // if the compared value is not equal to any vowels or blank space characters
        if(comp != 'A' && comp != 'E' && comp != 'I' && comp != 'O' && comp != 'U' && !isspace(comp))
            num++; // increment the number of consonants
    }
    return num;
}

// function numVowels calculates the number of vowels in a string and returns that number
// @param str - a string entered by user is passed to function for calculation for the number of vowels in the string
// @return int - returns the number of vowels in the string
int numVowels(string str)
{
    int length = str.length(), num = 0;
    char comp; // comp of variable type char holds the character being compared
    for(int i = 0; i < length; i++)
    {
        comp = toupper(str[i]); // converting the compared character to uppercase for easiness of comparison
        // if the compared value is equal to any vowels
        if(comp == 'A' || comp == 'E' || comp == 'I' ||comp == 'O' || comp == 'U' || comp == 'Y')
            num++; // increment the number of vowels
    }
    return num;
}

// function numSpace calculates the number of spaces in a string and returns that number
// @param str - a string entered by user is passed to function for calculation for the number of spaces in teh string
// @return int - returns the number of spaces in the string
int numSpace(string str)
{
    int length = str.length(), sum = 0;
    for(int i = 0; i < length; i++)
        if(isspace(str[i]))
            sum++;
    return sum;
}
