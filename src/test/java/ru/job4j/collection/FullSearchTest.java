package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> tasks = Arrays.asList (
           new Task("1", "First desk"),
           new Task("2", "Second desk"),
           new Task("1", "First desk")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1","2"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));

    }
}