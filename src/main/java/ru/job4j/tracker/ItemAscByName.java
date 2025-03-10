package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item nameFirst, Item nameSecond) {
        return nameFirst.getName().compareTo(nameSecond.getName());
    }
}
