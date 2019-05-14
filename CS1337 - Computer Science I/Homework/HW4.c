// Homework 4: Write a function that performs a descending bubble sort of
// an array of 10 characters
// Written by: Kenny Hoang
// Date; 10/4/2015

#include <stdio.h>
#include <stdlib.h>

void bubbleSort(char *arr)
{
    int change;
    char compare, next, hold;
    do
    {
        change = 0;
        for(int i = 0; i < 10; i++)
        {
            compare = *(arr+i);
            next = *(arr+(i+1));
            if(compare < next)
            {
                hold = compare;
                compare = next;
                next = hold;
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
    char* ptr = (char*)malloc(sizeof(char)*10);
    int i = 0;
    printf("%s", "Enter characters to fill array: " );
    while(i < 10)
    {
        scanf("%d", *(ptr + i));
        i++;
    }
    for(int j = 0; j < 10; j++)
    {
        printf("%s", *(ptr + j));
        printf("%s", " ");
    }
    printf("/n");

    bubbleSort(ptr);

for(int j = 0; j < 10; j++)
    {
        printf("%s", *(ptr + j));
        printf("%s", " ");
    }
    printf("/n");
}

