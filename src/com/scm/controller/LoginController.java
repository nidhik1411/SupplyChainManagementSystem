package com.scm.controller;

import com.scm.models.User;
import com.scm.utility.Security;
import com.scm.utility.DataStorage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

import java.util.List;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        List<User> users = DataStorage.loadData("users.dat");
        if (users != null) {
            for (User user : users) {
                if (user.getUsername().equals(username) &&
                        Security.checkPassword(password, user.getPassword())) {
                    // Redirect to the dashboard
                    redirectToDashboard();
                    return;
                }
            }
        }
        errorLabel.setText("Invalid username or password!");
    }

    private void redirectToDashboard() {
        // Code to switch to the dashboard screen
    }
}
