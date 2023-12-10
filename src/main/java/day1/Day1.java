package day1;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class to read text files


public class Day1 {
    public int getTotal() {
        int totalValue = 0;
        try {
            File calibrationValues = new File("src/main/java/day1/calibration_values.txt");
            Scanner myScanner = new Scanner(calibrationValues);
            while (myScanner.hasNextLine()) {
                String calibrationValue = myScanner.nextLine();
                System.out.println(calibrationValue);
                totalValue += getFirstInt(calibrationValue);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return totalValue;
    }

    public int getFirstInt(String calibrationValue) {
        char firstValue = '0';
        char lastValue = '0';
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

        for(int i = 0; i < calibrationValue.length(); i++) {
            boolean flag = Character.isDigit(calibrationValue.charAt(i));
            if(flag) {
                if (firstValue == '0') {
                    firstValue = calibrationValue.charAt(i);
                    lastValue = calibrationValue.charAt(i);
                    System.out.println("firstValue '"+ firstValue + "' is a number");
                    System.out.println("lastValue "+ lastValue + "' is a number");

                }
                else {
                    lastValue = calibrationValue.charAt(i);
                    System.out.println("lastValue "+ lastValue + "' is a number");
                }
            } /*else {
                System.out.println("'" + calibrationValue.charAt(i) + "' is a letter");
                System.out.println("calibrationValue.charAt(i+1) " + calibrationValue.charAt(i+1));
                boolean isSecondLetter = !Character.isDigit(calibrationValue.charAt(i+1));
                System.out.println("isSecondLetter " + isSecondLetter);
                if (isSecondLetter) {
                    for (String mappedDigit : digitsAsStrings.keySet()) {
                        String possibleDigit = calibrationValue.substring(i, mappedDigit.length());
                        System.out.println("mapped word: " + mappedDigit);
                        System.out.println("possibleDigit: " + possibleDigit);
                        if (possibleDigit.equals(mappedDigit)) {
                            if (firstValue == '0') {
                                firstValue = calibrationValue.charAt(i);
                                lastValue = calibrationValue.charAt(i);
                                System.out.println("firstValue '"+ firstValue + "' is a number");
                                System.out.println("lastValue "+ lastValue + "' is a number");
                                break;
                            }
                            else {
                                lastValue = calibrationValue.charAt(i);
                                System.out.println("lastValue "+ lastValue + "' is a number");
                                break;
                            }
                        }
                    }
                }
            }*/
        }
        return Integer.parseInt(String.valueOf(firstValue)) * 10 + Integer.parseInt(String.valueOf(lastValue));
    }
}

