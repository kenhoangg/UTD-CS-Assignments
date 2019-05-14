/*  CS Assignment 3
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 2/10/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    int lines, cLines, check = 0;
    string fileName, line, two;
    while(check == 0)
    {
        cout << "Please enter file name: ";
        cin >> fileName;
        if(fileName == "*")
            return 0;

        ifstream input(fileName);

        if(!input)
            cout << "Could not find file!" << endl;
        else
        {
            while(!input.eof())
            {
                lines++;
                getline(input, line);
                if(line.compare(0,2,"//") == 0)
                    cLines++;
            }
            check = 1;
        }
    }
    cout << endl;
    cout << "Total number of lines read: " << lines << endl;
    cout << "Total number of comment lines: " << cLines << endl;
}


