#define NoOfSamples 50

void printOnConsole(double soc, double temp);
void readParametersFromFile(double temp[], double soc[]);
void readAndPrintParamets(double temp[], double soc[], void (*fn_ptrPrintOutput)(double temp, double soc));
