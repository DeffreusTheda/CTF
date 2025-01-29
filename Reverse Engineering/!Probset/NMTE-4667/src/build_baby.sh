#!/bin/zsh
g++ -std=c++11 -c baby.cpp -o baby.o; g++ -std=c++11 -lcurl baby.o params.o -o e2ctr; ./e2ctr               
