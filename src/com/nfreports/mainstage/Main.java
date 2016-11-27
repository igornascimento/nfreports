package com.nfreports.mainstage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

import com.nfreports.login.LoginController;


public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        LoginController loginController = new LoginController();

        if (loginController.checkLoggedUser()) {
            initMainstage();
        }else{
            loginController.showModalLogin(primaryStage);
        }
    }

    public void initMainstage() {
        try {
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            Parent root = FXMLLoader.load(getClass().getResource("view/mainstage.fxml"));
            this.primaryStage.setTitle("NFReports");
            this.primaryStage.setScene(new Scene(root));
            // this.primaryStage.setX(bounds.getMaxX());
            this.primaryStage.setY(bounds.getMinY());
            this.primaryStage.setWidth(bounds.getWidth());
            this.primaryStage.setHeight(bounds.getHeight());
            this.primaryStage.show();
            // this.primaryStage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
