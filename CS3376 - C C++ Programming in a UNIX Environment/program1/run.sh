# Name: Kenny Hoang
# Email: kth140230@utdallas.edu
# Class: CS3376.002
#!/bin/bash

echo "Running 'hw1' with 0 arguments:"
./hw1 >> stdout.txt 2>> stderr.txt
echo "   stdout appended to stdout.txt"
echo "   stderr appended to stderr.txt"

echo "Running 'hw1' with 3 arguments:"
./hw1 abc ab bc >> stdout.txt 2>> stderr.txt
echo "   stdout appended to stdout.txt"
echo "   stderr appended to stderr.txt"

echo "Running 'hw1' with 5 arguments:"
./hw1 a b c d e >> stdout.txt 2>> stderr.txt
echo "   stdout appended to stdout.txt"
echo "   stderr appended to stderr.txt"
