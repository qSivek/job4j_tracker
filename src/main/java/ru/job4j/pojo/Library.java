package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book headFirstJava = new Book("Head First Java", 720);
        Book cleanCode = new Book("Clean Code", 1337);
        Book bible = new Book("Bible", 1200);
        Book witcher = new Book("The Witcher", 240);
        Book[] books = {headFirstJava, cleanCode, bible, witcher};
        for (Book x : books) {
            System.out.println("Title of the book: " + x.getName() + " and number of pages " + x.getPageCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book x : books) {
            System.out.println("Title of the book: " + x.getName() + " and number of pages " + x.getPageCount());
        }
        for (Book x : books) {
            if (x.getName().equals("Clean Code")) {
                System.out.println("Title of the book: " + x.getName() + " and number of pages " + x.getPageCount());
            }
        }
    }
}
