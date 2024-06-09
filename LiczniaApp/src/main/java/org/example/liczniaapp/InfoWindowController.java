package org.example.liczniaapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoWindowController {
    //Otwiranie nowego okna
    @FXML
    Button closeBtnInfoWindow = new Button();
    public static void start() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("InfoWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stage.getIcons().add(new Image("logo300300Lipng.png"));
        stage.setTitle("LiczniaApp");
        stage.setScene(scene);
        stage.show();
    }
//Zamykanie aplekacji
    public void Close(ActionEvent event) {
        System.exit(0);
    }
}

