package org.example.liczniaapp;


import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TimerClass {
private Integer timeForTimer = 10000;
private Boolean isTimerAktiveNow = Boolean.FALSE;
//Getery i setery dla czasu funkcji;
    public Integer settimeForTimerString(String StringTimeForTimer){
        timeForTimer = Integer.parseInt(StringTimeForTimer);
        return timeForTimer;
    }
    public Integer getTimeForTimer() {
        return timeForTimer;
    }

    public void setisTimerAktiveNow(Boolean isTimerAktiveNow) {
        isTimerAktiveNow = isTimerAktiveNow;
    }

    public Boolean getisTimerAktiveNow() {
        return isTimerAktiveNow;
    }

    //Fukcja pocátku timera
    public void startTimera(Integer timerStartOnlyFotFunktion) throws InterruptedException {
        setisTimerAktiveNow(Boolean.TRUE);
        java.util.Date datestart = new java.util.Date();
        System.out.println("Timer start at: " + datestart);
        timerStartOnlyFotFunktion = getTimeForTimer();
        Thread.sleep(timerStartOnlyFotFunktion);
        setisTimerAktiveNow(Boolean.FALSE);
        java.util.Date dateend = new java.util.Date();
        System.out.println("Timer end at: " + dateend);


    }
}
