#include <stdio.h>

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
        printf("Array after %d passes of bubble sort", counter);

        for(k = 0; k < 7; k++)
            printf("%d ", arr[k]);


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

        printf("Array after %d passes of select sort", i+1);
        for(k = 0; k < 7; k++)
            printf("%d ", arr[k]);
    }
}

int main(void)
{
    int array1[8];
    int array2[8];

    int i;
    for(i = 0; i < 7; i++)
    {
        printf("%s", "Please enter an integer to put into array: ");
        scanf("%d", &array1[i]);
    }

    int j;
    for(j = 0; j < 7; i++)
        array2[j] = array1[j];

    for(i = 0; i < 7; i++)
        printf("%d ", array1[i]);
    bubblesort(array1);
    for(j = 0; j < 7; j++)
        printf("%d ", array2[j]);
    selectsort(array2);
}
