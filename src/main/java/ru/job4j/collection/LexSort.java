package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] rslLeft = left.split("\\.");
        String[] rslRight = right.split("\\.");
        String partLeft = rslLeft[0];
        String partRight = rslRight[0];
        int x = Integer.parseInt(partLeft);
        int y = Integer.parseInt(partRight);
        return Integer.compare(x, y);
    }
}
