package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorAskByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 1),
                new Job("Manager", 3),
                new Job("Driver", 2),
                new Job("Builder", 4)
        );
        Collections.sort(jobs, new JobAskByName());
        List<Job> expected = Arrays.asList(
                new Job("Builder", 4),
                new Job("Doctor", 1),
                new Job("Driver", 2),
                new Job("Manager", 3)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 1),
                new Job("Manager", 3),
                new Job("Driver", 2),
                new Job("Builder", 4)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Manager", 3),
                new Job("Driver", 2),
                new Job("Doctor", 1),
                new Job("Builder", 4)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenComparatorAskByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 1),
                new Job("Manager", 3),
                new Job("Driver", 2),
                new Job("Builder", 4)
        );
        Collections.sort(jobs, new JobAskByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Doctor", 1),
                new Job("Driver", 2),
                new Job("Manager", 3),
                new Job("Builder", 4)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 1),
                new Job("Manager", 3),
                new Job("Driver", 2),
                new Job("Builder", 4)
        );
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Builder", 4),
                new Job("Manager", 3),
                new Job("Driver", 2),
                new Job("Doctor", 1)

        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Doctor", 1),
                new Job("Buildrer", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityThree() {
        Comparator<Job> cmpNamePriority = new JobAskByName().thenComparing(new JobAskByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Doctor", 10),
                new Job("Doctor", 3)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityFour() {
        Comparator<Job> cmpNamePriority = new JobAskByName().thenComparing(new JobAskByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Builder", 10),
                new Job("Doctor", 3)
        );
        assertThat(rsl, lessThan(0));
    }
}