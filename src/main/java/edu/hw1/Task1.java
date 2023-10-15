package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String str){
        var list = str.split(":");
        int min = Integer.parseInt(list[0]), sec = Integer.parseInt(list[1]);
        if (sec >= 60 || sec < 0)
            return -1;
        return min * 60 + sec;
    }
}
