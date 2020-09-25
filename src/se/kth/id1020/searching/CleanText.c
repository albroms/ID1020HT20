/*
* How to use:
* 1. In the Unix terminal, go to the directory where the file is.
* 2. Compile it with the gcc compiler.
* 3. Use command ./[fileToRun] < TheTextUnfiltered.txt > [DesiredFileName].txt to generate a text file with the output.
*/

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(){
  char c = getchar();
  while(c != EOF){
    if(isalpha(c) || c == ' ' || c == '\n'){
      putchar(c);
      c = getchar();
    }
    else{
      putchar(' ');
      c = getchar();
    }
  }
  return 0;
}