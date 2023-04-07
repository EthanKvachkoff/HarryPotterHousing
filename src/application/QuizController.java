// Class QuizController, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff
package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class QuizController implements Initializable{
    
    @FXML
    private Button submitQuizButton;
    
    @FXML
    private TextField nameTextField;
    
    @FXML
    private TextField questionText1;
    
    @FXML
    private TextField questionText2;
    
    @FXML
    private TextField questionText3;
    
    @FXML
    private TextField questionText4;
    
    @FXML
    private TextField questionText5;
    
    @FXML
    private ChoiceBox<String> answerSelect1;
    
    @FXML
    private ChoiceBox<String> answerSelect2;
    
    @FXML
    private ChoiceBox<String> answerSelect3;
    
    @FXML
    private ChoiceBox<String> answerSelect4;
    
    @FXML
    private ChoiceBox<String> answerSelect5;
    
    
    
    @FXML
    void handleSubmitButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) submitQuizButton.getScene().getWindow();
            stage.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        answerSelect1.setValue("*Select an Answer*");
        answerSelect2.setValue("*Select an Answer*");
        answerSelect3.setValue("*Select an Answer*");
        answerSelect4.setValue("*Select an Answer*");
        answerSelect5.setValue("*Select an Answer*");  
    } 

}
