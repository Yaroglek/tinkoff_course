package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MagicNumber")
public class Task2 {
    private Task2() {

    }

    public static List<String> findAllFridaysThirteen(int year) {
        var result = new ArrayList<String>();

        for (int i = 1; i < 13; i++) {
            LocalDate current13th = LocalDate.of(year, i, 13);

            if (current13th.getDayOfWeek() == DayOfWeek.FRIDAY) {
                result.add(current13th.toString());
            }
        }

        return result;
    }

    public static String findNextFridayThirteen(String date) {
        boolean is13Friday = false;
        LocalDate result = LocalDate.parse(date);

        while (!is13Friday) {
            result = result.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            is13Friday = result.getDayOfMonth() == 13;
        }

        return result.toString();
    }
}
