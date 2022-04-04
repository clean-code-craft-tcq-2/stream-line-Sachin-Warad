#include <stdio.h>
#include <stdlib.h>
#include "SendBatteryParameters.h"

void printOnConsole(double soc, double temp) {
        printf("%lf\t%lf\n",soc,temp);
}

int countParametersNumber(FILE *fp) {
  char c;
  int count = 0;
  for (c = getc(fp); c != EOF; c = getc(fp))
  {
        if (c == '\n') {
            count = count + 1;
        }
  }
  return count;
}

int readParametersFromFile(void)
{
  FILE *fp;
  fp = fopen("BatteryParameters.txt", "r");
  if(fp != NULL)
  {
    int numberofParameters = countParametersNumber(fp);
    return 1;
  }
  return 0;
}

int readAndPrintParametsOnConsole(void) 
{
  double soc = 4, temp = 90;
  int status = readParametersFromFile();
  printOnConsole(soc,temp);
  return status;
}
