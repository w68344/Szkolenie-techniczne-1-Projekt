package org.example.liczniaapp;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathLogicClass {
    //Tworzenie dwóch zbiorów z których bandą kombinowane zdania
    //Zrobiłem to w taki sposób żeby można było w jakikolwiek moment czasu zmienić zakres dopuszczalnych liczb
    private ArrayList<Integer> colectionRangeFirstNumberRandom = new ArrayList<>(10);
    private ArrayList<Integer> colectionRangeSecondNumberRandom = new ArrayList<>(10);

    //Główne zmienne które będą tworzycz parametry skomplikowaności zdań
    private Integer numberForAllTable;
    private Integer numberLowerForNumber = 1;
    private Integer numberUperForNumber = 9;
    private String taskString;
    private String valuesFromUser;
    private Integer valuesFromUserIntegerWithChek;

    //Getery oraz setery dla prywatnych wartości

    public void setValuesFromUser(String valuesFromUser) {
        this.valuesFromUser = valuesFromUser;
    }

    public Integer getValuesFromUserIntegerWithChek() {
        return valuesFromUserIntegerWithChek;
    }
    public Integer setValuesFromUserIntegerWithOutChek(){
        this.valuesFromUserIntegerWithChek = Integer.parseInt(getVirableValuesFromUser());
        return valuesFromUserIntegerWithChek;
    }
    //Funkcja sprawdzająca poprawność wpisywania dannych użytkownikem oraz convertująca string do Integera
    public Integer setValuesFromUserIntegerWithChek(String valueFromUserString){

        Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
        Matcher matcher = pattern.matcher(valueFromUserString);
        if (valueFromUserString.length()>3){
            System.out.println("Za długa odpowiedż");
            return valuesFromUserIntegerWithChek = 0;
        }
        else if (matcher.matches()){
            System.out.println("W odpowiedzi odnalezono litery, muszą być tylko liczby.");
            return valuesFromUserIntegerWithChek = 0;
        }
        return valuesFromUserIntegerWithChek = Integer.parseInt(getVirableValuesFromUser());
    }

    public String getTaskString() {return taskString;}
    public String getVirableValuesFromUser(){return valuesFromUser;}
    public Integer getnumberForAllTable() {
        return this.numberForAllTable;
    }

    public Integer setnumberForAllTable(Integer NumberForAllTable) {
        this.numberForAllTable = NumberForAllTable;
        return this.numberForAllTable;
    }

    public Integer getnumberLowerForNumber() {
        return this.numberLowerForNumber;
    }

    public Integer setnumberLowerForNumber(Integer NumberLowerForNumber) {
        this.numberLowerForNumber = NumberLowerForNumber;
        return this.numberLowerForNumber;
    }

    public Integer getnumberUperForNumber() {
        return this.numberUperForNumber;
    }

    public Integer setnumberUperForNumber(Integer NumberUperForNumber) {
        this.numberUperForNumber = NumberUperForNumber;
        return this.numberUperForNumber;
    }

    //Tworzenie funkcji wypełnenia i losowania pierwszej listy liczb dla podalszego tworzenia zadań
    public void createColectionRangeFirstNumberRandom() {
        if (numberForAllTable == null) {
            for (int i = getnumberLowerForNumber(); i <= getnumberUperForNumber(); i++) {
                colectionRangeFirstNumberRandom.add(i);
            }
        } else {
            colectionRangeFirstNumberRandom.add(getnumberForAllTable());
        }
        Collections.shuffle(colectionRangeFirstNumberRandom);
//        System.out.println(colectionRangeFirstNumberRandom);
    }

    //Tworzenie funkcji wypełnenia i losowania drugiej listy liczb dla podalszego tworzenia zadań
    public void createColectionRangeSecondNumberRandom(Boolean ifTabeleAreNormal) {
        if (ifTabeleAreNormal == Boolean.TRUE) {
            for (int i = 1; i < 10; i++) {
                colectionRangeSecondNumberRandom.add(i);
            }
        } else {
            System.out.println("No implement for that system of numbers");
        }
        Collections.shuffle(colectionRangeSecondNumberRandom);
//        System.out.println(colectionRangeSecondNumberRandom);
    }

    public void createColectionRangeForFirstAndSekondNumberRandom() {
        createColectionRangeFirstNumberRandom();
        createColectionRangeSecondNumberRandom(Boolean.TRUE);
    }

    //Wypeniliśmy już 2 listy z liczbami losowymi z podanego zakresu
    //Teraz tworze generator zadania
    public String generatotTasksString() {
        Integer liczba1 = 0;
        if (colectionRangeFirstNumberRandom.size() > 1) {
            liczba1 = colectionRangeFirstNumberRandom.getFirst();
            colectionRangeFirstNumberRandom.removeFirst();
        } else if (colectionRangeFirstNumberRandom.size() == 1) {
            liczba1 = colectionRangeFirstNumberRandom.getFirst();
            createColectionRangeFirstNumberRandom();
        }
        Integer liczba2 = 0;
        if (!colectionRangeSecondNumberRandom.isEmpty()) {
            liczba2 = colectionRangeSecondNumberRandom.getFirst();
            colectionRangeSecondNumberRandom.removeFirst();
        } else {
            createColectionRangeSecondNumberRandom(Boolean.TRUE);
        }

        taskString = liczba1 + " * " + liczba2;
        System.out.println("Zadanie: "+ taskString);
        return taskString;
    }

    //Fukcja dla odczytu wartości od uzytkownika

    public String getValuesFromUser ()
    {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj odpoviedż: ");
        setValuesFromUser(scaner.next());
        setValuesFromUserIntegerWithChek(getVirableValuesFromUser());
//        System.out.println("Odpowiedż podana użytkownikem: " + valuesFromUser);


       return valuesFromUser ;
    }

    //Funkcja sprawdzajáca czy podana odpowied od uzytkownika jest prawidwoła
    public Boolean functionCheckTaskBolean() {
        Boolean resultOfTesting = Boolean.FALSE;
        Integer ansverFromUser = getValuesFromUserIntegerWithChek();
        String strNumber1 = String.valueOf(getTaskString().charAt(0));
        Integer number1 = Integer.parseInt(strNumber1);
        String strNumber2 = String.valueOf(getTaskString().charAt(4));
        Integer number2 = Integer.parseInt(strNumber2);
        System.out.println("Liczba 1: "+number1+"; Liczba 2: "+number2+"; Odpoviedż: " + ansverFromUser);
        Integer resultOfMultiplication = number1*number2;
        System.out.println("ResultOfMultiplication: "+resultOfMultiplication);
        if (resultOfMultiplication == ansverFromUser){
            resultOfTesting = Boolean.TRUE;}
        System.out.println("ResultOfTesting: " + resultOfTesting);
        return resultOfTesting;
    }


}

