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
import javafx.collections.FXCollections;
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
        answerSelect1.setItems(FXCollections.observableArrayList("A) Phoenix Feather", "B) Badger fur","C) Dragons scale","D) Eagles feather"));
        answerSelect2.setValue("*Select an Answer*");
        answerSelect2.setItems(FXCollections.observableArrayList("A) Be up for the challenge, no question.\n"
        		+ " ", "B) Not sure about breaking the rules, but not willing to let your friends go alone. \n"
        				+ "","C) See it as an opportunity to report your friends to the head of house to get ahead.\n"
        						+" ", "D) See this as a great learning opportunity."));
        answerSelect3.setValue("*Select an Answer*");
        answerSelect3.setItems(FXCollections.observableArrayList("A) Be very proud of yourself and not mention it to your friend.", "B) Be happy for your marks, keep it to yourself and then help tutor your friend.\n"
        		+ " ", "B) Be very proud of yourself and let your friend know, as well as anyone else in earshot. \n"
        				+ " ","D) Not surprised at all by your good marks, not mention it to friends and take on extra credit for fun. "));
        answerSelect4.setValue("*Select an Answer*");
        answerSelect4.setItems(FXCollections.observableArrayList("A)You play with integrity and chivalry.\n"
        		+ " ", "B) You play with integrity and fairness.\n" + " ","C)You play with cunning and always look for an opportunity to have the upper hand.\n"+ " ","D) You play with intelligence and creativity. "));
        answerSelect5.setValue("*Select an Answer*");  
        answerSelect5.setItems(FXCollections.observableArrayList("A)You pick up the box and hand it back.\n", "B) You pick up the box, hand it back and apologize for it happening.\n"
        		+ " ", "C) You pick up the box and slip it into your pocket to keep for yourself.\n"
        		+ " ", "D) You magically place the box back in the person’s pocket without them noticing. "));
    } 

}
