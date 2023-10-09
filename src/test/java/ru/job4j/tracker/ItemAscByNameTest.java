package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void sort() {
        List<Item> items = Arrays.asList(
                new Item("List", 1),
                new Item("Z", 2),
                new Item("Reboot server", 3),
                new Item("Ivan Russ", 4),
                new Item("Avenger", 5)
        );
        List<Item> expected = Arrays.asList(
                new Item("Avenger", 5),
                new Item("Ivan Russ", 4),
                new Item("List", 1),
                new Item("Reboot server", 3),
                new Item("Z", 2)
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}