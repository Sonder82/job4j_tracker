package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item nameFirst, Item nameSecond) {
        return nameSecond.getName().compareTo(nameFirst.getName());
    }

}
