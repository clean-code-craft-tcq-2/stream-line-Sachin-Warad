#define NoOfSamples 50
#define STATUS_OK 1
#define STATUS_NotOK 0

void printOnConsole(double soc, double temp);
int readParametersFromFile(double temp[], double soc[], char *fileName);
int readAndPrintParamets(double temp[], double soc[], void (*fn_ptrPrintOutput)(double temp, double soc), char *fileName);
