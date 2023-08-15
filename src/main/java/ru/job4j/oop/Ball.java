package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condtion) {
        if (condtion) {
            System.out.println("Kolobok was eaten");
        } else {
            System.out.println("Kolobok ran away");
        }
    }
}
