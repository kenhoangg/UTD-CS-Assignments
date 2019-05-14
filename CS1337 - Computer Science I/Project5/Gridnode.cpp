// Project 5 - Mario Paint 64: Gridnode Class Source File
// Written by: Kenny Hoang
// CS1337.001
// Professor Jason Smith
// 12/10/2015

#include "Gridnode.h"
#include <iostream>
using namespace std;

// Define Default Constructor
Gridnode::Gridnode()
{
    up = down = left = right = NULL;
}
// Define Overloaded Constructor
Gridnode::Gridnode(const Gridnode &obj)
{
    up = down = left = right = NULL;
}
