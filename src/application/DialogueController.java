// Class DialogueController, C211 Group Project, Spring 2023
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

public class DialogueController implements Initializable {

    @FXML
    private Button closeSearchButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Label idLabel;

    // Boolean variables that change value
    // based on which situation has occurred
    public static boolean isIdError = false;

    public static boolean validInput = false;

    public static boolean validQuiz = true;

    public static int userId = 00000;

    // Closes the dialog box
    @FXML
    void handleCloseButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) closeSearchButton.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Message of the dialog box is changed based on the situation
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if (isIdError == true) {
            idLabel.setText("ERROR:");
            errorLabel.setText("ID not found! Enter a valid ID.");
            isIdError = false;
        }
        if (validInput == true) {
            idLabel.setText("ID: " + userId);
            errorLabel.setText("FOUND! House Information Updated!");
            validInput = false;
        }
        if (validQuiz == false) {
            idLabel.setText("ERROR:");
            errorLabel.setText("Please make sure all fields are filled out!");
            validQuiz = true;
        }

    }

}
