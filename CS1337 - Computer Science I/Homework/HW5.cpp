/*
 * Homework 5:EnQueue and DeQueue functions as a linked list
 * Program by: Kenny Hoang (kth140230)
 * CS1337.001
 * Professor Jason Smith
 * 10/27/2015
 */

#include <iostream>

using namespace std;

struct node
{
    int integer;
    node* next;
};

void EnQueue(node* &);
void DeQueue(node* &);
void printList(node*);

int main()
{
    int select;
    node *head = nullptr;

     do
    {
        cout << "1. Add Node\n"
            << "2. Delete Node\n"
            << "3. Print List\n"
            << "4. Quit\n\n"
            << "Please pick an operation for the linked list: ";
        cin >> select;

        if (select == 1)
           EnQueue(head);
        else if (select == 2)
        {
            DeQueue(head);
        }
        else if (select == 3)
            printList(head);

    } while (select != 4);
}

void EnQueue(node* &h)
{
    node* n = new node;
    cout << "Please enter a number to add to queue: ";
    cin >> n->integer;
    n->next = nullptr;

    if(!h)
        h = n;
    else
    {
        node* p = h;
        while(p->next)
            p = p->next;
        n->next = p->next;
        p->next = n;
    }
}

void DeQueue(node* &h)
{
    if(!h)
        cout << "List is empty.\n";
    else
    {
        node* temp = h;
        h = h->next;
        delete temp;
    }
}


void printList(node* ptr)
{
    cout << endl;
    while (ptr)
    {
        cout << ptr->integer <<" ";
        ptr = ptr->next;
    }
    cout << endl << endl;
}
