package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
             if (count >= 3) {
                System.out.println(player + " введите число от 1 до 3:");
            } else if (count == 1) {
                System.out.println(player + " забери последнюю спичку");
            } else {
                System.out.println(player + " введите число от 1 до 2");
            }
            int matches = Integer.parseInt(input.nextLine());
            boolean valid = matches < 4 && matches > 0 && matches <= count;
            if (valid) {
                count -= matches;
                turn = !turn;
            } else {
                System.out.println("Введите верное число");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }

    }
}
