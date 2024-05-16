package org.example.liczniaapp;

import com.sun.jdi.DoubleValue;

import java.lang.constant.ConstantDesc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator;

public class MathLogicClass {
    //Tworzenie dwóch zbiorów z których bandą kombinowane zdania
    //Zrobiłem to w taki sposób żeby można było w jakikolwiek moment czasu zmienić zakres dopuszczalnych liczb
    private ArrayList<Integer> colectionRangeFirstNumberRandom = new ArrayList<>(10);
    private ArrayList<Integer> colectionRangeSecondNumberRandom = new ArrayList<>(10);

    //Główne zmienne które będą tworzycz parametry skomplikowaności zdań
    private Integer numberForAllTable;
    private Integer numberLowerForNumber = 1;
    private Integer numberUperForNumber = 9;

    //Getery oraz setery dla prywatnych wartości
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
        }
        else {
            System.out.println("No implement for that system of numbers");
        }
       Collections.shuffle(colectionRangeSecondNumberRandom);
//        System.out.println(colectionRangeSecondNumberRandom);
    }

    //Wypeniliśmy już 2 listy z liczbami losowymi z podanego zakresu
    //Teraz tworze generator pierwszej liczby
    public String generatotTasks(){
        Integer liczba1 = 0;
        if(colectionRangeFirstNumberRandom.size()>1){
            liczba1 = colectionRangeFirstNumberRandom.getFirst();
            colectionRangeFirstNumberRandom.removeFirst();
        }
        else if (colectionRangeFirstNumberRandom.size()==1) {
            liczba1 = colectionRangeFirstNumberRandom.getFirst();
            createColectionRangeFirstNumberRandom();
        }
        else if (colectionRangeFirstNumberRandom.isEmpty()) {
            createColectionRangeFirstNumberRandom();}
        Integer liczba2 = 0;
        if(!colectionRangeSecondNumberRandom.isEmpty()){
            liczba2 = colectionRangeSecondNumberRandom.getFirst();
            colectionRangeSecondNumberRandom.removeFirst();
        }
        else{createColectionRangeSecondNumberRandom(Boolean.TRUE);}

        String zadanie = liczba1+" * "+ liczba2;
        System.out.println(zadanie);
        return zadanie;
    }




}

