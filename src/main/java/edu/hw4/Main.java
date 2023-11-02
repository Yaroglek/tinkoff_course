package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(List.of(
            new Animal("Boris", Animal.Type.CAT, Animal.Sex.M, 10, 50, 15, true),
            new Animal("Sharik", Animal.Type.DOG, Animal.Sex.M, 11, 60, 20, true),
            new Animal("Poppy", Animal.Type.BIRD, Animal.Sex.F, 3, 20, 3, true),
            new Animal("Dori", Animal.Type.FISH, Animal.Sex.F, 1, 10, 1, true),
            new Animal("Gnom", Animal.Type.SPIDER, Animal.Sex.M, 2, 15, 2, true)));

        System.out.println(AnimalTasks.Task6(animals).toString());
    }
}
