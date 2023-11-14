package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    private Task1() {

    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    public static String averageTime(List<String> sessions) {
        Duration durationsSum = sessions.stream()
            .map(Task1::getDuration)
            .reduce(Duration::plus)
            .orElse(Duration.ZERO);

        var averageDuration = durationsSum.dividedBy(sessions.size());

        return averageDuration.toHours() + "ч" + " " + averageDuration.toMinutesPart() + "м";
    }

    private static Duration getDuration(String session) {
        String[] parts = session.split(" - ");

        LocalDateTime startDateTime = LocalDateTime.parse(parts[0], FORMATTER);
        LocalDateTime endDateTime = LocalDateTime.parse(parts[1], FORMATTER);

        return Duration.between(startDateTime, endDateTime);
    }
}
