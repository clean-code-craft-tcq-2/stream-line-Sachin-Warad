#include <stdio.h>
#include <stdlib.h>
#include "SendBatteryParameters.h"

void printOnConsole(double temp, double soc) {
        printf("%.0f\t%0.f\n",soc,temp);
}

void readParametersFromFile(double temp[], double soc[])
{
  FILE *fp;
  fp = fopen("BatteryParameters.txt", "r");
  if(fp != NULL)
  {
    float tempFromFile, socFromFile;
    for(int i=0;fscanf(fp, "%f\t%f\n", &tempFromFile,&socFromFile)!=EOF ;i++)
    {
        temp[i] = tempFromFile;
        soc[i] = socFromFile;
    }
    fclose(fp); 
  }
}

void readAndPrintParamets(double temp[], double soc[], void (*fn_ptrPrintOutput)(double temp, double soc)) 
{
  readParametersFromFile(temp,soc);
  for(int i=0; i<NoOfSamples; i++) {
      fn_ptrPrintOutput(soc[i],temp[i]);
  }
}
