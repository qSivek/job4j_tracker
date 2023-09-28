package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> itemsByName = new ArrayList<>();
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsByName.add(item);
                count++;
            }
        }
        return itemsByName;
    }

    private int indexOf(int id) {
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int itemIndex = indexOf(id);
        boolean rsl = itemIndex != -1;
        if (rsl) {
            item.setId(id);
            items.set(itemIndex, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int itemIndex = indexOf(id);
        boolean rsl = itemIndex != -1;
        if (rsl) {
            items.remove(itemIndex);
        }
        return rsl;
    }
}
