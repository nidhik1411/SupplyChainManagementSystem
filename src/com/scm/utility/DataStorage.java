package com.scm.utility;
import java.io.*;
import java.util.List;

public class DataStorage {

    /**
     * Saves a list of objects to a file.
     *
     * @param <T>      The type of objects in the list.
     * @param data     The list of objects to save.
     * @param fileName The name of the file to save the data to.
     */
    public static <T> void saveData(List<T> data, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            ErrorHandling.handleException(e);
        }
    }

    /**
     * Loads a list of objects from a file.
     *
     * @param <T>      The type of objects in the list.
     * @param fileName The name of the file to load the data from.
     * @return A list of objects loaded from the file, or null if an error occurred.
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> loadData(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            ErrorHandling.handleException(e);
            return null;
        }
    }
}

