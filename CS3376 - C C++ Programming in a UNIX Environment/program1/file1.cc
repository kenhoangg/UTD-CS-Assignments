// Name: Kenny Hoang
// Email: kth140230@utdallas.edu
// CS3376.002
#include <iostream>
using namespace std;

// Function prototype
void procedure1();

int main(int argc, char *argv[]){
  cout << "argc was: " << argc << "\n" ;
  int count = 0;
  while (count < argc){
    cout << argv[count] << "\n";
    count++;
  }
  procedure1();
  cout << "Done!" << "\n";
}
