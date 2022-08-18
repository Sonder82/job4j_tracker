package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password could not be null");
        }
        if (checkMatches(password)) {
            throw new IllegalArgumentException("Password contains multiple words");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password length must be between 8 and 32 ");
        }
        checkCharacter(password);
        return password;
    }

    private static void checkCharacter(String str) {
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                throw new IllegalArgumentException("Password contains Uppercase letter");
            }
            if (Character.isLowerCase(ch)) {
                throw new IllegalArgumentException("Password contains Lowercase letter");
            }
            if (Character.isDigit(ch)) {
                throw new IllegalArgumentException("Password contains Digital");
            }
            if (!Character.isLetterOrDigit(ch)) {
                throw  new IllegalArgumentException("Password contains Special character");
            }
        }
    }

    private static boolean checkMatches(String str) {
        boolean result = false;
        String[] matches = new String[] {"qwerty", "12345", "password", "admin", "user"};
        for (String s : matches) {
            if (str.toUpperCase().contains(s.toUpperCase())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
