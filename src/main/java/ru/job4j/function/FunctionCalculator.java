package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = start; i < end; i++) {
            temp.add(func.apply((double) i));
        }
        return temp;
    }
}