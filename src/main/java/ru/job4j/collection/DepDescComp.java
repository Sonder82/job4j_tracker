package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp  implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        String firstEl = first[0];
        String secondEl = second[0];
        if (firstEl.equals(secondEl)) {
            return o1.compareTo(o2);
        } else {
            return secondEl.compareTo(firstEl);
        }
    }
}
