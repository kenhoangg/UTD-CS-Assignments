// Project 4 - Wario World Economics
// Written by: Kenny Hoang (kth140230)
// CS1337.001
// Professor Smith
// 11/18/2015

#include "Node.h"
#include <cstring>

using namespace std;

Node::Node()
{
    coefficient = 1;
    exp = 1;
    trig = new char[10];
    strcpy(trig, "\0");
}

Node::Node(int coeff, int exponent, char s[])
{
    coefficient = coeff;
    exp = exponent;
    trig = new char[10];
    strcpy(trig, s);
}

Node::~Node()
{
    delete [] trig;
}

