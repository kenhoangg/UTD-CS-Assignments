// Project 5 - Mario Paint 64: Basenode Header File
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/10/2015

#ifndef BASENODE_H
#define BASENODE_H
using namespace std;

class Basenode
{
protected:
    int row; // Integer variable to track row
    int col; // Integer variable to track column
    char draw; // char variable for drawing
public:
    // Default Constructor
    Basenode();
    // Constructor
    Basenode(int, int, char);

    // Mutator functions
    void setRow(int r)
    {   row = r;    }

    void setCol(int c)
    {   col = c;    }

    void setDraw(char ch)
    {   draw = ch;  }

    // Accessor functions
    int getRow() const
    {   return row; }

    int getCol() const
    {   return col; }

    virtual char getDraw() = 0;
};
#endif
