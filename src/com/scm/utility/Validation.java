package com.scm.utility;



public class Validation {

    public static boolean isValidUsername(String username) {
        // Username must be between 5 and 20 characters long
        return username != null && username.length() >= 5 && username.length() <= 20;
    }

    public static boolean isValidPassword(String password) {
        // Password must be at least 8 characters long and contain at least one number
        return password != null && password.length() >= 8 && password.matches(".*\\d.*");
    }

    public static boolean isValidEmail(String email) {
        //  Simple email pattern validation
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    public static boolean isValidPrice(double price) {
        return price > 0.0;
    }
}

