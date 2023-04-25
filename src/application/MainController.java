// Class MainController, C211 Group Project, Spring 2023
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainController implements Initializable{
    
    @FXML
    private Button houseInfoButton;
    
    @FXML
    private Button startQuizButton;
    
    @FXML
    private TextArea aboutTextArea;
    
    @FXML
    private Button findUserById;
    
    @FXML
    private TextField searchId;
    
    UserList userList = new UserList();
    
    @FXML
    private Label errorLabel;
    
    @FXML
    private ListView<String> houseName;
    
    String[] house = { "Gryffindor" , "Hufflepuff", "Slytherin", "Ravenclaw" };
    
    HouseArray houseArray = new HouseArray(4);
    
    @FXML
    void handleInfoButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InfoBox.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("House Information");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    } 
    
    @FXML
    void handleQuizButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuizWindow.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("House Quiz");
            stage.setScene(new Scene(root2, 750, 900));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    } 
    
    @FXML
    void findUser(ActionEvent event) {
        try {
            if (searchId.getText() != null) {
                int id = Integer.parseInt(searchId.getText());
                userList = UserList.grabUsers();
                for (int i = 0; i < userList.users.size(); i++) {
                    if (id == userList.users.get(i).getId()) {
                        User user = userList.findUser(id);
                        InfoController.tempUser = user;
                        System.out.println("User Found");
                        SearchController.validInput = true;
                        SearchController.userId = id;
                        idDialogBox();
                        break;
                    }
                }
                SearchController.isIdError = true;
                if (SearchController.validInput != true) {
                    idDialogBox();
                }
                System.out.println("User Not Found");
            } else {
                SearchController.isIdError = true;
                idDialogBox();
                System.out.println("User Not Found");
            }  
        } catch (NumberFormatException e) {
            SearchController.isIdError = true;
            idDialogBox();
            System.out.println("The string is not a number");
        }
    }
    
    public void idDialogBox() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IdSearch.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("ID:");
            stage.setScene(new Scene(root2, 280, 125));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        } 
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        aboutTextArea.appendText("Welcome to the Harry Potter House Quiz! \n");
        aboutTextArea.appendText("After taking the quiz, based on your answers you will be sorted into a Hogwarts house.\n");
        aboutTextArea.appendText("To begin click the 'Start Quiz' button.\n");
        aboutTextArea.appendText("To access house information click the 'House Information' button.\n");
        houseArray.loadHouse(houseArray);
        houseArray.read("houses.txt");
        house[0] = house[0] +"           " + houseArray.houses[0].getPopulation();
        house[1] = house[1] +"           " + houseArray.houses[1].getPopulation();
        house[2] = house[2] +"             " + houseArray.houses[2].getPopulation();
        house[3] = house[3] +"          " + houseArray.houses[3].getPopulation();
        houseName.getItems().addAll(house);
    }

}
