package org.example.liczniaapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelSettingsWindowController {
    //Tworzenie objektów GUI (grafic user interfejs)
    @FXML
    public TextField textAreaFrom = new TextField();
    public TextField textAreaTo = new TextField();
    public TextField textAreaNumber2 = new TextField();
    public Button updateValuesBtnLevelSettingsWindow = new Button();
    MathLogicClass Logika = new MathLogicClass();
    //Funkcja inicjacji okna z ustawieniami gry
    public static void start() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource("LevelSettingsWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 750);
        stage.getIcons().add(new Image("logo300300Lipng.png"));
        stage.setTitle("Lewel settings in LiczniaApp");
        stage.setScene(scene);
        stage.show();
    }
    //Funkcja wpisująca domyślne lub obecne wartości w ustawieniach gry
    public void loadDefoltValues(){
        textAreaFrom.setText(String.valueOf(Logika.getnumberLowerForNumber()));
        textAreaTo.setText(String.valueOf(Logika.getnumberUperForNumber()));
        textAreaNumber2.setText("Domyśłne od 0 do 9");
    }


    public void updateValuesFunkctionLevelSettingsWindow(ActionEvent event) throws InterruptedException {
        //Metoda obpracovania wyjátków realizowana ręcznie poza seterem clasy MathLogikClass wiem że można użycz innych metod ale ja chcę widzieć jak działa validacja
        //Viem że dla takiego można było by założyć osobny Interfejs, ale ze względu na nie wilki rozmiar aplikacji zrezygnowałem z tej myśli
        String numberFrom_TextAreaFrom = textAreaFrom.getText();
        Integer numberFrom_TextAreaFrom_Integer;
        try {
            numberFrom_TextAreaFrom_Integer = Integer.parseInt(numberFrom_TextAreaFrom);
        }
        catch (Exception e){
            System.out.println("Wypadł wyjątek w: public void updateValuesFunkctionLevelSettingsWindow w numberFrom_TextAreaFrom_Integer");
            numberFrom_TextAreaFrom_Integer = 0;
        }
        String numberFrom_TextAreaTo = textAreaTo.getText();
        Integer numberFrom_TextAreaTo_Integer;
        try {
            numberFrom_TextAreaTo_Integer = Integer.parseInt(numberFrom_TextAreaTo);
        }
        catch (Exception e) {
            System.out.println("Wypadł wyjątek w: public void updateValuesFunkctionLevelSettingsWindow w numberFrom_TextAreaTo_Integer");
            numberFrom_TextAreaTo_Integer = 0;
        }
        String numberFrom_textAreaNumber2 = textAreaNumber2.getText();
        Integer numberFrom_textAreaNumber2_Integer;
        try {
            numberFrom_textAreaNumber2_Integer = Integer.parseInt(numberFrom_textAreaNumber2);
        }
        catch (Exception e) {
            System.out.println("Wypadł wyjątek w: public void updateValuesFunkctionLevelSettingsWindow w numberFrom_textAreaNumber2_Integer");
            numberFrom_textAreaNumber2_Integer = null;
        }
        //Ustawienie wartósci do zmiennych wewnátrz klasy
        Logika.setnumberLowerForNumber(numberFrom_TextAreaFrom_Integer);
        Logika.setnumberUperForNumber(numberFrom_TextAreaTo_Integer);
        Logika.setnumberForAllTable(numberFrom_textAreaNumber2_Integer);
        System.out.println("Logika.getnumberLowerForNumber(): "+Logika.getnumberLowerForNumber());
        System.out.println("Logika.getnumberUperForNumber(): "+Logika.getnumberUperForNumber());
        System.out.println("Logika.getnumberForAllTable(): "+Logika.getnumberForAllTable());
        updateValuesBtnLevelSettingsWindow.setText("Zapisano");
    }


}
