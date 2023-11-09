package edu.hw3;

import java.util.NavigableMap;
import java.util.TreeMap;

@SuppressWarnings({"MagicNumber", "ParameterAssignment"})
public class Task4 {
    private static final NavigableMap<Integer, String> CONVERTATION = new TreeMap<Integer, String>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    private Task4() {
    }

    //Римскими числами нельза записать число более 3999
    public static String convertToRoman(Integer input) {
        if (input >= 4000 || input <= 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (Integer key : CONVERTATION.descendingKeySet()) {
            while (input >= key) {
                input -= key;
                result.append(CONVERTATION.get(key));
            }
        }
        return result.toString();
    }
}
