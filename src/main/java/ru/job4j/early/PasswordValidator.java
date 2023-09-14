package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    private static boolean validQwerty(String password) {
        for (String s : FORBIDDEN) {
            if (password.toLowerCase().contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        boolean hasMoreEightLessThirtyTwo = password.length() > 7 && password.length() < 33;
        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char symbol : password.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                hasUpCase = true;
            }
            if (Character.isLowerCase(symbol)) {
                hasLowCase = true;
            }
            if (Character.isDigit(symbol)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(symbol)) {
                hasSpecial = true;
            }
            if (hasUpCase && hasLowCase && hasDigit && hasSpecial) {
                break;
            }
        }

        if (!hasMoreEightLessThirtyTwo) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]"
            );
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        if (validQwerty(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }
        return password;
    }
}