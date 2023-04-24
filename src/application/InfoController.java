// Class InfoController, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    
    UserList userList = new UserList();
    
    public static User tempUser;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        showUserInfo();
    }
    
    public void showUserInfo() {
        if (tempUser != null) {
            infoText.appendText("Id: "+ tempUser.getId() + "\n");
            infoText.appendText("Name: "+ tempUser.getName() + "\n");
            infoText.appendText("House: "+ tempUser.getHouse().getName() + "\n");
            infoText.appendText("Pet: "+ tempUser.getPet() + "\n");
        } else {
            infoText.appendText("Id: " + "\n");
            infoText.appendText("Name: " + "\n");
            infoText.appendText("House: " + "\n");
            infoText.appendText("Pet: " + "\n");
        }
        
        //userList = UserList.grabUsers();  
        //System.out.println(userList.users.get(0).getName() + " " + userList.users.get(0).getId()+ " " + userList.users.get(0).getHouse().getName()+ " " + userList.users.get(0).getPet());
    }
}
