package streamline.receiver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Dictionary processInput(String inputLine){
        String tempData = inputLine.split(",")[0];
        String ampData = inputLine.split(",")[1];

        float tempValue = Float.parseFloat(tempData.split(": ")[1]);
        float ampValue = Float.parseFloat(ampData.split(": ")[1]);

        Dictionary tempAndAmp = new Hashtable();
        tempAndAmp.put(tempValue, ampValue);

        return tempAndAmp;
    }

    public static String outputInfo(Dictionary maxValue, Dictionary minValue, Dictionary sma50){

        float tempMax = (float) maxValue.keys().nextElement();
        float tempMin = (float) minValue.keys().nextElement();


        float ampMax = (float) maxValue.get(tempMax);
        float ampMin = (float) minValue.get(tempMin);

        float sma50Temp = (float) sma50.keys().nextElement();
        float sma50Amp = (float) sma50.get(sma50Temp);

        String output = "Max Temp: "+tempMax + "\nMin Temp: "+tempMin + "\nMax Amp: "+ampMax + "\nMin Amp: "+ampMin
                        + "\nsma50 Temp: "+sma50Temp + "\nsma50 Amp: "+sma50Amp + "\n\n";

        System.out.print(output);

        return output;
    }


    public static void readStreamInput(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            while (true) {
                if ((line = reader.readLine()) != null) {

                    Dictionary tempAndAmpValues = processInput(line);
                    CalculationUtil.initializeMax(tempAndAmpValues);
                    Dictionary maxValues = CalculationUtil.getNewMax(tempAndAmpValues);
                    Dictionary minValues = CalculationUtil.getNewMin(tempAndAmpValues);
                    Dictionary sma50 = CalculationUtil.getSma50(tempAndAmpValues);

                    outputInfo(maxValues, minValues, sma50);

                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main( String[] args )
    {
        readStreamInput();
    }
}
