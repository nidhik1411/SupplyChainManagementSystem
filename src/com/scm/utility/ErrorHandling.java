package com.scm.utility;


import java.io.FileWriter;
import java.io.IOException;

public class ErrorHandling {

    public static void logError(String errorMessage) {
        try (FileWriter writer = new FileWriter("error.log", true)) {
            writer.write(errorMessage + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static void displayError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }

    public static void handleException(Exception e) {
        logError(e.getMessage());
        displayError(e.getMessage());
    }
}

