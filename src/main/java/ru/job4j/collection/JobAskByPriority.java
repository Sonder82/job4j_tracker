package ru.job4j.collection;

import java.util.Comparator;

public class JobAskByPriority implements Comparator<Job> {

    @Override
    public int compare(Job priorityFirst, Job prioritySecond) {
        return Integer.compare(priorityFirst.getPriority(), prioritySecond.getPriority());
    }
}
