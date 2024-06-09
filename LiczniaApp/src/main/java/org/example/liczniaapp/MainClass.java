package org.example.liczniaapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.regex.Pattern;

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

    public static void main(String[] args) throws InterruptedException {
        launch();

//        Runnable timerProcess = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Process1");
//                TimerClass Timer = new TimerClass();
//                try {
//                    Timer.startTimera(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//        Runnable logikaProcess = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Process2");
//                TimerClass Timer = new TimerClass();
//
//                while(Timer.getisTimerAktiveNow()==Boolean.TRUE){
//                    System.out.println("Ok");
//                }
//            }
//        };
//        Thread timerThresd = new Thread(timerProcess);
//        Thread logikaThread = new Thread(logikaProcess);
//        timerThresd.start();
//        logikaThread.start();



//        MathLogicClass Logika = new MathLogicClass();
//        Logika.createColectionRangeForFirstAndSekondNumberRandom();
//        Logika.generatotTasksString();
//        Logika.getValuesFromUser();
//        Logika.functionCheckTaskBolean();
//
//        System.exit(0);


    }

}