package org.example.liczniaapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateNewUserWindowController {
    //Tworzenie nowego okna dla wpisywania i validacji dannych nowego użytkownika
    public static void start() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("CreateNewUserWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stage.getIcons().add(new Image("logo300300Lipng.png"));
        stage.setTitle("CreateUser");
        stage.setScene(scene);
        stage.show();
    }
    //Tworzenie objektów GUI
    @FXML
    public TextField textAreaSetNameFromNewUser = new TextField();
    @FXML
    public TextField textAreaSetSurnameFromNewUser = new TextField();
    @FXML
    public Button writeDataToListBtn = new Button();


    //Tworzenie objekta z klasy UserClass dla podalszych operacji
    public void addNewUserForListBtn(ActionEvent event) {
        UserClass User = new UserClass(textAreaSetNameFromNewUser.getText(), textAreaSetSurnameFromNewUser.getText(),null);
        if (User.takeNewUserToListWithChek(User) == Boolean.TRUE) {
            writeDataToListBtn.setText("Powodzenie");
        }
        else {writeDataToListBtn.setText("Nie powiodło się");}

    }

}
