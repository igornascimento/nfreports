package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button btn;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        System.out.println("Testing the button.");
    }

}
