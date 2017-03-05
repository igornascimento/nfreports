package com.example.login.controller;

import java.io.IOException;
import java.io.InputStream;

import netscape.javascript.JSObject;
import org.apache.commons.io.IOUtils;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MapController {

    @FXML
    private Label statusLabel;

    @FXML
    private StringProperty status;

    @FXML
    WebView webView;
    WebEngine engine;

    @FXML
    BooleanProperty loaded = new SimpleBooleanProperty(false);

    @FXML
    Button goButton;

    public void init() {

        // Make the "Go" button disabled until the page content is loaded
        goButton.disableProperty().bind(loaded.not());
        // A good example of "computed bindings" : http://stackoverflow.com/questions/23040531/how-to-disable-button-when-textfield-is-empty

        // Bind the status label to a property
        status = new SimpleStringProperty("");
        statusLabel.textProperty().bind(status);

        // Get a reference to the WebView's WebEngine
        engine = webView.getEngine();

        // Add a listener so we can get notified when the page content is loaded
        engine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    public void changed(ObservableValue ov, State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            loaded.set(true);
                        }
                    }
                });

        // Give the browser a "java" object that can be used to "upcall" into the Java application.
        JSObject window = (JSObject) engine.executeScript("window");
        window.setMember("java", new JavaApplication());

        // Load the page content
        String content = "Failed to load content.";
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("webViews/map.html");
            content = IOUtils.toString(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        engine.loadContent(content);

        // You can also do this:
        //engine.load("http://www.youtube.com");
    }

    @FXML
    private void handleGo() {
        try {
            //When the go button is pressed, invoke go.js
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("webViews/go.js");
            String script = IOUtils.toString(in);
            engine.executeScript(script);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * An example class for JavaScript to Java upcalls
     */
    public class JavaApplication {
        //Using (Double lat, Double lng) did not work:
        public void updateCenter(String lat, String lng) {
            status.set("Center : " + lat + ", " + lng);
        }
    }
}