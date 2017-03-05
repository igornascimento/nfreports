package com.example.login;

import java.io.IOException;

import com.example.login.controller.MapController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import sun.applet.Main;

/**
 * NFReports Assistant
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class NFReportsApplication extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("NFReports Assistant");

        initRootLayout();
    }

    /**
     * Initializes the root layout
     */
    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getClassLoader().getResource("views/mainStage.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Initialize the MapController
            MapController controller = loader.getController();
            controller.init();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
