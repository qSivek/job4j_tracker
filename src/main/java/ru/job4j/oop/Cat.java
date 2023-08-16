package ru.job4j.oop;

public class Cat {

    private String food;

    private String name;

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("The cat's name is " + this.name + " and he eats " + this.food);
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("Cutlet");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("Fish");
        black.show();
    }
}
