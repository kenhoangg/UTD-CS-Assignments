// Project 5 - Mario Paint 64: Basenode Class Source File
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/10/2015

#include "Basenode.h"
using namespace std;

// Define Default Constructor
Basenode::Basenode()
{
    row = 0;
    col = 0;
    draw = 0;
}

// Define Constructor
Basenode::Basenode(int r, int c, char ch)
{
    row = r;
    col = c;
    draw = ch;
}
