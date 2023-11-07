package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    private Task5() {
    }

    public static List<String> parseContacts(String[] names, Order order) {
        if (names == null || names.length == 0) {
            return new ArrayList<>();
        }
        var result = Arrays.stream(names)
            .map(name -> name.split(" "))
            .sorted((name1, name2) -> String.CASE_INSENSITIVE_ORDER.compare(
                name1.length > 1 ? name1[1] : name1[0],
                name2.length > 1 ? name2[1] : name2[0]
            ))
            .collect(Collectors.toList());
        if (order == Order.DESC) {
            result = new ArrayList<>(result.reversed());
        }
        return result.stream().map(name -> String.join(" ", name)).toList();
    }

    public enum Order {
        ASC,
        DESC
    }
}


