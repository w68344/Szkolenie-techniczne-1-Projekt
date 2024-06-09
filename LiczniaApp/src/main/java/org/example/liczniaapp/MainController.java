package org.example.liczniaapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class MainController {
    //Tworzenia odpowiednich zmiennych zwądzanych z objektami GUI (grafic user interfejse)
    @FXML
    public Label lblTask;
    public Label lblTimer;
    public TextField txtAnswer;
    public Button btnStartGame;
    public Button btnStopGame;
    public MenuItem menubarSaveAndClose;
    public Boolean isGameAlreadyStart = Boolean.FALSE;
    public MathLogicClass Logika = new MathLogicClass();
    public ImageView imgMem = new ImageView();
    //tworzenie logiki gry bez względu na czas
    //Funkcja przypisywania wartości podanej użytkownikem
    //Również funkcja rejurencyjnie sprawdza poprawność odpowiedzi
    public void dtnSendAnswerAction(ActionEvent event) {
        Logika.setValuesFromUser(txtAnswer.getText());
        Logika.setValuesFromUserIntegerWithChek(txtAnswer.getText());
        System.out.println(Logika.getValuesFromUserIntegerWithChek());
        txtAnswer.clear();
        chekAktion();
        lblTask.setText(Logika.generatotTasksString());
    }
    public void startTheGame(ActionEvent event) {
        Logika.createColectionRangeForFirstAndSekondNumberRandom();
        Logika.generatotTasksString();
        lblTask.setText(Logika.generatotTasksString());
    }
    public void chekAktion ()
    {
        System.out.println("Test logiczny: "+Logika.functionCheckTaskBolean());
        if(Logika.functionCheckTaskBolean() == Boolean.TRUE)
        {
            imgMem.setImage(new Image("noAnsr.jpg"));
        }
        else {
            imgMem.setImage(new Image("okAnsr.jpg"));
        }
    }
    public void stopGame(ActionEvent event) {
        lblTask.setText("");
        lblTimer.setText("");
        imgMem.setImage(new Image("logo300300Lipng.png"));
        txtAnswer.clear();
    }



    //Fukcja do zapisywania dannych do baz dannych oraz zamknięcie aplikacji
    @FXML
    public void saveAndClose() {
        System.exit(0);
    }
    //Funkcja otwierania nowego okna
    @FXML
    public void openInfoStage(ActionEvent event) throws IOException {
        InfoWindowController.start();
    }

    //Funkcja otwierania meni z ustawieniami pożioma gry
    public void openLevelSettingsWindow(ActionEvent event) throws IOException {
        LevelSettingsWindowController.start();
    }
    //Fukcja w górnym meni dla resetowania ustawień gry na domyślne
    public void setDefoltValuesForGeneratingTesks(ActionEvent event) {
        Logika.setDefoltValuesForTaskGenerator();

    }
}
