package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Task3 {
    private Task3() {

    }

    public static Optional<LocalDate> parseDate(String string) {
        List<DateParser> parsers =
            List.of(
                new DateParser.ISODateParser(),
                new DateParser.BritishDateParser(),
                new DateParser.TextDateParser()
            );

        return parsers.stream()
            .filter(parser -> parser.canParseDate(string))
            .findFirst()
            .map(parser -> parser.parse(string));
    }
}


