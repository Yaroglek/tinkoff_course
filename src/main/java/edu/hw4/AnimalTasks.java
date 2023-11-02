package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalTasks {
    private AnimalTasks() {
    }

    public static List<Animal> Task1(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> Task2(List<Animal> animals, int k) {

        return animals.stream().sorted(Collections.reverseOrder(Comparator.comparing(Animal::weight)))
            .limit(k).toList();
    }

    public static Map<Animal.Type, Integer> Task3(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(e -> 1)));
    }

    public static Animal Task4(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingInt(a -> a.name().length())).get();
    }

    public static Animal.Sex Task5(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.summingInt(e -> 1)))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static Map<Animal.Type, Animal> Task6(List<Animal> animals) {

        return null;
    }
//
//    public static Animal Task7(List<Animal> animals, int k) {
//
//        return null;
//    }
}
