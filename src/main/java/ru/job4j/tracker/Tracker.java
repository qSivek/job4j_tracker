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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsByName = new Item[items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                itemsByName[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemsByName, count);
    }

    private int indexOf(int id) {
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int itemIndex = indexOf(id);
        boolean rsl = itemIndex != -1;
        if (rsl) {
            item.setId(id);
            items[itemIndex] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int itemIndex = indexOf(id);
        boolean rsl = itemIndex != -1;
        if (rsl) {
            System.arraycopy(items, itemIndex + 1, items, itemIndex, size - itemIndex - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}
