#include <stdio.h>
#include <stdlib.h>
#include "SendBatteryParameters.h"

void printOnConsole(double soc, double temp) {
        printf("%lf\t%lf\n",soc,temp);
}

int readParametersFromFile(double temp[], double soc[])
{
  FILE *fp;
  fp = fopen("BatteryParameters.txt", "r");
  if(fp != NULL)
  {
    float tempFromFile, socFromFile;
    for(int i=0;fscanf(file, "%f\t%f\n", &tempFromFile,&socFromFile)!=EOF ;i++)
    {
        temp[i] = tempFromFile;
        soc[i] = socFromFile;
    }
    fclose(fp); 
    return 1;
  }
  fclose(fp);
  return 0;
}

int readAndPrintParamets(double temp[], double soc[]) 
{
  //int socp = 4, tempp=5;
  int  status = readParametersFromFile(temp,soc);
  printOnConsole(soc[1],temp[1]);
  return status;
}
