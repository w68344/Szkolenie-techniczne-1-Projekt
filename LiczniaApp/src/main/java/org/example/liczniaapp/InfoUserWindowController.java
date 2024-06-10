package org.example.liczniaapp;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoUserWindowController {
    //funkcja generacji nowego okna

    public static void start() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("InfoUserWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stage.getIcons().add(new Image("logo300300Lipng.png"));
        stage.setTitle("Info User");
        stage.setScene(scene);
        stage.show();
    }

    //Główne dyamiczne objekty w oknie
    public Label lblNameInfoUser;
    public Label lblSurnameInfoUser;
    public Label lblLevelInfoUser;
    //funkcja i inicjalizacji wartości
    public void initialize() {
        lblNameInfoUser.setText(UserClass.getStatikUserName());
        lblSurnameInfoUser.setText(UserClass.getStatikUserSurname());
        lblLevelInfoUser.setText(String.valueOf(UserClass.getStatikUserLevel()));
    }


    public void closeInfoUserWindow(ActionEvent event) {

    }
}
