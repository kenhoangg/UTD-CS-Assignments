// Project 5 - Mario Paint 64: Gridnoe Header File
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/10/2015

#ifndef GRIDNODE_H
#define GRIDNODE_H
#include "Basenode.h"
using namespace std;

class Gridnode : public Basenode
{
private:
    Gridnode* up; // Gridnode pointer representing up pointer
    Gridnode* down; // Gridnode pointer representing down pointer
    Gridnode* left; // Gridnode pointer representing left pointer or previous pointer
    Gridnode* right; // Gridnode pointer representing right pointer or next pointer
public:
    // Default Constructor
    Gridnode();
    // Overloaded Constructor
    Gridnode(const Gridnode&);

    // Mutator functions
    void setUp(Gridnode* u)
    {   up = u; }

    void setDown(Gridnode* d)
    {   down = d;   }

    void setLeft(Gridnode* l)
    {   left = l;   }

    void setRight(Gridnode* r)
    {   right = r;  }

    // Accessor functions
    Gridnode* getUp()
    {   return up;  }

    Gridnode* getDown()
    {   return down;    }

    Gridnode* getLeft()
    {   return left;    }

    Gridnode* getRight()
    {   return right;   }

    char getDraw()
    {   return draw;    }
};
#endif
