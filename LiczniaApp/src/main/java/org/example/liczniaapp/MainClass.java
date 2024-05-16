package org.example.liczniaapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stage.getIcons().add(new Image("logo300300Lipng.png"));
        stage.setTitle("LiczniaApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        launch();
        MathLogicClass Logika = new MathLogicClass();
        Logika.createColectionRangeFirstNumberRandom();
        Logika.createColectionRangeSecondNumberRandom(Boolean.TRUE);
        Logika.generatotTasks();

        System.exit(0);


    }
}