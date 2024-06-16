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
    private static Stage stageNewUser = new Stage();
    public static void start() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("CreateNewUserWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stageNewUser.getIcons().add(new Image("logo300300Lipng.png"));
        stageNewUser.setTitle("CreateUser");
        stageNewUser.setScene(scene);
        stageNewUser.show();
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
        UserClass UserAdd = new UserClass(textAreaSetNameFromNewUser.getText(), textAreaSetSurnameFromNewUser.getText(),null);
        if (UserAdd.takeNewUserToListWithChek(UserAdd) == Boolean.TRUE) {
            writeDataToListBtn.setText("Dodano uzytkownika");
            DataBaseSQLite.addUser(UserAdd.getNameOfUser(),UserAdd.getSurnameOfUser(),UserAdd.getLevelOfUser());
        }
        else {writeDataToListBtn.setText("Nie powiodło");}

    }

    public void closeWindow(ActionEvent event) {
        addNewUserForListBtn(event);
        stageNewUser.close();
    }
}
