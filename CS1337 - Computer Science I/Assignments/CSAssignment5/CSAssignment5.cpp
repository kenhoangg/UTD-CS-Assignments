/*  CS Assignment 5 - Check Out
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 3/28/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
#include <fstream>
#include <cstring>
#include <cctype>
#include <iomanip>
using namespace std;

// Structures
struct Product
{
    string pCode;
    string name;
    int salesType;
    double pricePer;
    double inventoryLvl;
};

// Constants and Global Variables
const int SIZE = 100;
Product *ptr;

// Function Prototypes
bool readInventory(string filename, int &numItems);
double checkout(int numItems, int *itemArray, int&, double* arrayUnitsWeight);
bool updateInventory(string filename, int numItems);
bool validPLU(string, int, int&);
bool validUnitWeight(double, int);
int checkDigit(char*, int);
void displayCheckOut(int);
void adjustInventory(int*, double*, const int);

int main()
{
    int num = 0, menu; // variable of type num that represents the number of items in stock (lines in the input file)
    if(!readInventory("products.txt", num)) // call readInventory to read from "products.txt"
                                        // pass num by reference to change it from the readInventory function
    {
        cout << "Could not find file." << endl;
    }

    do
    {
        // Display Menu
        cout << "Store Menu: \n";
        cout << "1. Check Out" << endl;
        cout << "2. Close the store and exit." << endl;
        cout << "Please enter a menu function: ";
        cin >> menu;

        if(menu == 1) // if menu selection is check out
        {
            displayCheckOut(num); // call seperate check out function
        }
        else if(menu != 1 && menu != 2)
            cout << "Error! Invalid menu function.\n";

    }while(menu != 2);

    updateInventory("products.txt", num); // call function to update inventory at close
}

// function readInventory reads from input from file into array of pointers to struct Product
// @param filename - holds the name of the file input is to be read from
// @param numItems - integer variable that keeps track of the number of items in inventory
// @return function returns boolean values to true or false
bool readInventory(string filename, int &numItems)
{
    ifstream input(filename);
    if(!input)
        return false;
    else
    {
        ptr = new Product[SIZE];
        while(!input.eof())
        {
            input >> (ptr+numItems)->pCode >> (ptr+numItems)->name >> (ptr+numItems)->salesType >> (ptr+numItems)->pricePer >> (ptr+numItems)->inventoryLvl;
            numItems++;
        }
    }
    input.close();
    return true;
}

// function checkout prompts user to input PLU codes and weight or number of units based on sales type
// @param numItems - integer variable that holds the number of items in inventory
// @param itemArray - integer pointer that keeps track of where the item is the inventory
// @param itemsBought - integer passed by reference that keeps track of the number of items bought by the user
// @param arrayUnitsWeight - double pointer that stores the unit or weight in relation to the item bought
// @return checkout returns a double value that represents the total amount of groceries bought
double checkout(int numItems, int *itemArray, int &itemsBought, double *arrayUnitsWeight)
{
    string pluCode;
    double units, weight;
    int i = 0, counter = 0;
    double amount;

    do
    {
        cout << "Please enter PLU code: ";
        cin >> pluCode;

        if(pluCode.compare("0") == 0)
            break;

        while(validPLU(pluCode, numItems, i) == false) // call function validPLU to validate PLU code input
                                                        // function validPLU is passed i by reference so if the PLU is valid, we can use the known location to retrieve the price per unit/weight
                                                        // instead of going through the list again to find the corresponding PLU
        {
            cout << "Invalid PLU code! \nPlease enter PLU code: ";
            cin >> pluCode;
        }

        itemArray[counter] = i;


        if(((ptr+i)->salesType) == 0)
        {
            cout << "Please enter number of units: ";
            cin >> units;

            while(validUnitWeight(units, i) == false)
            {
                cout << "Invalid amount of units! Not enough in stock. \nPlease enter number of units: ";
                cin >> units;
            }
            arrayUnitsWeight[counter] = units;
            amount += ((ptr+i)->pricePer) * units;
        }
        else if(((ptr+i)->salesType) == 1)
        {
            cout << "Please enter weight: ";
            cin >> weight;

            while(validUnitWeight(weight, i) == false)
            {
                cout << "Invalid amount of weight! Not enough in stock. \nPlease enter weight: ";
                cin >> weight;
            }
            arrayUnitsWeight[counter] = weight;
            amount += ((ptr+i)->pricePer) * weight;
        }

    counter++;
    }while(pluCode.compare("0") != 0);

    itemsBought = counter;
    adjustInventory(itemArray, arrayUnitsWeight, itemsBought);

    return amount;
}

// function updateInventory opens a file for output and outputs the contents of the inventory
// @param filename - holds the a string that is the name of the file to be output to
// @param numItems - integer variable that holds the number of items in inventory
// @return - updateInventory returns a boolean value of true or false depending on whether the file was able to be updated
bool updateInventory(string filename, int numItems)
{
    ofstream output(filename);
    if(!output)
        return false;
    else
    {
        for(int i = 0; i < numItems; i++)
            output << (ptr+i)->pCode << " " << (ptr+i)->name << " " << (ptr+i)->salesType << " " << (ptr+i)->pricePer << " " << (ptr+i)->inventoryLvl << "\n";
    }
    output.close();
    return true;
}

// function validPLU validates the PLU number input by the user
// @param pNum - holds a string that the user input for the PLU of an item
// @param numItems - integer variable that holds the number oitems in inventory
// @param found - integer variable passed by value that holds the index of the item within the array of pointers to Products
// @return function validPLU returns a boolean value of false if the PLU entered is invalid and true if the PLU is valid
bool validPLU(string pNum, int numItems, int &found)
{
    int digitStatus;
    char *cstr = new char[pNum.length() + 1];
    strcpy(cstr, pNum.c_str());
    digitStatus = checkDigit(cstr, pNum.length());

    if(digitStatus == 0) // digitStatus == 0 then PLU is not all digits
        return false;
    for(found = 0;found < numItems; found++) // Go through list of items
    {
        if((ptr+found)->pCode.compare(pNum) == 0) // check if PLU code entered is equal to any of PLU codes in inventory
            return true; // return true if PLU code is in our inventory
    }
    return false;
}

// function validUnitWeight validates if the unit or weight is less than the amount in inventory
// @param item is the number of units or weight input by the user for purchase
// @param invenNum is the number corresponding to the index of the item within the array of pointers to Product structures
// @return function validUnitWeight returns true if the number of units or weight is valid and false if it is invalid
bool validUnitWeight(double item, int invenNum)
{
    if(item > (ptr+invenNum)->inventoryLvl)
        return false;
    return true;
}

// function checkDigit checks if the PLU code is al ldigits or if the unit/weight does not have non digit values in it
// @param c is a char pointer to a c-string which checkDigit parses through to check for non-digit values
// @param length holds the length of the string
// @return returns 1 if input is valid and 0 if it is invalid
int checkDigit(char* c, int length)
{
    int periodStatus = 0;
    for(int i = 0; i < length; i++)
    {
        if(*(c + i) == '.')
        {
            if(periodStatus == 1)
                return 0;
            else
                periodStatus = 1;
        }

        if(!isdigit(*(c + i)) && *(c + i) != '.')
            return 0;
    }
    return 1;
}

// function displayCheckOut calls function checkout and outputs the names of the items and their prices along with
// the total price of the items before and after the 5% discount if it applies
// @param numItems - integer variable that holds the number of items in inventory
void displayCheckOut(int numItems)
{
    const char sep = ' ';
    int *iArr, timesInput;
    double *arrUnitWeight;
    arrUnitWeight = new double[numItems];
    iArr = new int[numItems]; // create array of strings equal to amount of items in inventory that stores valid PLU numbers input by user
    double totalAmount = checkout(numItems, iArr, timesInput, arrUnitWeight);

    cout << setfill(sep) << "\nItem name:" << setw(21) << "Price: " << endl;
    for(int i = 0; i < timesInput; i++)
        cout << setfill(sep) << left << setw(22) << (ptr+*(iArr+i))->name << right << setw(15) << fixed << setprecision(2) << ((ptr+*(iArr+i))->pricePer) * (*(arrUnitWeight+i)) << endl;
    cout << endl;
    if(totalAmount > 50)
    {
        cout << setfill(sep) << "Total Due:" << setw(27) << totalAmount << endl;
        cout << setfill(sep) << "Total Due with 5% discount:" << setw(10) << totalAmount * .95 << endl << endl;
    }
    else
        cout << setfill(sep) << "Total Due:" << setw(28) << totalAmount << endl << endl;
    cout << setprecision(0);
}

// function adjustInventory receives the number of items sold and adjusts the values in the array of pointers to struct Product accordingly
// @param invenNum - a integer pointer that holds the index of where the item is in the array of pointers
// @param invenSold - a double pointer that points to the unit/weight of the item bought
// @param itemsSold - a const integer thatn holds the number of items bought by a user
void adjustInventory(int *invenNum, double *invenSold, const int itemsSold)
{
    double temp;
    for(int i = 0; i < itemsSold; i++)
    {
        temp = (ptr+*(invenNum+i))->inventoryLvl;
        (ptr+*(invenNum+i))->inventoryLvl = temp - *(invenSold+i);
    }
}
