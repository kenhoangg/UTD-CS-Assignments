/*  Write a program that asks for a password and then verifies that it meets the criteria below.
 *  If it doesn't meet the specifications, the program should display a message telling user why.
 *  - at least 6 characters long
 *  - at least one upper and lower case character
 *  - at least one digit
 *  - at least one punctuation character
 *  - no spaces
 */
// Include statments
#include <iostream>
#include <cctype>
using namespace std;

void passCheck(char p[])
{
    int upper = 0, lower = 0, digit = 0, punct = 0, blank = 0;
    int counter = 0;
    do
    {
        counter++;

        if(!(isdigit(p[counter])) && digit == 0)
            digit = 0;
        else
            digit = 1;

        if(!(islower(p[counter])) && lower == 0)
            lower = 0;
        else
            lower = 1;

        if(!(isupper(p[counter])) && upper == 0)
            upper = 0;
        else
            upper = 1;

        if(!(ispunct(p[counter])) && punct == 0)
            punct = 0;
        else
            punct = 1;

        if(!(isblank(p[counter])) && blank == 0)
            blank = 1;
        else
            blank = 0;
        p++;

    }while(p[counter] != '\0');

    if(counter < 6)
        cout << "Password must be at least 6 characters long.\n";

    if(punct == 0)
        cout << "Password must contain at least one punctuation character.\n";

    if(digit == 0)
        cout << "Password must contain at least one digit.\n";

    if(upper == 0 || lower == 0)
        cout << "Password must contain at least one upper and lower case character.\n";

    if(blank == 0)
        cout << "Password cannot contain spaces.\n";
}

int main()
{
    char password [50];
    cout << "Please enter password: ";
    cin >> password;

    passCheck(password);
}
