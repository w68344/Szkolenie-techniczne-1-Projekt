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
    public static Stage stage2 = new Stage();
    public static void start() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("InfoWindow.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load(), 850, 750);
        stage2.getIcons().add(new Image("logo300300Lipng.png"));
        stage2.setTitle("Info about Licznia App");
        stage2.setScene(scene2);
        stage2.show();
    }
//Zamykanie okna
    public void Close(ActionEvent event) {
        stage2.close();

    }
}

