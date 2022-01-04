package ru.job4j.collection;

import java.util.Comparator;

public class JobAskByName implements Comparator<Job> {

    @Override
    public int compare(Job nameFirst, Job nameSecond) {
        return nameFirst.getName().compareTo(nameSecond.getName());
    }
}
