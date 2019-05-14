/*Homework 2
 * Write a program that extracts and displays all vowels in a file
 *
 * Program by: Kenny Hoang
 * netid: kth140230
 * Date: 9/16/2015
 */

#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

int main()
{
    cout << "Please enter name of file: ";
    char name[10];
    cin >> name;
    ifstream input;
    ofstream output;
    char name2[30] = "vowels_";
    strcat(name2, name);
    string line;
    char vowelCheck[50];

    input.open(name);
    output.open(name2, ios::out);
    while(!input.eof())
    {
        getline(input, line);
        strcpy(vowelCheck, line);
        for(int i = 0; i < 50;i++)
        {

            if(vowelCheck[i] == 'a' || 'e' || 'i' || 'o' || 'u')
                output << vowelCheck << endl;
        }
    }
    input.close();
    output.close();

    return 0;
}
