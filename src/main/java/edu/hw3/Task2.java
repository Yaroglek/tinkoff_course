package edu.hw3;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Task2 {
    private Task2() {
    }

    public static ArrayList<String> clusterize(String input) {
        var brackets = input.toCharArray();

        var result = new ArrayList<String>();
        var stack = new ArrayDeque<>();
        var currentCluster = new StringBuilder();

        for (char bracket : brackets) {
            if (bracket == '(') {
                stack.push(bracket);
            } else if (bracket == ')') {
                stack.remove();
            }
            currentCluster.append(bracket);

            if (stack.isEmpty()) {
                result.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }

        return result;
    }
}
