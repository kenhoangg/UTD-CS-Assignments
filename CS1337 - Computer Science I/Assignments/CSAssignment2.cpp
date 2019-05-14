/*  CS Assignment 2
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 2/1/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */

#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

// Function prototypes
void quadratic(double, double, double);
void tableXY(double, double, double);
void getValues(int);

int main()
{
    int option; // variable of type int that will store the selection entered by user
    while(true) // Infinite loop to prompt user until they exit program.
    {
        cout << "1. Quadratic Equation Calculator" << endl;
        cout << "2. Table of values" << endl;
        cout << "3. Enter any other number to exit." << endl;
        cout << "Please enter a menu option: ";
        cin >> option;
        if(option == 1 || option == 2)
            getValues(option);
        else
            break;
    }
}
/*  Function geValue of return type void
 *  has one parameter of type int that
 *  represent the menu option the user selected.
 *  The getValues function prompts the user to
 *  enter values for a, b, and c. Then depending on the
 *  value of parameter menu, it calls a function
 *  corresponding to the menu option selected.
 */
void getValues(int menu)
{
    double a, b, c;
    cout << "Please enter a value for a: ";
    cin >> a;
    cout << "Please enter a value for b: ";
    cin >> b;
    cout << "Please enter a value for c: ";
    cin >> c;

    if(menu == 1)
        quadratic(a,b,c);
    else
        tableXY(a,b,c);
}

/*  Function quadratic of return type void
 *  has three parameters of type double
 *  that represent the a, b, and c values in
 *  the quadratic equation. The function then
 *  uses those values to calculate the and display
 *  solution for the equation ax^2 + bx + c = 0.
 */
void quadratic(double a, double b, double c)
{
    double x1 = 0/* variable of type double that represents x1 */,
    /* variable of type double that represents x2 */x2 = 0, determinant /* variable of type double that represents the determinant or b^2-4ac */;
    determinant = (pow(b,2) - (4 * a * c));
    if(determinant >= 0)
    {
        x1 = ((b * -1) - sqrt(determinant)) / (2 * a);
        x2 = ((b * -1) + sqrt(determinant)) / (2 * a);

        cout << "x1 = " << x1 << endl;
        cout << "x2 = " << x2 << endl;
    }
    else
    {
        x1 = ((b * -1) / (2 * a)) - (sqrt((4 * a * c) - pow(b,2)) / (2 * a));
        x2 = ((b * -1) / (2 * a)) + (sqrt((4 * a * c) - pow(b,2)) / (2 * a));

        cout << "x1 = " << x1 << "i" << endl;
        cout << "x2 = " << x2 << "i" << endl;
    }
}

/*  Function tableXY of return type void has three parameters of type double that
 *  represent the a, b and c values in the quadratic equation. The function prompts
 *  user to enter numbers to form a range for a x-value. tableXY then uses parameters
 *  a, b and c to
 *
 */
void tableXY(double a, double b, double c)
{
    int xMin, xMax; // variables of type int that hold values corresponding to minimum x and maximum x respectively
    double x, y;
    while(true) // while loop to validate minimum x is smaller than maximum x
    {
        cout << "Please enter value for minimum x: "; // prompt user to enter value for minimum x
        cin >> xMin;                                  // read in value for xMin from user
        cout << "Please enter value for maximum x: "; // prompt user to enter value for maximum x
        cin >> xMax;                                  // read in value for xMax from user
        if(xMin > xMax)
            cout << "Error! Minimum x value greater than maximum x.\n";
        else
            break;
    }
    cout << setw(2) << "x" << setw(9) << "y\n";

    for(x = xMin; x <= xMax; x++)
    {
        y = ((a * pow(x,2)) + (b * x) + c);
        cout << setw(2) << x;
        cout << setw(8) << fixed << setprecision(2) << y << endl;
        cout << setprecision(0);
    }
}

