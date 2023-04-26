// Class SearchController, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff
package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class SearchController implements Initializable {

    @FXML
    private Button closeSearchButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Label idLabel;

    public static boolean isIdError = false;

    public static boolean validInput = false;

    public static int userId = 00000;

    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) closeSearchButton.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if (isIdError == true) {
            idLabel.setText("ERROR:");
            errorLabel.setText("ID not found! Enter a valid ID.");
        }
        if (validInput == true) {
            idLabel.setText("ID: " + userId);
            errorLabel.setText("FOUND! House Information Updated!");
        }

    }

}
