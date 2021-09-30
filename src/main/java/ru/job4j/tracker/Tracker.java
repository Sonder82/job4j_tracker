package ru.job4j.tracker;

import java. util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item [] findAll = new Item[size];
        int rsl = 0;
        for (int index = 0; index < size; index++) {
                findAll[rsl] = items[index];
                rsl++;
            }
        return Arrays.copyOf(findAll, size);

        }


    public Item[] findByName(String key) {
        int index = 0;
        Item [] findByName = new Item[size];
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                findByName[index] = item;
              index++;
            }
        }
            return Arrays.copyOf(findByName, index);

    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}