// Project 5 - Mario Paint 64: Grid Header File
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/10/2015

#ifndef GRID_H
#define GRID_H
#include "Basenode.h"
#include "Gridnode.h"
#include <fstream>
using namespace std;

class Grid;

ostream& operator <<(ostream&, const Grid&);

class Grid
{
private:
    Gridnode* head; // Gridnode pointer representing head pointer
public:
    // Default Constructor
    Grid();
    // Overloaded Constructor
    Grid(const Gridnode&);

    // Mutator function
    void setHead(Gridnode* h)
    {   head = h;   }

    // Accessor function
    Gridnode* getHead()
    {   return head;    }

    friend ostream& operator <<(ostream&, const Grid&);
};

#endif // GRID_H
