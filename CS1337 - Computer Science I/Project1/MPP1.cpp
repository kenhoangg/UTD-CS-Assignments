// Project 1: Mario Paint
// Use advanced file I/O techniques to manipulate files directly.
// Program by: Kenny Hoang
// Class: CS1337.001
// Date: 9/16/2015

// include and define statements
#include <iostream>
#include <fstream>

using namespace std;

void drawVertical(fstream&, int, int, int, char);
void drawHoriz(fstream&, int , int, int, char);
void printDraw(fstream&);

int main()
{
    int penStatus = 0; // penStatus variable of type bool that holds the status of the pen(up or down)
    int boldStatus = 0; // boldStatus variable of type bool that holds the status of bold(bold or not bold)
    char direction; // direction variable of type char that holds the direction the pen is moving
    int numD; // numD variable of type int that holds the number of spaces the pen is moving
    char com; // char variable of type char that will hold the character read in from input file

    // open file stream for reading from "commands.txt"
    ifstream command("commands.txt", ios::in);
    // open and create "paint.txt" for output
    ofstream file("paint.txt", ios::out);
    file.close(); // close file


    fstream paint("paint.txt");

    // creating canvas for paint.txt (50x50)
    for(int i = 0; i < 50; i++)
        for(int j = 0; j < 50; j++)
        {
            paint.put(' ');
            if(j == 49)
                paint.put('\n');
        }
    paint.close();

    // reopening the file in binary mode to fix minGW bug
    paint.open("paint.txt", ios::binary | ios::app);
    // move file pointer to beginning of the file
    paint.seekp(0, ios::beg);

    // while we haven't reached end of command file read in character by character
    while(!command.eof())
    {
        // reading in character by character
        command.get(com);
        // if command received is 1; raise pen
        if(com == 1)
            penStatus = 0;
        // if command received is 2; lower pen
        else if(com == 2)
            penStatus = 1;
        // if command received is 3; draw
        else if(com == 3)
        {
            command.ignore();
            command.ignore();
            direction = command.get();
            command.ignore();
            command.ignore();
            numD = command.get();
            if(direction == 'N' || direction == 'S') // if direction is up or down call drawVertical
                drawVertical(paint, penStatus, boldStatus, numD, direction);
            else // if direction is not up or down call drawHoriz
                drawHoriz(paint, penStatus, boldStatus, numD, direction);
        }
        else if(com == 4) // if command is '4', display canvas to console
            printDraw(paint);
        else if(com == 'B') // if command is 'B', turn bold on
            boldStatus = 1;
        else if (com == 'b') // if command is 'b', turn bold off
            boldStatus = 0;
    }

    printDraw(paint); // after processing the commands.txt, print finished picture

    // close file streams
    command.close();
    paint.close();

    return 0;
}

// function drawVertical moves the pen up and down vertically
void drawVertical(fstream& draw, int pen, int bold, int numChar, char dir)
{
    char boldCheck = ' '; // variable of type char that checks whether value of character is bold or not
    if(pen == 0){
        for(int i = 0; i <= numChar; i++){
            if(dir == 'N')
                draw.seekp(-52L, ios::cur);
            else if(dir == 'S')
                draw.seekp(52L, ios::cur);
        }
    }
    if(pen == 1){
        for(int j = 0; j <= numChar; j++){
            if(dir == 'N')
                draw.seekp(-52L, ios::cur); // go up one line by line while drawing between moving
            else if(dir == 'S')
                draw.seekp(52L, ios::cur); // go down one line by line while drawing between moving
            if(bold == 1) // bold is on, draw '#'
            {
                draw << "#";
                draw.seekp(-1, ios::cur); // move back to old position before the drawing
            }
            else
            {
                boldCheck = draw.peek(); // check if space is occupied by a bold
                if(boldCheck != '#') // if not, draw '*'
                    draw << "*";

                draw.seekp(-1, ios::cur); // moves file pointer back to position before the draw
            }
        }
    }
}

// function drawHoriz moves the pen left and right horizontally
void drawHoriz(fstream& draw, int pen, int bold, int numChar, char dir)
{
    char boldCheck; // variable of type char that checks whether value of character is bold or not
    if(pen == 0){
        for(int i = 0; i < numChar; i++){
            if(dir == 'W')
                draw.seekp(-numChar, ios::cur); // move pen to left
            else if(dir == 'E')
                draw.seekp(numChar, ios::cur); // move pen to right
        }
    }
    if(pen == 1){
        if(dir == 'W') // if direction is left, move file pointer to left first; turning into draw right situation
            draw.seekp(-numChar, ios::cur);
        for(int j = 0; j <= numChar; j++){
            if(bold == 1) // bold is on; draw '#'
            {
                draw << "#";
            }
            else
            {
                boldCheck = draw.peek(); // check if space is occupied by a bold
                if(boldCheck != '#') // if not, draw '*'
                    draw << "*";
            }
        }
        if(dir == 'W') // if direction was left
            draw.seekp(-numChar, ios::cur); // move back to position as if we drew from right to left
    }
}

// function printDraw draws the canvas when called line by line then creates a buffer for seperation between the next call
void printDraw(fstream& draw)
{
    ifstream print;
    string s;
    print.open("paint.txt");
    while(!print.eof())
    {
        getline(print, s);
        cout << s << endl;
    }
    // print spaces for buffer between prints
    cout << endl << endl;
    print.close(); // close ifstream print
}
