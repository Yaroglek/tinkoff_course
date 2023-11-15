package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("MagicNumber")
public interface DateParser {
    boolean canParseDate(String date);

    int getPriority();

    LocalDate parse(String date);

    class ISODateParser implements DateParser {

        @Override public boolean canParseDate(String date) {
            Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{1,2}$");
            Matcher matcher = pattern.matcher(date);

            return matcher.matches();
        }

        @Override public int getPriority() {
            return 1;
        }

        @Override public LocalDate parse(String date) {
            String[] dateParts = date.split("-");
            if (dateParts[2].length() == 1) {
                dateParts[2] = "0" + dateParts[2];
            }
            return LocalDate.parse(String.join("-", dateParts));
        }
    }

    class BritishDateParser implements DateParser {

        @Override public boolean canParseDate(String date) {
            Pattern pattern = Pattern.compile("^\\d/\\d/\\d{2,4}$");
            Matcher matcher = pattern.matcher(date);

            return matcher.matches();
        }

        @Override public int getPriority() {
            return 2;
        }

        @Override public LocalDate parse(String date) {
            String[] dateParts = date.split("/");
            if (dateParts[2].length() == 2) {
                dateParts[2] = "20" + dateParts[2];
            }
            return LocalDate.of(
                Integer.parseInt(dateParts[2]),
                Integer.parseInt(dateParts[1]),
                Integer.parseInt(dateParts[0])
            );
        }
    }

    class TextDateParser implements DateParser {

        @Override public boolean canParseDate(String date) {
            Pattern pattern = Pattern.compile("^tomorrow|today|yesterday|^\\d+ day(s?) ago$");
            Matcher matcher = pattern.matcher(date);

            return matcher.matches();
        }

        @Override public int getPriority() {
            return 3;
        }

        @Override public LocalDate parse(String date) {
            LocalDate resultDate = LocalDate.now();

            return switch (date) {
                case ("tomorrow") -> resultDate.plusDays(1);
                case ("today") -> resultDate;
                case ("yesterday") -> resultDate.minusDays(1);
                default -> resultDate.minusDays(Long.parseLong(date.split(" ")[0]));
            };
        }
    }
}
