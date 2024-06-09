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
    //tworzenie logiki gry bez względu na czas
    //Funkcja przypisywania wartości podanej użytkownikem
    public void dtnSendAnswerAction(ActionEvent event) {
        Logika.setValuesFromUser(txtAnswer.getText());
        Logika.setValuesFromUserIntegerWithChek(txtAnswer.getText());
        System.out.println(Logika.getValuesFromUserIntegerWithChek());
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

    public void startTheGame(ActionEvent event) {
    }

    public void stopGame(ActionEvent event) {
    }


}
