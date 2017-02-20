package com.nfreports.controller;

import com.nfreports.NFReportsApplication;
import com.nfreports.model.User;
import com.nfreports.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller for users list
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class UserEditController {

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label roleLabel;

    @FXML
    private Label creationLabel;

    //reference to main application
    private NFReportsApplication mainApp;


    public UserEditController() {
    }

    /**
     * Initializes the controller class.
     * This method is automatically called after the FXML file has been loaded.
     */
    @FXML
    private void initialize() {
        //populates the user table with two columns
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        //clear the presentation details
        this.showUserDetails(null);

        //listens for selection changes (user table on left side) and updates the interface with the new information
        this.userTable.getSelectionModel()
                      .selectedItemProperty()
                      .addListener(
                              (observable, oldValue, newValue) -> this.showUserDetails(newValue)
                      );
    }

    /**
     * It's called by the main application to give a reference back to itself
     * @param mainApp
     */
    public void setMainApp(NFReportsApplication mainApp) {
        this.mainApp = mainApp;

        //add observable list data to the table
        this.userTable.setItems(mainApp.getUserData());
    }

    /**
     * Shows User in the form
     */
    public void showUserDetails(User user) {
        this.nameLabel.setText( user != null ? user.getName() : "" );
        this.emailLabel.setText( user != null ? user.getEmail() : "" );
        this.roleLabel.setText( user != null ? String.valueOf(user.getRole()) : "" );
        this.creationLabel.setText( user != null ? DateUtil.format(user.getCreation()) : "" );
    }

    /**
     * Removes the user
     */
    @FXML
    public void handleDeleteUser() {
        //TODO remove record from data base
        int selectedIndex = this.userTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            this.userTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(this.mainApp.getPrimaryStage());
            alert.setTitle("Atenção");
            alert.setHeaderText("Nenhum item selecionado");
            alert.setContentText("Selecione um item para efetuar a remoção.");
            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks the new button, opening a dialog
     */
    @FXML
    private void handleNewUser() {
        User tempUser = new User(null, null, null, null ,null);
        boolean okClicked = this.mainApp.showUserEditDialog(tempUser);
        if (okClicked) {
            this.mainApp.getUserData().add(tempUser);
        }
    }

    /**
     * Called when the user clicks the edit button, opening a dialog
     */
    @FXML
    private void handleEditUser() {
        User selectedUser = this.userTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            boolean okClicked = this.mainApp.showUserEditDialog(selectedUser);
            if (okClicked) {
                showUserDetails(selectedUser);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(this.mainApp.getPrimaryStage());
            alert.setTitle("Item não selecionado");
            alert.setHeaderText("Nenhum usuário selecionado");
            alert.setContentText("Por favor, selecione um usuário.");
            alert.showAndWait();
        }
    }

}
