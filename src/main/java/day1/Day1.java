package day1;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class to read text files


public class Day1 {
    public int getTotal() {
        int totalValue = 0;
        Map<String, Character> digitsAsStrings = new HashMap<String, Character>(9);
        digitsAsStrings.put("one", '1');
        digitsAsStrings.put("two", '2');
        digitsAsStrings.put("three", '3');
        digitsAsStrings.put("four", '4');
        digitsAsStrings.put("five", '5');
        digitsAsStrings.put("six", '6');
        digitsAsStrings.put("seven", '7');
        digitsAsStrings.put("eight", '8');
        digitsAsStrings.put("nine", '9');

        try {
            File calibrationValues = new File("src/main/java/day1/calibration_values.txt");
            Scanner myScanner = new Scanner(calibrationValues);
            while (myScanner.hasNextLine()) {
                String calibrationValue = myScanner.nextLine();
                System.out.println(calibrationValue);
                //int value = Integer.parseInt((getFirstInt(calibrationValue, digitsAsStrings) + String.valueOf(getLastInt(calibrationValue))));
                System.out.println("value " + getLastInt(calibrationValue, digitsAsStrings));
                totalValue += 0;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return totalValue;
    }

    public char getFirstInt(String calibrationValue, Map<String, Character> digitsAsStrings) {
        char firstValue = '0';
        for(int i = 0; i < calibrationValue.length(); i++) {
            boolean flag = Character.isDigit(calibrationValue.charAt(i));
            if(flag) {
                firstValue = calibrationValue.charAt(i);
                //System.out.println("'"+ firstValue + "' is a number");
                break;
            } else {
                System.out.println("'" + calibrationValue.charAt(i) + "' is a letter");
                for (String j : digitsAsStrings.keySet()) {
                    //System.out.println("key: " + j + " value: " + digitsAsStrings.get(j));
                   if (calibrationValue.charAt(i) == j.charAt(0)) {
                       System.out.println("Both begin with same letter : " + j);
                       for (int k = 0; k < calibrationValue.length()-1; k++) {
                           if (calibrationValue.charAt(i + k) == j.charAt(k)) {
                               System.out.println("next letter  : " + j.charAt(k));
                               System.out.println("next letter is the same : " + calibrationValue.charAt(i + k));
                               System.out.println("j " + j);
                               String substring = calibrationValue.substring(i, j.length());
                               System.out.println("calibrationValue.substring(i, j.length()-1).equals(j) " + substring.equals(j));
                               if (substring.equals(j)) {
                                   return digitsAsStrings.get(j);
                               }
                           }
                       }
                    }
                }

            }
        }
        return firstValue;
    }

    public char getLastInt(String calibrationValue, Map<String, Character> digitsAsStrings) {
        char lastValue = '0';
        for(int i = calibrationValue.length()-1; i >= 0; i--) {
            boolean flag = Character.isDigit(calibrationValue.charAt(i));
            if(flag) {
                lastValue =  calibrationValue.charAt(i);
                System.out.println("'" + lastValue + "' is a number");
                break;
            } else {
                System.out.println("'" + calibrationValue.charAt(i) + "' is a letter");
                String possibleNumber = "";
                for (int j = calibrationValue.length()-1; j >= 0; j--) {

                    possibleNumber = possibleNumber.concat(String.valueOf(calibrationValue.charAt(j)));
                    System.out.println(possibleNumber);
                }
                /*for (String j : digitsAsStrings.keySet()) {
                    //System.out.println("key: " + j + " value: " + digitsAsStrings.get(j));
                    int iterator = 0;
                    if (calibrationValue.charAt(calibrationValue.length()-1) == j.charAt(j.length()-1)) {
                        System.out.println("Both begin with same letter : " + j);
                        for (int k = calibrationValue.length()-1; k >= 0; k--) {
                            iterator += 1;
                            System.out.println("next letter is the same : " + calibrationValue.charAt(k - i));
                            System.out.println("calibrationValue.charAt(k) : " + calibrationValue.charAt(k));
                            System.out.println("j.charAt(k) : " + j.charAt(j.length()-iterator));
                            if (calibrationValue.charAt(k) == j.charAt(j.length()-iterator)) {
                                System.out.println("next letter  : " + j.charAt(k));
                                System.out.println("next letter is the same : " + calibrationValue.charAt(k - i));
                                System.out.println("j " + j);
                                String substring = calibrationValue.substring(j.length(), i);
                                System.out.println("calibrationValue.substring(i, j.length()-1).equals(j) " + substring.equals(j));
                                if (substring.equals(j)) {
                                    return digitsAsStrings.get(j);
                                }
                            }
                        }
                    }
                }*/
            }
        }
        return lastValue;
    }
}

