package org.example.liczniaapp;
//Claksa użytkownika
public class UserClass {
    //Główne parametry użytkownika Imie Nazwisko Poziom w grze
    private String nameOfUser;
    private String surnameOfUser;
    private Integer levelOfUser;
//Getery i setery do odpowiednich parametrów uzytkownika
    public Integer getLevelOfUser() {
        return levelOfUser;
    }
    public String getNameOfUser() {
        return nameOfUser;
    }
    public String getSurnameOfUser() {
        return surnameOfUser;
    }
    public void setLevelOfUser(Integer levelOfUser) {
        this.levelOfUser = levelOfUser;
    }
    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }
    public void setSurnameOfUser(String surnameOfUser) {
        this.surnameOfUser = surnameOfUser;
    }
}
