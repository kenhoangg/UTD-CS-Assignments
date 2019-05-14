// Homework 4: Write a function that performs a descending bubble sort of
// an array of 10 characters
// Written by: Kenny Hoang
// Date; 10/4/2015

#include <iostream>
using namespace std;

void bubbleSort(char *arr)
{
    int change;
    char compare, next;
    do
    {
        change = 0;
        for(int i = 0; i < 10; i++)
        {
            compare = *(arr+i);
            next = *(arr+(i+1));
            if(compare < next)
            {
                swap(compare, next);
                *(arr+i) = compare;
                *(arr+(i+1)) = next;
                change = 1;
            }
        }

    }while(change != 0);

}

int main(void)
{
    int size;
    size = 10;
    char* ptr = new char[size];
    int i = 0;
    cout << "Enter characters to fill array: " << endl;
    while(i < 10)
    {
        cin >> *(ptr + i);
        i++;
    }
    for(int j = 0; j < 10; j++)
    {
        cout << *(ptr + j) << " ";
    }
    cout << endl;

    bubbleSort(ptr);

    for(int j = 0; j < 10; j++)
    {
        cout << *(ptr + j) << " ";
    }
    cout << endl;

    delete [] ptr;
}
