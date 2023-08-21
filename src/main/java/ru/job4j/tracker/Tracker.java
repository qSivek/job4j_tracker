package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemNotNull = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                itemNotNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemNotNull, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsByName = new Item[items.length];
        int size = 0;
        for (Item item : findAll()) {
            if (item.getName().equals(key)) {
                itemsByName[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsByName, size);
    }

    public Item findById(int id) {
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}