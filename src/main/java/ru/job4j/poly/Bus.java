package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void passengers(int numberPassengers) {
        System.out.println("В автобусе " + numberPassengers + "пасажиров");
    }

    @Override
    public int fuelPrice(int fuel) {
        return fuel * 45;
    }
}
