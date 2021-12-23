package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<>();
        cars.add("Lada");
        cars.add("BMW");
        cars.add("Volvo");
        cars.add("Toyota");
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
