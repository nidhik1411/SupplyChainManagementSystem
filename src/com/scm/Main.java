package com.scm;

import com.scm.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.scm.utility.ErrorHandling;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the login screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/scm/views/LoginView.fxml"));
            Parent root = loader.load();

            // Set the scene and show the login window
            Scene scene = new Scene(root);
            primaryStage.setTitle("Supply Chain Management System - Login");
            primaryStage.setScene(scene);
            primaryStage.show();

            // Access the LoginController if needed for initial setup
            LoginController loginController = loader.getController();
            // Any initial logic can be added here

        } catch (Exception e) {
            // Handle any exceptions that occur during loading
            e.printStackTrace();
            ErrorHandling.handleException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

