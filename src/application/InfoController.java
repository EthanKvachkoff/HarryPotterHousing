package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class InfoController implements Initializable{
    
    @FXML
    private TextArea infoText;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        infoText.appendText("Name: " + "\n");
        infoText.appendText("House: " + "\n");
        infoText.appendText("Population: " + "\n");
        infoText.appendText("Pet: " + "\n");
    }

}
