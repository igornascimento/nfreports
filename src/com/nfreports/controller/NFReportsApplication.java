package com.nfreports.controller;

import com.nfreports.model.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class application
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class NFReportsApplication extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    // The data as an observable list of Users
    private ObservableList<User> userData = FXCollections.observableArrayList();

    public ObservableList<User> getUserData() {
        return userData;
    }

    /**
     * Temporary constructor to provide some test data
     */
    public NFReportsApplication() {
        //adding some sample data
        userData.add(new User(1, "Igor Nascimento", "igornascimento@gmail.com", "asdfasdf", 1));
        userData.add(new User(2, "Julio Brombatti", "juliobrombatti@gmail.com", "asdfasdf", 1));
        userData.add(new User(3, "João da Silva", "joaodasilva@gmail.com", "asdfasdf", 2));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("NFReports Assistant");

        initRootLayout();
        showUsersOverview();
    }

    /**
     * Initializes the root layout
     */
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NFReportsApplication.class.getResource("../view/mainStage.fxml"));
            rootLayout = (BorderPane) loader.load();

            //shows the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns the main stage
     * @return Stage primaryStage
     */
    public Stage getPrimaryStage() {
        return this.primaryStage;
    }


    /**
     * SHOWING ANOTHER VIEW/DIALOG:
     * Injects the user overview inside root layout
     */
    private void showUsersOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NFReportsApplication.class.getResource("../view/userEdit.fxml"));
            AnchorPane userOverview = (AnchorPane) loader.load();

            //set user overview into center of root layout.
            //as border pane is the root element in the root layout, we can setCenter directly
            rootLayout.setCenter(userOverview);

            //gives the controller access to the main app
            UserEditController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * SHOWING ANOTHER VIEW/DIALOG:
     * Opens a dialog to edit the user information for the selected user or create a new one.
     * @param user object
     * @return true if user clicks save, otherwise false
     */
    public boolean showUserEditDialog(User user) {
        try {
            //load the fxml file and create a new stage for the popup dialog
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NFReportsApplication.class.getResource("../view/userForm.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            //create the dialog stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar usuário");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            //set the user into the controller
            UserFormController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setUser(user);

            //shows the dialog and wait for the user confirmation
            dialogStage.showAndWait();

            return controller.isSaveClicked();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
