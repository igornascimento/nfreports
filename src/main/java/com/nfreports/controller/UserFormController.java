package com.nfreports.controller;

import com.nfreports.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Dialog to edit details of a user
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class UserFormController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField roleField;


    private Stage dialogStage;

    private User user;

    private Boolean saveClicked;


    /**
     * Initializes the controller class.
     * This method is automatically called after the FXML has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the user being edited
     */
    public void setUser(User user) {
        this.user = user;
        this.nameField.setText(user.getName());
        this.emailField.setText(user.getEmail());
        this.roleField.setText(String.valueOf(user.getRole()));
        this.passwordField.setText(user.getPassword());
    }

    public Boolean isSaveClicked() {
        return this.saveClicked;
    }

    /**
     * Handle Save button and adds the user
     */
    public void handleSave() {
        if (this.validateForm()) {
            this.user.setName(nameField.getText());
            this.user.setEmail(emailField.getText());
            //this.user.setRole(roleField.getText());
            this.user.setPassword(passwordField.getText());

            this.saveClicked = true;
            this.dialogStage.close();
        }
    }

    public void handleCancel() {
        this.dialogStage.close();
    }

    public Boolean validateForm() {
        String errorMsg = "";
        Boolean hasError = false;

        if (this.nameField.getText() == null || this.nameField.getText().length() == 0) {
            errorMsg += "O campo nome deve ser informado.\n";
            hasError = true;
        }
        if (this.emailField.getText() == null || this.emailField.getText().length() == 0) {
            errorMsg += "O campo email deve ser informado.\n";
            hasError = true;
        }
        //if (this.roleField.getText() == null || this.roleField.getText().length() == 0) {
        //  errorMsg += "O campo nível do usuário deve ser informado.\n";
        //  hasError = true;
        //}
        if (this.passwordField.getText() == null || this.passwordField.getText().length() == 0) {
            errorMsg += "O campo senha deve ser informado.\n";
            hasError = true;
        }

        if (!hasError) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(this.dialogStage);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Por favor corrija os campos inválidos para prosseguir.");
            alert.setContentText(errorMsg);
            alert.showAndWait();
            return false;
        }
    }

}
