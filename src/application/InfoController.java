// Class InfoController, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff
package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class InfoController implements Initializable {

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
            infoText.appendText("Id: " + tempUser.getId() + "\n");
            infoText.appendText("Name: " + tempUser.getName() + "\n");
            infoText.appendText("House: " + tempUser.getHouse().getName() + "\n");
            infoText.appendText("Pet: " + tempUser.getPet() + "\n");
        } else {
            infoText.appendText("Id: " + "\n");
            infoText.appendText("Name: " + "\n");
            infoText.appendText("House: " + "\n");
            infoText.appendText("Pet: " + "\n");
        }
    }
}
