// Project 4 - Wario World Economics
// Written by: Kenny Hoang (kth140230)
// CS1337.001
// Professor Smith
// 11/18/2015

#include "Node.h"
#include "List.h"
#include <iostream>
#include <cctype>
#include <cstring>
#include <string>
#include <fstream>

using namespace std;

void deriveFunct(Node*);
void printDerivative(Node*);

int main()
{
    LinkedList* ptrList;
    Node* ptrNode;
    char line[30];
    string s;
    int numOp = 0;
    int numNode = 0;
    char* lptr;
    int counter = 0;
    ptrList = nullptr;
    ptrNode = nullptr;

    ifstream input("functions.txt");

    while(input)
    {
        getline(input, s);
        strcpy(line, s.c_str());

        if(numOp == 0)
        {
            lptr = line;
            int i = 0;
            while(*(lptr+i) != '\0')
                if(*(lptr+i) == '+' || *(lptr+i) == '-')
                    numOp++;
        }
        if(numOp < numNode)
        {
            while(counter > (numNode - numOp))
                ptrList->deleteList(ptrNode);
        }
        if(numOp > numNode)
        {
            counter = 0;
            while(counter < numOp - numNode)
                ptrList->addList(ptrNode);
        }
        deriveFunct(ptrNode);
    }
}

void deriveFunct(Node* n)
{
    LinkedList* h = nullptr;
    h->head = n;
    if(h->next)
        deriveFunct(h->next);
    int coeff = (h->next)->getCoefficient();
    int exponent = (h->head)->getExponent();
    exponent = exponent - 1;
    coeff *= exponent;
    (h->head)->setCoefficient(coeff);
    (h->head)->setExponent(exponent);

    if(strcmp((h->head)->getTrig(), "sin") == 0)
        (h->head)->setTrig("cos");


        printDerivative(n);
}

void printDerivative(Node* n)
{
    ofstream output("derive.txt", ios::app);
    LinkedList* h = nullptr;
    h->head = n;
    if(h->next)
        printDerivative(h->next);
    while(h->next)
    {
        if((h->head)->getExponent() == 1 && (h->head)->getTrig())
            output << (h->head)->getCoefficient() << "x" << " ";
    }
}
