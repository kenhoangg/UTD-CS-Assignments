// Project 4 - Wario World Economics
// Written by: Kenny Hoang (kth140230)
// CS1337.001
// Professor Smith
// 11/18/2015

#ifndef NODE_H
#define NODE_H
#include <cstring>

using namespace std;

class Node
{
    friend class LinkedList;
private:
    int coefficient;
    int exp;
    char* trig;
    Node* ptr;
public:
    Node();
    Node(int, int, char[]); // Constructor with values passed
    ~Node();

    //Get Functions
    int getCoefficient()
    {   return coefficient; }

    int getExponent()
    {   return exp;}

    char* getTrig()
    {   return trig;    }

    Node* getNext()
    {   return ptr; }

    //Set Functions
    void setCoefficient(int coef)
    {
        coefficient = coef;
    }

    void setExponent(int exponent)
    {
        exp = exponent;
    }

    void setTrig(char t[])
    {
        strcpy(trig, t);
    }
};
#endif
