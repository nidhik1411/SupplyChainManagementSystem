package com.scm.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    // Method to hash a password
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    // Method to check if the entered password matches the stored hashed password
    public static boolean checkPassword(String enteredPassword, String storedHashedPassword) {
        String hashedEnteredPassword = hashPassword(enteredPassword);
        return hashedEnteredPassword.equals(storedHashedPassword);
    }

    // Method to check access based on roles
    public static boolean hasAccess(String role, String requiredRole) {
        return role.equals(requiredRole);
    }
}
