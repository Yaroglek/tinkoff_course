package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnimalTasks {
    private static final Integer MAX_HEIGHT = 100;

    private AnimalTasks() {
    }

    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::height))
            .toList();
    }

    public static List<Animal> task2(List<Animal> animals, int k) {

        return animals.stream().sorted((Comparator.comparing(Animal::weight).reversed()))
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(e -> 1)));
    }

    public static Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .get();
    }

    public static Animal.Sex task5(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::weight).reversed())
            .limit(k).reduce((animal1, animal2) -> animal2)
            .get();
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer task9(List<Animal> animals) {
        return animals.stream()
            .map(Animal::paws)
            .reduce(Integer::sum)
            .get();
    }

    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.paws() != animal.age())
            .toList();
    }

    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(Animal::bites)
            .filter(animal -> animal.height() > MAX_HEIGHT)
            .toList();
    }

    public static Integer task12(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    public static Boolean task14(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int i) {
        return animals.stream()
            .filter(animal -> animal.age() > k && animal.age() < i)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    public static Boolean task17(List<Animal> animals) {
        Map<Animal.Type, Integer> typeCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG || animal.type() == Animal.Type.SPIDER)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(e -> 1)));

        long dogsCount = typeCount.getOrDefault(Animal.Type.DOG, 0);
        long spidersCount = typeCount.getOrDefault(Animal.Type.SPIDER, 0);

        if (spidersCount == 0 || dogsCount == 0) {
            return false;
        }

        Map<Animal.Type, Integer> bitingCount = animals.stream()
            .filter(Animal::bites)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(e -> 1)));

        return bitingCount.get(Animal.Type.SPIDER) / spidersCount > bitingCount.get(Animal.Type.DOG) / dogsCount;
    }

    public static Animal task18(List<Animal>... animalsLists) {
        var animals = new ArrayList<Animal>();
        Arrays.stream(animalsLists).forEach(animals::addAll);
        return animals.stream()
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .get();
    }

    public static Map<String, Set<AnimalValidator.ValidationError>> task19(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::name, AnimalValidator::getErrors))
            .entrySet().stream()
            .filter(set -> !set.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, String> task20(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                animal -> AnimalValidator.getErrors(animal).stream().map(AnimalValidator.ValidationError::error)
                    .collect(
                        Collectors.joining(", "))

            )).entrySet().stream()
            .filter(set -> !set.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
