// Project 4 - Wario World Economics
// Written by: Kenny Hoang (kth140230)
// CS1337.001
// Professor Smith
// 11/18/2015

#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include "Node.h"

using namespace std;

class LinkedList
{
public:
    Node* head;
    Node* next;
    LinkedList();
    LinkedList(int, int, char[]);
    ~LinkedList();

    void addList(Node* h)
    {
        Node* n = new Node;
        if(!h)
            h = n;
        else
        {
            Node* p = h;
            while(p->ptr)
                p = p->ptr;
            n->ptr = p->ptr;
            p->ptr = n;
        }
    }
    void deleteList(Node* h)
    {
        Node* temp = h;
        while(temp->ptr)
            temp = temp->ptr;
        delete temp;
    }
};
#endif // LINKEDLIST_H
