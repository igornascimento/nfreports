package com.nfreports.mainstage;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
//        try {
            Scene scene = new Scene(new Group());
            VBox root = new VBox();

            WebView browser = new WebView();
            WebEngine webEngine = browser.getEngine();
            webEngine.load("../../resources/views/mainstage.html");

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(browser);
            webEngine.loadContent("<p><b>Foooooooi...</b></p>");

            root.getChildren().addAll(scrollPane);
            scene.setRoot(root);

            this.primaryStage.setScene(scene);
            this.primaryStage.show();

//            // setting up properties
//            Screen screen = Screen.getPrimary();
//            Rectangle2D bounds = screen.getVisualBounds();
//            this.primaryStage.setTitle("NFReports");
//            this.primaryStage.setScene(new Scene(webEngine));
//            this.primaryStage.setY(bounds.getMinY());
//            this.primaryStage.setWidth(bounds.getWidth());
//            this.primaryStage.setHeight(bounds.getHeight());
//            this.primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
