package ru.job4j.queue;

import java.util.Comparator;

public class TaskByUrgencyDesc implements Comparator<Task> {

    @Override
    public int compare(Task first, Task second) {
        return Integer.compare(second.urgency(), first.urgency());
    }
}
