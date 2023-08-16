package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Is there a mistake: " + active);
        System.out.println("Error number: " + status);
        System.out.println("Error message: " + message);
    }

    public static void main(String[] args) {
        Error notError = new Error();
        Error criticalError = new Error(true, 801, "I will sell the garage");
        Error notCriticalError = new Error(true, 500001, "Your computer burned down");
        notError.printInfo();
        criticalError.printInfo();
        notCriticalError.printInfo();
    }
}
