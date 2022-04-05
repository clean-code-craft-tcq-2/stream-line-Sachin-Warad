#include <stdio.h>
#include <stdlib.h>
#include "SendBatteryParameters.h"

void printOnConsole(double temp, double soc) {
        printf("%.0f\t%0.f\n",soc,temp);
}

int readParametersFromFile(double temp[], double soc[], char *fileName)
{
  FILE *fp;
  fp = fopen(fileName, "r");
  if(fp != NULL)
  {
    float tempFromFile, socFromFile;
    for(int i=0;fscanf(fp, "%f\t%f\n", &tempFromFile,&socFromFile)!=EOF ;i++)
    {
        temp[i] = tempFromFile;
        soc[i] = socFromFile;
    }
    fclose(fp);
    return STATUS_OK;
  }
  fclose(fp);
  return STATUS_NotOK;
}

int readAndPrintParamets(double temp[], double soc[], void (*fn_ptrPrintOutput)(double temp, double soc), char *fileName) 
{
  int status = readParametersFromFile(temp,soc,fileName);
  for(int i=0; i<NoOfSamples; i++) {
      fn_ptrPrintOutput(soc[i],temp[i]);
  }
  return status;
}
