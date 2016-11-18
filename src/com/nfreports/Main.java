package com.nfreports;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Parent root = FXMLLoader.load(getClass().getResource("view/mainstage.fxml"));
        primaryStage.setTitle("NFReports");
        primaryStage.setScene(new Scene(root));
        // primaryStage.setX(bounds.getMaxX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        // primaryStage.setMaximized(true);
    }
}
