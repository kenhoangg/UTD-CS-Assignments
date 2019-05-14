/*  CS Assignment 1 Part 1
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 1/27/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
using namespace std;

int main()
{
    double price, taxRate1, taxRate2, totalCost1, totalCost2; // variables of type double that hold the price, sales tax rates, and total cost of items using values inputed by user
    int numItems; // variable of type int that holds the number of items input by user
    string nameState1, nameState2; // string variable that holds the names of states input by user

    // Prompting user to input price and number of items
    cout << "Please enter price and number of items: ";
    // Read in values from console
    cin >> price >> numItems;
    // Output to console prompt user to input name of state and its sales tax rate
    cout << "Enter the name of the state and its sales tax rate: ";
    // Read in from console name and tax rate of state
    cin >> nameState1 >> taxRate1;
    // Output to console prompt user to input name of state and its sales tax rate
    cout << "Enter the name of the state and its sales tax rate: ";
    // Read in from console name and tax rate of state
    cin >> nameState2 >> taxRate2;
    cout << endl;

    // Calculate total cost of item in the two states
    totalCost1 = (price + (price * taxRate1)) * numItems;
    totalCost2 = (price + (price * taxRate2)) * numItems;

    // Print out the price, number of items, and name and tax rate of the states to console for user to see
    cout << "Price of item is " << price << " " << " Number of items is " << numItems << endl;
    cout << "Name of state is " << nameState1 << " " << "and the sales tax rate is " << taxRate1 << endl;
    cout << "Name of state is " << nameState2 << " " << "and the sales tax rate is " << taxRate2 << endl;

    // if statement to compare cost in first state to second state and output accordingly
    if(totalCost1 < totalCost2)
        cout << "Recommended to buy in " << nameState1 << ". Total cost is " << totalCost1 << " compared to " << totalCost2 << " in " << nameState2 << endl;
    else
        cout << "Recommended to buy in " << nameState2 << ". Total cost is " << totalCost2 << " compared to " << totalCost1 << " in " << nameState1 << endl;
}
