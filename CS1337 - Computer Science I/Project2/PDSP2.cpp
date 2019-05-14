/* Project 2: Palpatine's Delivery Service
 * Use file I/O techniques and C-string and
 * character functions to validate data
 * Program by: Kenny Hoang
 * Class: CS1337.001
 * Date: 10/7/2015
 */

//Include Statements
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <cstring>
#include <string>
#include <iomanip>
#include <cmath>

using namespace std;

int verifyShipment(char[]);
void calcShipment(char, char, char, double, double[], double[]);
void shipReport(double[], double[]);

int main()
{
    ifstream input;
    input.open("shipments.txt");
    string str;
    char sWeight[20];
    double cost[8] = {0}, time[8] = {0}, weight;
    char serviceCode, shipCode, delivCode, cstr[50];
    int valid;

    while(!input.eof()) // while we are not at end of input file
    {
        getline(input, str); // get the line and store into variable str
        strcpy(cstr, str.c_str()); // convert from string to cstring by copying using c_str() function

        valid = verifyShipment(cstr); // call validation function

        if(valid == 1)
        {
            for(int i = 0; (unsigned)i < strlen(cstr); i++)
            {
                if(i == 0)
                    serviceCode = toupper(cstr[i]);// assign value to service code
                if(i == 2)
                    shipCode = toupper(cstr[i]);// assign value to shipment code
                if(i == 4)
                    delivCode = toupper(cstr[i]); // assign value to delivery code
            }
            strcpy(sWeight, cstr+6); // copy string from the beginning of the floating point number to end of line
            weight = atof(sWeight); // convert string to float and assign to weight
            if(weight > 0) // check if weight is not negative
                calcShipment(serviceCode, shipCode, delivCode, weight, cost, time); // call calculation function
        }
    }
    shipReport(cost, time); // call shipReport to print report to console
}

int verifyShipment(char shipLine[])
{
    int valid = 1, decimal = 0, decimalLoc, dupDec;
    for(int i = 0; (unsigned)i < strlen(shipLine); i++)
    {
        if(i == 0)
            if(toupper(shipLine[0]) != 'F' || toupper(shipLine[0]) != 'P' || toupper(shipLine[0]) != 'E')
            {
                valid = 0;
                break; // break out of loop checking shipping format
            }

        if(i == 1 || i == 3 || i == 5)
            if(!isspace(shipLine[i]))
            {
                valid = 0;
                break; // break out of loop checking shipping format
            }

        if(i == 2 || i == 4)
            if(toupper(shipLine[i]) != 'Y' || toupper(shipLine[i]) != 'V' || toupper(shipLine[i]) != 'E' || toupper(shipLine[i]) != 'M'
               || toupper(shipLine[i]) != 'J' || toupper(shipLine[i]) != 'S' || toupper(shipLine[i]) != 'U' || toupper(shipLine[i]) != 'N')
            {
                valid = 0;
                break; // break out of loop checking shipping format
            }

        if(i == 6)
            if(isdigit(shipLine[6]))
            {
                for(int j = 7; (unsigned)j < strlen(shipLine); j++)
                {
                    if(ispunct(shipLine[j]) && decimal == 1) // if we find another decimal
                    {
                        dupDec = 1;
                        break; // break out of loop checking for decimal
                    }

                    if(ispunct(shipLine[j]) && decimal == 0)
                    {
                        decimal = 1;
                        decimalLoc = j;
                    }
                }

                for(int k = decimalLoc+1; (unsigned)k < strlen(shipLine); k++) // for loop to check elements after the decimal
                    if(!isdigit(shipLine[k])) // check if all values after the decimal are digits
                    {
                        valid = 0;
                        break; // break out of for loop checking for numbers after decimal
                    }
                if(valid == 0)
                    break; // break out of loop checking shipping format

                if(decimal != 1 || dupDec == 1) // if there is no decimal or more than one decimal, don't process line
                {
                    valid = 0;
                    break; // break out of loop checking shipping format
                }
            }
    }
    if(shipLine[2] == shipLine[4])
        valid = 0;
    return valid;
}

void calcShipment(char service_code, char ship_code, char deliv_code, double shipWeight, double shipCost[], double delivTime[])
{
    double distance[8] = {36, 67, 93, 141, 483, 886, 1782, 2793}; // array of type double holding the distances of each planet from the sun
    double gravity[8] = {0.27, 0.86, 1.0, 0.37, 2.64, 1.17, 0.92, 1.44}; // array of type double holding the gravity factor of each planet
    double cost, speed, distBetween;
    int i, j;

    if(service_code == 'F') // if service code is First class
    {
        // assign cost and speed appropriate values
        cost = 0.25;
        speed = 0.045;
    }

    if(service_code == 'P') // if service code is Priority
    {
        // assign cost and speed appropriate values
        cost = 0.75;
        speed = 0.095;
    }

    if(service_code == 'E') // if service code is Express
    {
        // assign cost and speed appropriate values
        cost = 1.5;
        speed = .175;
    }

    // check shipping code and set control value for appropriate planet i.e. i = 0 is for Mercury etc.
    if(ship_code == 'Y')
        i = 0;

    if(ship_code == 'V')
        i = 1;

    if(ship_code == 'E')
        i = 2;

    if(ship_code == 'M')
        i = 3;

    if(ship_code == 'J')
        i = 4;

    if(ship_code == 'S')
        i = 5;

    if(ship_code == 'U')
        i = 6;

    if(ship_code == 'N')
        i = 7;

    // check delivery code and set control value for appropriate planet i.e. i = 0 is for Mercury etc.
    if(deliv_code == 'Y')
        j = 0;

    if(deliv_code == 'V')
        j = 1;

    if(deliv_code == 'E')
        j = 2;

    if(deliv_code == 'M')
        j = 3;

    if(deliv_code == 'J')
        j = 4;

    if(deliv_code == 'S')
        j = 5;

    if(deliv_code == 'U')
        j = 6;

    if(deliv_code == 'N')
        j = 7;

    // Calculations
    shipWeight *= gravity[j]; // calculate weight at destination planet
    shipCost[i] += (shipWeight * cost); // using weight at destination planet, calculate cost and then add to shipping planet cost total
    distBetween = distance[i] - distance[j]; // calculate distance between shipping and destination planet
    delivTime[i] += (abs(distBetween) / speed); // using calculated distance and speed from the service code, calculate the delivery time and add to total shipping planet total time
}


void shipReport(double shipCost[], double delivTime[]) // Function shipReport prints out a report to the console window
{
    const char sep = ' ';
    const string planetName[8] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"}; // array containing strings of the planet names
    cout << "Planet Name" << setw(8) << right << setfill(sep) << "Total Cost" << setw(8) << setfill(sep) << "Total Time" << endl;
    for(int i = 0; i < 8; i++)// for loop to control number of rows we print out for the report
        cout << planetName[i] << setw(8) << setfill(sep) << shipCost[i] << setw(8) << setfill(sep) << delivTime[i] << endl; // print out name and values for shipping cost and delivery times
}
