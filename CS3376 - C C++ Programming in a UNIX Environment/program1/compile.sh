# Name: Kenny Hoang
# Email: kth140230@utdallas.edu
# Class: CS3376.002
#!/bin/bash

echo "Setting TEMPDIR environment variable to /scratch"
TEMPDIR=/scratch; export TMPDIR
echo "Compiling file1.cc"
g++ -c file1.cc
echo "Compiling file2.cc"
g++ -c file2.cc
echo "Linking files file1.cc and file2.cc to create executable hw1"
g++ file1.o file2.o -o hw1
echo "Done"

