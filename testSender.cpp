#define CATCH_CONFIG_MAIN  // This tells Catch to provide a main() - only do this in one cpp file

#include "test/catch.hpp"
#include "SendBatteryParameters.h"

TEST_CASE("Verify Read parameters from file - Valid Case") {
  double temp[NoOfSamples], soc[NoOfSamples];
  void (*fn_ptrPrintOutput)(double, double);
  fn_ptrPrintOutput = &printOnConsole;
  char fileName[50] = "BatteryParameters.txt";
  int readStatus = readAndPrintParamets(temp,soc,fn_ptrPrintOutput,fileName);
  REQUIRE(readStatus == STATUS_OK);
}

TEST_CASE("Verify Read parameters from file - InValid Case") {
  double temp[NoOfSamples], soc[NoOfSamples];
  void (*fn_ptrPrintOutput)(double, double);
  fn_ptrPrintOutput = &printOnConsole;
  char fileName[50] = "BatteryParameters2.txt";
  int readStatus = readAndPrintParamets(temp,soc,fn_ptrPrintOutput,fileName);
  REQUIRE(readStatus == STATUS_NotOK);
}
