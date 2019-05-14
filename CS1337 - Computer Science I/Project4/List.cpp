// Project 4 - Wario World Economics
// Written by: Kenny Hoang (kth140230)
// CS1337.001
// Professor Smith
// 11/18/2015

#include "List.h"

using namespace std;

LinkedList::LinkedList()
{
    /* Initialize head and next pointers */
    head = next = nullptr;
}

LinkedList::LinkedList(int coef, int exp, char c[])
{
    head = new Node(coef, exp, c);
    next = head;
}

LinkedList::~LinkedList()
{

}
