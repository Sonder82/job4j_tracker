package ru.job4j.queue;

import java.util.Comparator;

public class TaskByPositionAsk implements Comparator<Task> {
    @Override
    public int compare(Task first, Task second) {
        return first.position().compareTo(second.position());
    }
}
