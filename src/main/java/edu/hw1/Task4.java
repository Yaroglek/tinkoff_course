package edu.hw1;

public class Task4 {
    public static String fixString(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length - 1; i += 2) {
            char temp = ch[i];
            ch[i] = ch[i + 1];
            ch[i + 1] = temp;
        }
        return String.valueOf(ch);
    }
}
