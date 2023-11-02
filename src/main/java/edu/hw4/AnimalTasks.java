package edu.hw4;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnimalTasks {
    private AnimalTasks() {
    }

    public static List<Animal> Task1(List<Animal> animals) {
        return animals.stream().sorted((a1, a2) -> Integer.compare(a1.height(), a2.height())).toList();
    }

    public static List<Animal> Task2(List<Animal> animals, int k) {

        return animals.stream().sorted(Collections.reverseOrder((a1, a2) -> Integer.compare(a1.weight(), a2.weight()))).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> Task3(List<Animal> animals) {
        var result = new HashMap<Animal.Type, Integer>();
        Map<Animal.Type, Integer> animalCountMap = animals.stream()
            .collect(Collectors.groupingBy(Animal.Type, Collectors.summingInt(e -> 1)));
        return null;
    }
//
//    public static Animal Task4(List<Animal> animals) {
//
//        return null;
//    }
//
//    public static Animal.Sex Task5(List<Animal> animals) {
//
//        return null;
//    }
//
//    public static Map<Animal.Type, Animal> Task6(List<Animal> animals) {
//
//        return null;
//    }
//
//    public static Animal Task7(List<Animal> animals, int k) {
//
//        return null;
//    }
}
