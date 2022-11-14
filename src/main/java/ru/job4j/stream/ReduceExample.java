package ru.job4j.stream;

import ru.job4j.stream.mapTo.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .reduce(
                        154, (integer, person) -> {
                            if (person.getAge() > 25) {
                                return integer + person.getAge();
                            } else {
                                return integer;
                            }
                        },
                        (integer, integer2) -> integer + integer2
                );
        System.out.println(sum);
    }
}
