package com.nfreports;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.inject.Inject;

public class NfreportsPresenter {
    @FXML
    private TextField name;

    @Inject
    NfreportsService nfreportsService;

    public void sayHello() {
        // Watch out! this code is executed inside the UI thread.
        nfreportsService.sayHello(name.getText());
    }
}
