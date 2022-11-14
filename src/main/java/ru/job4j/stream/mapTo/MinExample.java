package ru.job4j.stream.mapTo;

import java.util.*;

public class MinExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int youngestPerson = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(youngestPerson);
    }
}
