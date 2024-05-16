package org.example.liczniaapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import javax.swing.text.StyledEditorKit;
import java.util.Scanner;

public class MainController {
    //Tworzenia odpowiednich zmiennych zwądzanych z objektami GUI (grafic user interfejse)
    @FXML
    public Label lblTask;
    public Button btnStartGame;
    public MenuItem menubarSaveAndClose;
    public TextField txtAnswer;
    public Label lblTimer;
    //Tworzenia binarnej zmiennej która wskazuje na to czy zacąto już gre czy nie;
    public Boolean isGameAlreadyStart = Boolean.FALSE;
    //Funkcja działania gry z innymi wtycznymi
    public void startTheGame(){
        //Gra aktywna
        if (isGameAlreadyStart == Boolean.FALSE){
            //Zmiana interfejsu po aktywacji gry
            btnStartGame.setText("Stop");
            isGameAlreadyStart = Boolean.TRUE;

            String answerFromUserOnse = txtAnswer.getText();
            MathLogicClass Logika = new MathLogicClass();
            Logika.createColectionRangeForFirstAndSekondNumberRandom();
            String taskOnlyForFunction = Logika.generatotTasksString();
            lblTask.setText(taskOnlyForFunction);
            lblTimer.setText(""+Logika.functionCheckTaskBolean(taskOnlyForFunction,answerFromUserOnse));
        }
        //Gra nie aktywna oraz zapisywanie dannych
        else {
            lblTask.setText("Tu pojawi zadanie");
            btnStartGame.setText("Start");
            isGameAlreadyStart = Boolean.FALSE;
        }

    }

    public void saveAndClose (){System.exit(0);}


}
