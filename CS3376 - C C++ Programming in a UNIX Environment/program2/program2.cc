// Name: Kenny Hoang
// Email: kth140230@utdallas.edu
// Course: CS3376.002

#include <iostream>
#include <map>
#include <fstream>
#include <cstdlib>
#include <cctype>
#include "tclap/CmdLine.h"

using namespace std;

void readWrite(ifstream, ofstream, std::map<int, string>, bool, bool);
void changeCase(const char*, bool, bool);

int main(int argc, char* argv[]){
  // Set up options keys for has map
  enum optionKeys {OUTFILE, INFILE, LOWER=0 , UPPER=1};

  map<int, string> fileMap;
  map<int, bool> optionMap;

  try{
    TCLAP::CmdLine cmd("CS3376 Program 2", ' ', "Version 1.0");

    TCLAP::ValueArg<std::string> outfileArg("o", "outfile","The name of the output file", false, "output.txt", "output filename");

    TCLAP::UnlabeledValueArg<std::string> infileArg("infile", "The Input file name.", true, "infile.txt", "input filename", false);

    TCLAP::SwitchArg upperSwitch("u", "upper", "Convert all text to uppercase.", cmd, false);

    TCLAP::SwitchArg lowerSwitch("l", "lower", "Convert all text to lowercase.", cmd, false);
    
    // Add the argument nameArg to the CmdLine object. The CmdLine object
    // uses this Arg to parse the command line.
    cmd.add(outfileArg);
    cmd.add(infileArg);
       
    // parse the argv array.
    cmd.parse(argc, argv);
    
    // Get the value parsed by each arg and store in the map
    fileMap[OUTFILE] = outfileArg.getValue();
    fileMap[INFILE] = infileArg.getValue();
    optionMap[LOWER] = lowerSwitch.getValue();
    optionMap[UPPER] = upperSwitch.getValue();

    ifstream input;
    input.open(optionMap[INFILE].c_str(), ios::in);
    ofstream output;
    if(optionMap[OUTFILE].compare("output.txt") != 0)
      output.open(optionMap[OUTFILE].c_str(), ios::out);
    else
      output.open("output.txt", ios::out);
    if(input.is_open()){
      readWrite(input, output, fileMap, optionMap[UPPER], optionMap[LOWER]);
    }
    else{
      cout << "Could not open input file. The file " << fileMap[INFILE] << " does not exist." <<  endl;
      exit(EXIT_FAILURE);
    }
      input.close();
      output.close();
  }
  catch (TCLAP::ArgException &e) // catch any exceptions
    { 
      std:cerr << "error: " << e.error() << " for arg " << e.argId() << std:: endl; 
    }

  cout << "Debugging recap of parsed command lines: \n";
  cout << "\tOutfile: " << optionMap[OUTFILE] << endl;
  cout << "\tInfile: " << optionMap[INFILE] << endl;
  cout << "\tUpper: " << optionMap[UPPER] << endl;
  cout << "\tLower: " << optionMap[LOWER] << endl;
  
  return 0;
}

  void readWrite(ifstream infile, ofstream outfile, std::map<int,string> &f_map, bool upper, bool lower ){
    string str;
    while(!infile.eof())
      {
	getline(infile, str);
	if(upper == true || lower == true)
	  changeCase(str, upper, lower);
	outfile << str << endl;
      }
}

  void changeCase(const char* str, bool upper, bool lower){
    int size;
    size = str.size();
    if(upper == true)
      for(int i = 0; i < size; i++){
	str[i] = toupper(str[i]);
      }
    else if(lower == true)
      for(int j = 0; j < size; j++){
	str[j] = tolower(str[j]);
      }
}
