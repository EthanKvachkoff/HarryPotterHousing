// Class Main, C211 Group Project, Spring 2023
// Authors: Catlin Kramka/Zach Butler/Ethan Kvachkoff

package application;

import java.io.File;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            File file = new File("houses.txt");
            if (!file.exists()) {
                file.createNewFile();
                if (file.length() == 0) {
                    House.createHouses("houses.txt");
                }
            }
            File userFile = new File("users.txt");
            if (!userFile.exists()) {
                userFile.createNewFile();
            }   
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
            Scene scene = new Scene(root, 750, 500);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Harry Potter Housing Quiz");
            primaryStage.setScene(scene);
            primaryStage.show();   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
