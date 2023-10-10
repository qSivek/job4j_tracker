package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByAscName() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Have a coffee", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Have a coffee", 2),
                new Job("Impl task", 0)
        );
        jobs.sort(new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByDescName() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Have a coffee", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Have a coffee", 2),
                new Job("Fix bug", 1)
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByAscPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("Have a coffee", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Have a coffee", 2)
        );
        jobs.sort(new JobAscByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByDescPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("Have a coffee", 2)
        );
        List<Job> expected = Arrays.asList(
                new Job("Have a coffee", 2),
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorNameDescAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}