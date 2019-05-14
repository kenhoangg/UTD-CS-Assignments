// Project 5 - Mario Paint 64: Grid Class Source File
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/10/2015

#include "Grid.h"
#include "Basenode.h"
#include "Gridnode.h"
#include <iostream>
using namespace std;

Grid::Grid()
{
    Gridnode *r1, *r2, *p;

    //create first node on row 1
    r1 = new Gridnode;
    r1->row = 1;
    r1->col = 1;
    head = r1;

    //create rest of row 1
    for (int i = 2; i <= 50; i++ )
    {
        r2 = new Gridnode;

        //link left and right pointers
        r2->left = r1;
        r1->right = r2;

        //initialize row and column
        r2->row = 1;
        r2->col = i;

        //move r1 forward
        r1 = r2;
    }

    //reset r1 to beginning of row
    r1 = head;

    //create remaining rows
    for (int i = 2; i <= 50; i++)
    {
        r2 = new Gridnode;

        //link up and down
        r2->up = r1;
        r1->down = r2;

        //initialize row and column
        r2->row = i;
        r2->col = 1;

        //move r1 down to hold beginning of row
        r1 = r2;

        //create rest of row
        for (int j = 2; j <= 50; j++)
        {
            p = new Gridnode;

            //initialize row and column
            p->row = i;
            p->col = j;

            //link to node on the left
            p->left = r2;
            r2->right = p;

            //link to node above
            p->up = r2->up->right;
            p->up->down = p;

            //move r2 forward
            r2 = p;
        }
    }
}

Grid::Grid(const Gridnode &obj)
{
    head = obj;
}

ostream& operator << (ostream& str, const Gridnode &obj)
{
    ofstream out("paint.txt");
}

