package com.nfreports.login;

import javafx.stage.Stage;

public class LoginController {

    public boolean checkLoggedUser() {
        // check cookies or something?
        return true;
    }

    public void showModalLogin(Stage primaryStage) {
        // login.fxml show
    }

    public boolean doLogin(String user, String password) {
        if (user.equals("admin") && password.equals("1234")) {
            return true;
        }
        return false;
    }
}
