package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Ivan"),
                new Item("Viktor"),
                new Item("Oleg")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Ivan"),
                new Item("Oleg"),
                new Item("Viktor")
        );
        assertEquals(expected,items);
    }
}