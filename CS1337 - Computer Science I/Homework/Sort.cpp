#include <iostream>
using namespace std;

void bubbleSort(int arr[])
{
    int swap, i, k, compare, counter;
    do
    {
        swap = 0;
        i = 0;
        counter = 0;
        compare = arr[i];
        if(compare > arr[i+1])
        {
            arr[i] = arr[i+1];
            arr[i+1] = compare;
            swap = 1;
        }
        counter++;
        cout << "Array after " << counter << "passes of bubble sort." << endl;
        for(k = 0; k < 7; k++)
            cout << arr[k] << " ";


    }while(swap != 0);
}

void selectSort(int arr[])
{
    int i, j, k, smallest, hold;
    for(i = 0; i < 7; i++)
    {
        smallest = i;
        for(j = i+1; j < 8; j++)
        {
            if(arr[j] < arr[smallest])
            {
                smallest = j;
            }
        }
        hold = arr[smallest];
        arr[smallest] = arr[i];
        arr[i] = hold;

        cout << "Array after " << i+1 << "passes of bubble sort." << endl;
        for(k = 0; k < 7; k++)
            cout << arr[k] << " ";
    }
}

int main(void)
{
    int array1[8];
    int array2[8];

    int i;
    for(i = 0; i < 7; i++)
    {
        cout << "Please enter an integer to put into array: ";
        cin >> array1[i];
    }

    int j;
    for(j = 0; j < 7; i++)
        array2[j] = array1[j];

    for(i = 0; i < 7; i++)
        cout << array1[i] << " ";
    bubblesort(array1);
    for(j = 0; j < 7; j++)
        cout << array2[i] << " ";
    selectsort(array2);
}
