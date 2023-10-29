package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;

public class Task5 {
    private Task5() {
    }

    public static ArrayList<String> parseContacts(String[] names, String order) {
        if (names == null || names.length == 0) {
            return new ArrayList<>();
        }
        var result = new ArrayList<>(Arrays.asList(names));
        result.sort((ln1, ln2) -> String.CASE_INSENSITIVE_ORDER.compare(
            ln1.split(" ").length > 1 ? ln1.split(" ")[1] : ln1,
            ln2.split(" ").length > 1 ? ln2.split(" ")[1] : ln2
        ));
        if (order.equals("DESC")) {
            result = new ArrayList<>(result.reversed());
        }
        return result;
    }

    public static ArrayList<String> parseContacts(String[] names) {
        return parseContacts(names, "ASC");
    }
}
