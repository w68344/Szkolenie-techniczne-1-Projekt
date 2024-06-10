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
    public Button btnSendAnswer = new Button();
    //tworzenie logiki gry bez względu na czas
   //Inicjilizacja domyślnych zanaczeń dla default User
    public Label lblPunctsPlayer;
    public Label lblGameLevel;
    public Label userNameLbl;
    public void initialize(){
        lblPunctsPlayer.setText("Poprawno/Błędnie = 0/0");
        lblGameLevel.setText(String.valueOf(UserClass.getStatikUserLevel()));
        userNameLbl.setText(UserClass.defoltUser.getNameAndSurnameForGUIByStatikUser());
//        UserClass.userAnsverCorektVsUncorektStringOutprint();


    };

    //Funkcja przypisywania wartości podanej użytkownikem
    //Również funkcja rejurencyjnie sprawdza poprawność odpowiedzi
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
    //Ty dodałem funkcje blokowania wysyłania odpowidzi po ukończeniu działania stopera
    public void dtnSendAnswerAction(ActionEvent event) {
        if(timeSeconds != 0){
            Logika.setValuesFromUser(txtAnswer.getText());
            Logika.setValuesFromUserIntegerWithChek(txtAnswer.getText());
            System.out.println(Logika.getValuesFromUserIntegerWithChek());
            txtAnswer.clear();
            chekAktion();
            lblPunctsPlayer.setText(UserClass.userAnsverCorektVsUncorektStringOutprint(Logika.functionCheckTaskBolean()));
            lblTask.setText(Logika.generatotTasksString());}
        else {btnSendAnswer.setText("Koniec");
        btnStartGame.setText("Restart");
        lblTask.setText("");
        lblTimer.setText("");}

    }
    //Kilka funkcji dla timera zrobionego jako animacja
    //временный лимит для быстрейшей розработки
    int timeSeconds = 10;
    Timeline timeline;
    public void initialized() {
        lblTimer.setText(formatTime(timeSeconds));

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1), event -> {
                    timeSeconds--;
                    lblTimer.setText(formatTime(timeSeconds));

                    if (timeSeconds <= 0) {
                        timeline.stop();
                    }
                })
        );
        timeline.playFromStart();
    }
    public void timerStart (){initialized();
    }
    @FXML
    public void stopTimer() {
        timeSeconds = 1;
        lblTimer.setText("");
//

    }
    public String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }
    //Pocątek gry za pomocą przycisku
    public void startTheGame(ActionEvent event) {
        btnStartGame.setText("Start Game");
        btnSendAnswer.setText("Zapisz");
        //start timera
        //временный лимит для быстрейшей розработки
        timeSeconds = 10;
        timerStart();
        Logika.createColectionRangeForFirstAndSekondNumberRandom();
        Logika.generatotTasksString();
        lblTask.setText(Logika.generatotTasksString());
    }
   //Przedterminowy koniec gry
    public void stopGame(ActionEvent event) {
        btnStartGame.setText("Restart");
        stopTimer();
        lblTask.setText("");
        lblTimer.setText("");
        imgMem.setImage(new Image("logo300300Lipng.png"));
        txtAnswer.clear();
        lblPunctsPlayer.setText(UserClass.resetCountrOfPointsWithPrint());
//        lblPunctsPlayer.setText("Poprawno/Błędnie = 0/0");

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
        imgMem.setImage(new Image("logo300300pngdef.png"));

    }
    //Funkcja w górnym meni do tworzenia nowega okna do tworzenia nowego użytkownika
    public void createNewWindowForCreateNewUserMenuBtn(ActionEvent event) throws IOException {
        CreateNewUserWindowController.start();
    }

    public void menuItemInfoUserNewWindow(ActionEvent event) throws IOException {
        InfoUserWindowController.start();
    }
}
