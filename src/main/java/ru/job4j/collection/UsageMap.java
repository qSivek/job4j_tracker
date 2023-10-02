package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("qsivek@gmail.com", "Daniil Zakaminyy");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("qsivek@gmail.com", "Daniil Zakaminyy Andreevich");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}