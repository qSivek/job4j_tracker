package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] strOne = o1.split("\\.");
        String[] strTwo = o2.split("\\.");
        return Integer.compare(
                Integer.parseInt(strOne[0]),
                Integer.parseInt(strTwo[0])
        );
    }
}
