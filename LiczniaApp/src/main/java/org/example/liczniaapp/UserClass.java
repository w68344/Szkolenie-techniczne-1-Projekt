package org.example.liczniaapp;

import java.util.ArrayList;
import java.util.Objects;

//Claksa użytkownika
public class UserClass {
    //Główne parametry użytkownika Imie Nazwisko Poziom w grze
    private String nameOfUser;
    private String surnameOfUser;
    private Integer levelOfUser;
    private ArrayList<UserClass> listAllUsers = new ArrayList<UserClass>();
    //Domyślni stworzony użytkownik istnieje poza listą innych użytkowników
   public static UserClass defoltUser = new UserClass("Nikita","Riabchii",null);
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
    //Construktor dla Clasy UserClass
    public UserClass(String Name,String Surname, Integer LevelOfUser){
        //Parametr Level może byc podany do funkcji jako null w takim razie będzie ustawiony na 0 odmyślnie
        if (Objects.equals(Name, "")){setNameOfUser("Defult Name "+ String.valueOf(listAllUsers.size()));
        System.out.println("Nie wolno podawać puste danne");}
        else {setNameOfUser(Name);}
        if (Objects.equals(Surname, "")){setSurnameOfUser("Defult Surname "+ String.valueOf(listAllUsers.size()));
            System.out.println("Nie wolno podawać puste danne");}
        else {setSurnameOfUser(Surname);}


        if (LevelOfUser == null){setLevelOfUser(0);}
        else {setLevelOfUser(LevelOfUser);}
        System.out.println("Zostały podane takie danne do construktora Użytkownika: "+ getNameOfUser()+" "+getSurnameOfUser()+" "+getLevelOfUser());
    }


    //Funkcja dodania użytkownika do listy z warunkem validacyjnym
    //Zwraca wartość typu Bolean jako podtwirdzenie poprawności działania

    public Boolean takeNewUserToListWithChek (UserClass User)
    {   Integer siezeOfListBeforeOperation = listAllUsers.size();
        listAllUsers.add(User);
        Integer siezeOfListAfterOperation = listAllUsers.size();
        if(siezeOfListBeforeOperation>=siezeOfListAfterOperation){
            System.out.println("Dodanie nowego użytkownika do listy nie powiodło się.");
            System.out.println("Liczba uzytkowników do: "+siezeOfListBeforeOperation);
            System.out.println("Liczba użytkowników po: "+siezeOfListAfterOperation);
            return Boolean.FALSE;
        }
        else {System.out.println("Powodzenie, nowy użytkownik został dodany.");
        return Boolean.TRUE;
        }

    }
}
