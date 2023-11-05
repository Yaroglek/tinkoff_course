package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTasksTest {
    private static final List<Animal> animals =
        new ArrayList<>(List.of(
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

    //Во многих тестах в качестве аргумента метода будет браться лишь часть всех животных, чтобы чтобы не приходилось
    //каждый раз передавать огромный список в expected
    @Test
    void task1() {
        assertEquals(
            List.of(animals.get(1), animals.get(4), animals.get(2), animals.get(0), animals.get(3)),
            AnimalTasks.task1(animals.subList(0, 5))
        );
    }

    @Test
    void task2() {
        assertEquals(List.of(animals.get(3), animals.get(2), animals.get(0)), AnimalTasks.task2(animals, 3));
    }

    @Test
    void task3() {
        assertEquals(Map.of(Animal.Type.CAT, 2, Animal.Type.DOG, 3), AnimalTasks.task3(animals.subList(0, 5)));
    }

    @Test void task4() {
        assertEquals(animals.get(0), AnimalTasks.task4(animals));
    }

    @Test void task5() {
        assertEquals(Animal.Sex.M, AnimalTasks.task5(animals));
    }

    @Test void task6() {
        assertEquals(Map.of(
            Animal.Type.DOG,
            animals.get(3),
            Animal.Type.BIRD,
            animals.get(6),
            Animal.Type.CAT,
            animals.get(0),
            Animal.Type.FISH,
            animals.get(11),
            Animal.Type.SPIDER,
            animals.get(9)
        ), AnimalTasks.task6(animals));
    }

    @Test void task7() {
        assertEquals(animals.get(0), AnimalTasks.task7(animals, 3));
    }

    @Test void task8() {
        assertEquals(animals.get(9), AnimalTasks.task8(animals, 21).get());
    }

    @Test void task9() {
        assertEquals(48, AnimalTasks.task9(animals));
    }

    @Test void task10() {
        var list = new ArrayList<>(animals);
        list.remove(1);
        list.remove(3);
        assertEquals(list, AnimalTasks.task10(animals));
    }

    @Test void task11() {
        assertEquals(List.of(animals.get(3)), AnimalTasks.task11(animals));
    }

    @Test void task12() {
        assertEquals(1, AnimalTasks.task12(animals));
    }

    @Test void task13() {
        assertEquals(List.of(animals.get(0), animals.get(8)), AnimalTasks.task13(animals));
    }

    @Test void task14() {
        assertEquals(true, AnimalTasks.task14(animals, 100));
    }

    @Test void task15() {
        assertEquals(Map.of(
            Animal.Type.CAT,
            16,
            Animal.Type.DOG,
            20
        ), AnimalTasks.task15(animals, 5, 8));
    }

    @Test void task16() {
        assertEquals(
            List.of(animals.get(11), animals.get(10), animals.get(9), animals.get(7), animals.get(8)),
            AnimalTasks.task16(animals.subList(7, 12))
        );
    }
}
