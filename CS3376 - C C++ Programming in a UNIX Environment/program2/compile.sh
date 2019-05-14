#!/bin/bash

# Setting TMPDIR to scratch
TMPDIR=/scratch; export TMPDIR;
g++ -I ~/CS3376/include program2.cc -o program2
