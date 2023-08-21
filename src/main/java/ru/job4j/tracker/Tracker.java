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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int itemIndex = indexOf(id);
        if (itemIndex == -1) {
            return false;
        } else {
            item.setId(id);
            items[itemIndex] = item;
            return true;
        }
    }
}