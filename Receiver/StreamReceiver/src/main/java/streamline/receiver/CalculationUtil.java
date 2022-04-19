package streamline.receiver;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class CalculationUtil {

    public static boolean isFirstInput = true;

    public static float tempMax = 0;
    public static float ampMax = 0;
    public static float tempMin = 0;
    public static float ampMin = 0;

    public static ArrayList<Float> last5Values_Temp = new ArrayList<>();
    public static ArrayList<Float> last5Values_Amp = new ArrayList<>();
    public static float sma50 = 0;

    public static Dictionary getNewMax(Dictionary tempAndAmp){
        float tempValue = (float) tempAndAmp.keys().nextElement();
        float ampValue = (float) tempAndAmp.get(tempValue);

        updateMax(tempValue, ampValue);

        Dictionary maxTempAndAmp = new Hashtable();
        maxTempAndAmp.put(tempMax, ampMax);
        return maxTempAndAmp;
    }

    public static Dictionary getNewMin(Dictionary tempAndAmp){
        float tempValue = (float) tempAndAmp.keys().nextElement();
        float ampValue = (float) tempAndAmp.get(tempValue);

        updateMin(tempValue, ampValue);

        Dictionary minTempAndAmp = new Hashtable();
        minTempAndAmp.put(tempMin, ampMin);
        return minTempAndAmp;
    }

    public static void updateMax(float tempValue, float ampValue){

        if(tempValue > tempMax){
            tempMax = tempValue;
        }

        if(ampValue > ampMax){
            ampMax = ampValue;
        }

    }

    public static void updateMin(float tempValue, float ampValue){
        if(tempValue < tempMin){
            tempMin = tempValue;
        }

        if(ampValue < ampMin){
            ampMin = ampValue;
        }
    }

    public static Dictionary getSma50(Dictionary tempAndAmp){
         Dictionary sma50TempAndAmp = new Hashtable();
        float sma50Temp = 0;
        float sma50Amp = 0;
         updateLast5Values(tempAndAmp);

         if(last5Values_Temp.size()>=5){
             sma50Temp = (last5Values_Temp.get(0)+last5Values_Temp.get(1)+last5Values_Temp.get(2)+last5Values_Temp.get(3)+last5Values_Temp.get(4) ) / 5;
         }
         if(last5Values_Amp.size() >= 5){
             sma50Amp = ( last5Values_Amp.get(0)+last5Values_Amp.get(1)+last5Values_Amp.get(2)+last5Values_Amp.get(3)+last5Values_Amp.get(4)  ) / 5 ;
         }

         sma50TempAndAmp.put(sma50Temp, sma50Amp);
         return sma50TempAndAmp;
    }

    public static void updateLast5Values(Dictionary tempAndAmp){
        float tempValue = (float) tempAndAmp.keys().nextElement();
        float ampValue = (float) tempAndAmp.get(tempValue);

        if(last5Values_Temp.size() == 5)
            last5Values_Temp.remove(0);

        if(last5Values_Amp.size() == 5)
            last5Values_Amp.remove(0);

        last5Values_Temp.add(tempValue);
        last5Values_Amp.add(ampValue);
    }

    public static void initializeMax(Dictionary tempAndAmp){
        if(isFirstInput){
            float tempValue = (float) tempAndAmp.keys().nextElement();
            float ampValue = (float) tempAndAmp.get(tempValue);

            tempMax = tempValue;
            tempMin = tempValue;

            ampMax = ampValue;
            ampMin = ampValue;

            isFirstInput = false;

        }
    }

}
