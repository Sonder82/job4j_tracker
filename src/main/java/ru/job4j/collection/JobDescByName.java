package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {

    @Override
    public int compare(Job nameFirst, Job nameSecond) {
        return nameSecond.getName().compareTo(nameFirst.getName());
    }
}
