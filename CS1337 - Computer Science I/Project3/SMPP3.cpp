/* Project 3: Super Mario Paint
 * Program by: Kenny Hoang
 * Professor Jason Smith
 * CS1337.002
 * Date: 10/28/2015
 */

#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

struct commands
{
    int num; // variable num of type int holds the identifier
    int com; // variable com of type int holds the command
    char dir; // variable dir of type char holds the direction
    int num_chars; // variable num_chars holds the number of characters to be moved
    char b; // variable b of type char holds the bold status command
    commands* next; //commands node that points to the next node
};

//function prototypes
void drawUpDown(char[], int, int, char, char, commands* &, int &);
void drawLeftRight(char[], int, int, char, char, commands* &, int &);
void printfile(char[]);
void printPicture(char[]);
void orderCommands(commands* &);
void deleteCommand(commands* &, int);
void reOrderCommands(commands*);

int main()
{
    commands *head = nullptr;
    orderCommands(head);
    int lastLocation = 0;
    char canvas[2550];
    int counter = 0;

    for(int i = 0; i < 50; i++)
    {
        while(counter != 50)
        {
            canvas[counter] = ' ';
            counter++;
        }
        canvas[counter] = '\n';
        counter = 0;
    }


    while(head->next)
    {
        if(head->com == 3)
        {
            if(head->dir == 'N' || head->dir == 'S') // if direction is up/down
                drawUpDown(canvas, head->com, head->num_chars, head->dir, head->b, head, lastLocation); // call drawUpDown function
            else // direction is remaining case (left/right)
                drawLeftRight(canvas, head->com, head->num_chars, head->dir, head->b, head, lastLocation); // call drawLeftRight function
        }
        else if(head->com == 4)
            printPicture(canvas);
    }
    printPicture(canvas);
    printfile(canvas);
}

void drawUpDown(char c[], int command, int numChars, char direction, char bold, commands* &h, int commandNum, int &location)
{
    int penStatus = 0;
    int boldStatus = 0;
    char* ptr = c;
    ptr = ptr + location; // move pointer to last location on canvas
    int pos = (int) ptr; // set position to ptr position before moving

    if(command == 2)
        penStatus = 1;
    if(bold == 'B')
        boldStatus = 1;

    if(penStatus == 0)
        for(int i = 0; i < numChars; i++)
        {
            if((pos < 50 && direction == 'N') || (pos > 2450 && direction == 'S'))
                deleteCommand(h, commandNum);
            else if(direction == 'N') // if direction is North
                ptr = ptr - 51; // move up(move left 51 elements)
            else // if direction is not North then it is South
                ptr = ptr + 51; // move down(move right 51 elements)
        }
    if(penStatus == 1)
        for(int j = 0; j < numChars; j++)
        {
            if(direction == 'N') // if direction is North
                ptr = ptr - 51; // move up(move left 51 elements)
            else // if direction is not North then it is South
                ptr = ptr + 51; // move down(move right 51 elements)
            if(boldStatus == 1)
                *ptr = '#';
            else if(*ptr != '#')
                *ptr = '*';
        }
    pos = (int) ptr; // set position to ptr position after moving
    location = pos; // set location to last position of pointer on canvas for next movement command

}
void drawLeftRight(char c[], int command, int numChars, char direction, char bold, commands* &h, int commandNum, int &location)
{
    int penStatus = 0;
    int boldStatus = 0;
    char* ptr = c;
    ptr = ptr + location; // move pointer to last position on canvas
    int pos = (int) ptr; // set position to ptr position before moving
    int border; // number that will represent the border of the current line on canvas

    if(command == 2)
        penStatus = 1;
    if(bold == 'B')
        boldStatus = 1;

    if(penStatus == 0)
    {
            if(direction == 'W') // if direction is left
                border = (pos / 50) * 51; // calculate left border of current line
            else // only other case is if direction is right
                border = 49 + ((pos / 50) * 51); // calculate right border of current line
            if(((border - pos) >= numChars) || ((border + pos) >= numChars)) // if space avail
            {
                if(direction == 'W')
                    ptr = ptr - numChars;
                else
                    ptr = ptr + numChars;
            }
            else
                deleteCommand(h, commandNum);
    }
    if(penStatus == 1)
    {
        if(direction == 'W') // if direction is left
            ptr = ptr - numChars; // move pointer to the left number of characters to be moved (turns left drawing into right drawing)
        for(int i = 0; i < numChars; i++, ptr++)
        {
            if(boldStatus == 1)
                *ptr = '#';
            else if(*ptr != '#')
                *ptr = '*';
        }
    }
    if(direction == 'W') //if direction is left
        ptr = ptr + numChars; // move pointer to correct location as if we drew towards the left
    pos = (int) ptr; // set position to ptr position after moving
    location = pos; // set location to last position of pointer on canvas for next movement command
}

void printfile(char c[])
{
    ofstream output("paint.txt");
    int i = 0;
    while((unsigned)i < (strlen(c)-1))  // while loop to traverse canvas array
        output << c[i]; // write to file contents of canvas
    output.close(); // close output file stream
}

void printPicture(char c[])
{
    int i = 0;
    while((unsigned)i < (strlen(c)-1)) // while loop to traverse canvas array
        cout << c[i]; // output array contents to console
    cout << endl << endl; // skip two spaces to create buffer between prints
}

void orderCommands(commands* &h)
{
    ifstream input("commands.txt");
    commands* n = new commands;
    while(!input.eof())
    {

    }

    input.close();
}

void deleteCommand(commands* &h, int commandNum)
{
    if (h->num == commandNum)
    {
        commands* hold = h;
        h = h->next;
        delete hold;
    }
    else
    {
        commands* p1 = h;
        while (p1->next)
        {
            if (p1->next->num == commandNum)
            {
                commands* hold = p1->next;
                p1->next = p1->next->next;
                delete hold;
                return;
            }
            p1 = p1->next;
        }
    }
}

void reOrderCommands(commands* h)
{
    ofstream output("commands.txt");
    if(!h->next)
        output << h->num << " " << h->com << ", " << h->dir << ", " << h->num_chars << '\n';
    else
    {
         output << h->num << " " << h->com << ", " << h->dir << ", " << h->num_chars << '\n';
         deleteCommand(h, h->num);
         reOrderCommands(h->next);
    }
}
