// Class QuizController, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff
package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

public class QuizController implements Initializable {
    // Button to submit quiz
    @FXML
    private Button submitQuizButton;
    // Name field for user name input
    @FXML
    private TextField nameTextField;
    // Text field to display questions
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
    // Drop down menu to display multiple choice questions.
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
    // Arrays to assist in the calculateHouse method, createUser method,
    Questions[] questionsArray = new Questions[5];

    HouseArray houseArray = new HouseArray(4);

    UserList userList = new UserList();

    public User usableUser;

    String[] answers1 = { "A) Phoenix Feather", "B) Badger fur", "C) Dragons scale", "D) Eagles feather" };
    String[] answers2 = { "A) Be up for the challenge, no question.",
            "B) Not sure about breaking the rules, but not willing to let your friends go alone.",
            "C) See it as an opportunity to report your friends to the head of house to get ahead.",
            "D) See this as a great learning opportunity." };
    String[] answers3 = { "A) Be very proud of yourself and not mention it to your friend.",
            "B) Be happy for your marks, keep it to yourself and then help tutor your friend.",
            "C) Be very proud of yourself and let your friend know, as well as anyone else in earshot.",
            "D) Not surprised at all by your good marks, not mention it to friends and take on extra credit for fun." };
    String[] answers4 = { "A) You play with integrity and chivalry.", "B) You play with integrity and fairness.",
            "C) You play with cunning and always look for an opportunity to have the upper hand.",
            "D) You play with intelligence and creativity." };
    String[] answers5 = { "A) You pick up the box and hand it back.",
            "B) You pick up the box, hand it back and apologize for it happening.",
            "C) You pick up the box and slip it into your pocket to keep for yourself.",
            "D) You magically place the box back in the person’s pocket without them noticing." };

    @FXML // Event to submit the finish quiz and write the results.
    void handleSubmitButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) submitQuizButton.getScene().getWindow();
            if (quizValidation() == true) {
                House userHouse = calculateHouse();
                usableUser = createUser(userHouse);
                userList = UserList.grabUsers();
                userList.users.add(usableUser);
                userList.write("users.txt");
                InfoController.tempUser = usableUser;
                System.out.println(usableUser.getName() + "\n" + usableUser.getHouse().name + "\n" + usableUser.id
                        + "\n" + usableUser.pet); // test case
                quizValidation();
                stage.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Quiz validation dialog box
    public void quizDialogBox() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DialogueGUI.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ERROR:");
            stage.setScene(new Scene(root2, 280, 125));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method that checks if name has been entered
    // and all questions have been answered
    private boolean quizValidation() {
        if (nameTextField.getText().trim().isEmpty() || answerSelect1.getValue() == "*Select an Answer*"
                || answerSelect2.getValue() == "*Select an Answer*" 
                || answerSelect3.getValue() == "*Select an Answer*"
                || answerSelect4.getValue() == "*Select an Answer*"
                || answerSelect5.getValue() == "*Select an Answer*") {
            quizDialogBox();
            while (DialogueController.validQuiz = false) {
                nameTextField.getText();
                if (nameTextField.getText().trim().isEmpty() == false) {
                    DialogueController.validQuiz = true;
                    return true;
                }
            }
        } else {
            DialogueController.validQuiz = true;
            return true;
        }
        return false;
    }

    // Method that creates a user with a unique ID
    private User createUser(House userHouse) {
        userList = UserList.grabUsers();
        boolean uniqueId = false;
        Random rand = new Random();
        int userId = rand.nextInt(10000) + 1;

        while (uniqueId == false) {
            int matches = 0;
            for (int i = 0; i < userList.users.size(); i++) {
                if (userId == userList.users.get(i).getId()) {
                    matches += 1;
                }
            }
            if (matches > 0) {
                userId = rand.nextInt(10000) + 1;
            } else {
                break;
            }
        }
        String userName;
        userName = nameTextField.getText();
        User user = new User(userId, userName, User.assignPet(userHouse), userHouse);
        return user;
    }

    // Method to calculate the results from the selected answers associated to
    // specific house, what ever answers associated to specific house
    // totaled the greatest, that house is assigned to the user.
    private House calculateHouse() {
        int[] housePoints = new int[4];
        House house;

        int tempPop = 0;

        if (answerSelect1.getValue() == answers1[0]) {
            housePoints[0] += 1;
        } else if (answerSelect1.getValue() == answers1[1]) {
            housePoints[1] += 1;
        } else if (answerSelect1.getValue() == answers1[2]) {
            housePoints[2] += 1;
        } else if (answerSelect1.getValue() == answers1[3]) {
            housePoints[3] += 1;
        }

        if (answerSelect2.getValue() == answers2[0]) {
            housePoints[0] += 1;
        } else if (answerSelect2.getValue() == answers2[1]) {
            housePoints[1] += 1;
        } else if (answerSelect2.getValue() == answers2[2]) {
            housePoints[2] += 1;
        } else if (answerSelect2.getValue() == answers2[3]) {
            housePoints[3] += 1;
        }

        if (answerSelect3.getValue() == answers3[0]) {
            housePoints[0] += 1;
        } else if (answerSelect3.getValue() == answers3[1]) {
            housePoints[1] += 1;
        } else if (answerSelect3.getValue() == answers3[2]) {
            housePoints[2] += 1;
        } else if (answerSelect3.getValue() == answers3[3]) {
            housePoints[3] += 1;
        }

        if (answerSelect4.getValue() == answers4[0]) {
            housePoints[0] += 1;
        } else if (answerSelect4.getValue() == answers4[1]) {
            housePoints[1] += 1;
        } else if (answerSelect4.getValue() == answers4[2]) {
            housePoints[2] += 1;
        } else if (answerSelect4.getValue() == answers4[3]) {
            housePoints[3] += 1;
        }

        if (answerSelect5.getValue() == answers5[0]) {
            housePoints[0] += 1;
        } else if (answerSelect5.getValue() == answers5[1]) {
            housePoints[1] += 1;
        } else if (answerSelect5.getValue() == answers5[2]) {
            housePoints[2] += 1;
        } else if (answerSelect5.getValue() == answers5[3]) {
            housePoints[3] += 1;
        }
        System.out.println(housePoints[0]);
        System.out.println(housePoints[1]);
        System.out.println(housePoints[2]);
        System.out.println(housePoints[3]);

        if (housePoints[0] == Questions.getLargestNumber(housePoints)) {
            tempPop = houseArray.houses[0].getPopulation();
            houseArray.houses[0].setPopulation(tempPop + 1);
            houseArray.write("houses.txt");
            House hufflepuff = new House("Hufflepuff", "Yellow & Black",
                    "Hufflepuff is known for having members that are patient, fair, hard-working, and sometimes blandly nice.",
                    houseArray.houses[0].getPopulation());
            return hufflepuff;
        } else if (housePoints[1] == Questions.getLargestNumber(housePoints)) {
            tempPop = houseArray.houses[1].getPopulation();
            houseArray.houses[1].setPopulation(tempPop + 1);
            houseArray.write("houses.txt");
            House slytherin = new House("Slytherin", "Green & Silver",
                    "Slytherins tend to be ambitious, shrewd, cunning, strong leaders, and achievement-oriented.",
                    houseArray.houses[1].getPopulation());
            return slytherin;
        } else if (housePoints[2] == Questions.getLargestNumber(housePoints)) {
            tempPop = houseArray.houses[2].getPopulation();
            houseArray.houses[2].setPopulation(tempPop + 1);
            houseArray.write("houses.txt");
            House gryffindor = new House("Gryffindor", "Red & Gold",
                    "Gryffindor is know to have the traits of courage as well as daring, nerve, and chivalry. Very Brave.",
                    houseArray.houses[2].getPopulation());
            return gryffindor;
        } else if (housePoints[3] == Questions.getLargestNumber(housePoints)) {
            tempPop = houseArray.houses[3].getPopulation();
            houseArray.houses[3].setPopulation(tempPop + 1);
            houseArray.write("houses.txt");
            House ravenclaw = new House("Ravenclaw", "Blue & Bronze",
                    "Ravenclaws possess the traits of cleverness, wisdom, wit, intellectual ability and creativity.",
                    houseArray.houses[3].getPopulation());
            return ravenclaw;
        } else {
            System.out.println("Error: Can't create a house.");
            return null;
        }
    }

    // Set questions to the index of the questions array.
    void initQuestions() {
        questionText1.setText(questionsArray[0].getPrompt());
        questionText2.setText(questionsArray[1].getPrompt());
        questionText3.setText(questionsArray[2].getPrompt());
        questionText4.setText(questionsArray[3].getPrompt());
        questionText5.setText(questionsArray[4].getPrompt());
    }

    // Method initializes the questions array with each question
    void initQuestionArray() {
        questionsArray[0] = new Questions(
                "You were about to begin school at Hogwarts, what type of core would your wand be?", answers1);
        questionsArray[1] = new Questions("Your friends decided to go to the Forbidden Forest, would you...", answers2);
        questionsArray[2] = new Questions("You received high marks in your class and your friend didn't ,would you...",
                answers3);
        questionsArray[3] = new Questions("When playing a game of chess...", answers4);
        questionsArray[4] = new Questions(
                "You're walking in the halls of hogwarts and someone in front of you drops an unopened box of Choclate Frogs...",
                answers5);
    }

    // Initialize the Quiz questions multiple choice drop down selection menu.
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        houseArray.loadHouse(houseArray);
        answerSelect1.setValue("*Select an Answer*");
        answerSelect1.setItems(FXCollections.observableArrayList("A) Phoenix Feather", "B) Badger fur",
                "C) Dragons scale", "D) Eagles feather"));
        answerSelect2.setValue("*Select an Answer*");
        answerSelect2.setItems(FXCollections.observableArrayList("A) Be up for the challenge, no question.",
                "B) Not sure about breaking the rules, but not willing to let your friends go alone.",
                "C) See it as an opportunity to report your friends to the head of house to get ahead.",
                "D) See this as a great learning opportunity."));
        answerSelect3.setValue("*Select an Answer*");
        answerSelect3.setItems(FXCollections.observableArrayList(
                "A) Be very proud of yourself and not mention it to your friend.",
                "B) Be happy for your marks, keep it to yourself and then help tutor your friend.",
                "C) Be very proud of yourself and let your friend know, as well as anyone else in earshot.",
                "D) Not surprised at all by your good marks, not mention it to friends and take on extra credit for fun."));
        answerSelect4.setValue("*Select an Answer*");
        answerSelect4.setItems(FXCollections.observableArrayList("A) You play with integrity and chivalry.",
                "B) You play with integrity and fairness.",
                "C) You play with cunning and always look for an opportunity to have the upper hand.",
                "D) You play with intelligence and creativity."));
        answerSelect5.setValue("*Select an Answer*");
        answerSelect5.setItems(FXCollections.observableArrayList("A) You pick up the box and hand it back.",
                "B) You pick up the box, hand it back and apologize for it happening.",
                "C) You pick up the box and slip it into your pocket to keep for yourself.",
                "D) You magically place the box back in the person’s pocket without them noticing."));
        initQuestionArray();
        initQuestions();
    }

}