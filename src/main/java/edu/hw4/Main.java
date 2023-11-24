package edu.hw4;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(List.of(
            new Animal("Boris Dmitrievich III", Animal.Type.CAT, Animal.Sex.M, 6, 65, 16, true),
            new Animal("Vasya", Animal.Type.CAT, Animal.Sex.M, 4, 50, 15, false),
            new Animal("Sharik ", Animal.Type.DOG, Animal.Sex.M, 7, 63, 20, false),
            new Animal("Barbos", Animal.Type.DOG, Animal.Sex.M, 11, 110, 25, true),
            new Animal("Dora", Animal.Type.DOG, Animal.Sex.F, 4, 60, 16, true),
            new Animal("Poppy", Animal.Type.BIRD, Animal.Sex.F, 3, 20, 2, false),
            new Animal("Polly", Animal.Type.BIRD, Animal.Sex.M, 5, 25, 3, true),
            new Animal("Gnome", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, true),
            new Animal("Empress Elizabeth 3", Animal.Type.SPIDER, Animal.Sex.F, 2, 13, 2, true),
            new Animal("Beowulf", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 6, true),
            new Animal("Dori", Animal.Type.FISH, Animal.Sex.F, 1, 10, 3, false),
            new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 3, 23, 5, false)
        ));

        System.out.println(AnimalTasks.task16(animals.subList(7, 12)).toString());
    }
}
