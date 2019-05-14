/*  CS Assignment 4
 *  Program by: Kenny Hoang (kth140230)
 *  Date: 2/15/2016
 *  Class: CS1337.009
 *  Professor John Cole
 */


#include <iostream>
#include <iomanip>
using namespace std;

// Function Prototypes
void fillSquare(int);
void printSquare(int**, int);
int outOfSquare(int, int);

int main()
{
    int num;

    do
    {
        cout << "Please enter a odd number greater than or equal to 3: "; // Prompt user to enter number for magic square.
        cin >> num;

        if(num >= 3 && num % 2 == 1) // checking if number entered is odd and greater than or equal to 3
            fillSquare(num);
        else if(num % 2 == 0 && num != 0)
            //  Error message if user inputs a even number.
            cout << "Error! Enter a odd number or zero to exit." << endl;
    }while(num != 0); // while num not equal to zero (zero is exit condition)
    return 0;
}

// Function fillSquare with return type void receives a int variable as
// a parameter and fills a dynamic array with values to simulate a magic square
void fillSquare(int n)
{
    int row, col, nums = n*n, sizeSquare = n - 1;

    int **arr = new int*[n]; // creat pointer to array of n rows
    for(int i = 0; i < n; i++) // for loop to point each row to a column or array size n
        arr[i] = new int[n]; // dynamically create columns

    for(int j = 0; j < n; j++)
        for(int k = 0; k < n; k++)
            arr[j][k] = 0;

    row = 0;
    col = n / 2;
    int nextRow, nextCol; //
    for(int value = 1; value <= nums; value++)
    {
        arr[row][col] = value; // set cell to value to next number
        // Find the next open cell
        //nextRow = (row - 1) % n; // move up one row
        //nextCol = (col + 1) % n; // move to the right one column
        nextRow = row - 1;
        nextCol = col + 1;
        if(outOfSquare(sizeSquare, nextRow) == 1) // check if up movement is out of bounds
            nextRow = sizeSquare; // set next row to last row
        if(outOfSquare(sizeSquare, nextCol) == 1) // check if right movement is out of bounds
            nextCol = 0; // set next column to first column

        if(arr[nextRow][nextCol] == 0) // if cell is empty (0)
        {
            row = nextRow; // remember row of next empty cell
            col = nextCol; // remmember colomn of next empty cell
        }
        else
        {
          // Square is full, move vertically down one.
            //row = (row + 1 - n) % n;
            row = row + 1;
        }
    }
    printSquare(arr, n);
    // Delete dynamic array to free up memory space
    for(int l = 0; l < 4; ++l)
    {
        delete[] arr[l];
    }
    delete[] arr;
}

// Function printSquare wiht return type void recieves a multidimentional array and int
// variable as parameters and prints the contents of the array to console.
void printSquare(int** ary, int n)
{
    int counter = 0;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
        {
            counter++;
            if(counter == n)
            {
                cout << setw(4) << ary[i][j] << endl << endl;
                counter = 0;
            }
            else
                cout << setw(4) << ary[i][j] << " ";
        }
}

//  function outOfSquare checks bounds given the index or the next row of column in
//  the alogorithm of a magic square. Returns int value of 1 or 0
int outOfSquare(int width, int nextRC)
{
    if(nextRC > width) // if next column is outside of width of square
        return 1;
    else if(nextRC < 0) // if next row is out of square
        return 1;
    else
        return 0;
}
