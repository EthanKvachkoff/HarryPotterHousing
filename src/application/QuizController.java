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
    
    Questions[] questionsArray = new Questions[5];
    
    String[] answers1 = {"Phoenix Feather", "Bagder fur", "Dragons scale", "Eagles feather"};
    String[] answers2 = {"Be up for the challenge, no question", 
            "Not sure about breaking the rules, but not willing to let your friends go alone", 
            "See it as an opportunity to report your friends to the head of house to get ahead",
            "See this as a great learning opportunity"};
    String[] answers3 = {"Be very proud of yourself and not mention it to your friend",
            "Be happy for your marks, keep it to yourself and then help tutor your friend",
            "Be very proud of yourself and let your friends know, as well as anyone else in earshot",
            "Not surprised at all by your good marks, not mention it to friends and take on extra credit for fun"};
    String[] answers4 = {"you play with integrity and chivarly",
            "You play with integrity and fairness",
            "You play with cunning and always look for an opportunity to have the upper hand",
            "You play with intelligence and creativity"};
    String[] answers5 = {"You pick up the box and hand it back",
            "You pick up the box, and hand it back and apologize for it happening",
            "You pick up the box and slip it into your pocket",
            "You magically place the box back in the person's pocket without them noticing"};
    
    @FXML
    void handleSubmitButtonAction(ActionEvent event) {
        try {
            String userName;
            userName = nameTextField.getText();
            Stage stage = (Stage) submitQuizButton.getScene().getWindow();
            stage.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private House calculateHouse() {
        int[] housePoints = new int[4];
        House house;
        
        if (answerSelect1.getValue() == getSpecificAnswer(questionsArray[0].getAnswers(), 0)) {
            housePoints[0] += 1;
        } else if (answerSelect1.getValue() == getSpecificAnswer(questionsArray[0].getAnswers(), 1)) {
            housePoints[1] += 1;
        } else if (answerSelect1.getValue() == getSpecificAnswer(questionsArray[0].getAnswers(), 2)) {
            housePoints[2] += 1;
        } else if (answerSelect1.getValue() == getSpecificAnswer(questionsArray[0].getAnswers(), 3)) {
            housePoints[3] += 1;
        }
        
        if (answerSelect2.getValue() == getSpecificAnswer(questionsArray[1].getAnswers(), 0)) {
            housePoints[0] += 1;
        } else if (answerSelect2.getValue() == getSpecificAnswer(questionsArray[1].getAnswers(), 1)) {
            housePoints[1] += 1;
        } else if (answerSelect2.getValue() == getSpecificAnswer(questionsArray[1].getAnswers(), 2)) {
            housePoints[2] += 1;
        } else if (answerSelect2.getValue() == getSpecificAnswer(questionsArray[1].getAnswers(), 3)) {
            housePoints[3] += 1;
        }
        
        if (answerSelect3.getValue() == getSpecificAnswer(questionsArray[2].getAnswers(), 0)) {
            housePoints[0] += 1;
        } else if (answerSelect3.getValue() == getSpecificAnswer(questionsArray[2].getAnswers(), 1)) {
            housePoints[1] += 1;
        } else if (answerSelect3.getValue() == getSpecificAnswer(questionsArray[2].getAnswers(), 2)) {
            housePoints[2] += 1;
        } else if (answerSelect3.getValue() == getSpecificAnswer(questionsArray[2].getAnswers(), 3)) {
            housePoints[3] += 1;
        }
        
        if (answerSelect4.getValue() == getSpecificAnswer(questionsArray[3].getAnswers(), 0)) {
            housePoints[0] += 1;
        } else if (answerSelect4.getValue() == getSpecificAnswer(questionsArray[3].getAnswers(), 1)) {
            housePoints[1] += 1;
        } else if (answerSelect4.getValue() == getSpecificAnswer(questionsArray[3].getAnswers(), 2)) {
            housePoints[2] += 1;
        } else if (answerSelect4.getValue() == getSpecificAnswer(questionsArray[3].getAnswers(), 3)) {
            housePoints[3] += 1;
        }
        
        if (answerSelect5.getValue() == getSpecificAnswer(questionsArray[4].getAnswers(), 0)) {
            housePoints[0] += 1;
        } else if (answerSelect5.getValue() == getSpecificAnswer(questionsArray[4].getAnswers(), 1)) {
            housePoints[1] += 1;
        } else if (answerSelect5.getValue() == getSpecificAnswer(questionsArray[4].getAnswers(), 2)) {
            housePoints[2] += 1;
        } else if (answerSelect5.getValue() == getSpecificAnswer(questionsArray[4].getAnswers(), 3)) {
            housePoints[3] += 1;
        }
        
       if (housePoints[0] == Questions.getLargestNumber(housePoints)) {
           House hufflepuff = new House("Hufflepuff", "Yellow & Black", "Hufflepuff is known for having members that are patient, fair, hard-working, and sometimes blandly nice.", 12); // FIX POPULATIOn
           return hufflepuff; 
       } else if (housePoints[1] == Questions.getLargestNumber(housePoints)) {
           House slytherin = new House("Slytherin", "Green & Silver", "Slytherins tend to be ambitious, shrewd, cunning, strong leaders, and achievement-oriented.", 12);
           return slytherin; 
       } else if (housePoints[2] == Questions.getLargestNumber(housePoints)) {
           House gryffindor = new House("Gryffindor", "Red & Gold", "Gryffindor is know to have te traits of courage as well as daring, nerve, and chivarly. Very Brave.", 12);
           return gryffindor; 
       } else if (housePoints[3] == Questions.getLargestNumber(housePoints)) {
           House ravenclaw = new House("Ravenclaw", "Blue & Bronze", "Ravenclaws possess the traits of cleverness, wisdom, wit, intellectual ability and creativity.", 12);
           return ravenclaw; 
       } else {
           System.out.println("Error: Can't create a house.");
       }
       return null;
    }
    
    public String getSpecificAnswer(String[] allAnswers, int answerNum) {
        return allAnswers[answerNum];
    }
    
    void initQuestions() {
        questionText1.setText(questionsArray[0].getPrompt());
        questionText2.setText(questionsArray[1].getPrompt());
        questionText3.setText(questionsArray[2].getPrompt());
        questionText4.setText(questionsArray[3].getPrompt());
        questionText5.setText(questionsArray[4].getPrompt());
    }
    
    void initQuestionArray() {
        questionsArray[0] = new Questions("You were about to begin school at Hogwarts, what type of core would your wand be?", answers1);
        questionsArray[1] = new Questions("Your friends decided to go to the Forbidden Forest, would you...", answers2);
        questionsArray[2] = new Questions("You received high marks in your class and your friend didn't ,would you...", answers3);
        questionsArray[3] = new Questions("When playing a game of chess...", answers4);
        questionsArray[4] = new Questions("You're walking in the halls of hogwarts and someone in front of you drops an unopened box of Choclate Frogs...", answers5);
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
        answerSelect4.setItems(FXCollections.observableArrayList("A) You play with integrity and chivalry.\n"
                + " ", "B) You play with integrity and fairness.\n" + " ","C) You play with cunning and always look for an opportunity to have the upper hand.\n"+ " ","D) You play with intelligence and creativity. "));
        answerSelect5.setValue("*Select an Answer*");  
        answerSelect5.setItems(FXCollections.observableArrayList("A) You pick up the box and hand it back.\n", "B) You pick up the box, hand it back and apologize for it happening.\n"
                + " ", "C) You pick up the box and slip it into your pocket to keep for yourself.\n"
                + " ", "D) You magically place the box back in the person’s pocket without them noticing. "));
        
        initQuestionArray();
        initQuestions();
    } 

}