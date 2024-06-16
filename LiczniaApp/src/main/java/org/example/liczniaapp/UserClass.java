package org.example.liczniaapp;

import java.util.ArrayList;
import java.util.Objects;

//Claksa użytkownika
public class UserClass {

    //Główne parametry użytkownika Imie Nazwisko Poziom w grze
    private String nameOfUser;
    private String surnameOfUser;
    private Integer levelOfUser;
    //Nie doawałem bazy dannych do projektu jeście dla tego zbuduje ręcznie system zapisywania i inicjilizacji Użytkowników
    private ArrayList<UserClass> listAllUsers = new ArrayList<UserClass>();
    //Domyślni stworzony użytkownik istnieje poza listą innych użytkowników
    public static final UserClass defoltUser = new UserClass("Nikita", "Riabchii", null);
    //Głowny statyczny parametr do którego będzie odwzorywać fukcje w tej klsasie
    private static UserClass statikUser = new UserClass(defoltUser.getNameOfUser(), defoltUser.getSurnameOfUser(), defoltUser.getLevelOfUser());
    //Podobne metody do tego co mamy w użytkowniku tylko dla użytkownika statycznego

    public static String getStatikUserName() {
        return statikUser.getNameOfUser();
    }

    public static String setStatikUserName(String Name) {
        statikUser.setNameOfUser(Name);
        return statikUser.getStatikUserName();
    }

    public static String getStatikUserSurname() {
        return statikUser.getSurnameOfUser();
    }

    public static String setStatikUserSurname(String Surname) {
        statikUser.setSurnameOfUser(Surname);
        return getStatikUserSurname();
    }

    public static Integer getStatikUserLevel() {
        return defoltUser.getLevelOfUser();
    }

    public static Integer setStatikUserSurname(Integer LevelInt, String LevelStr) {
        if (Objects.equals(LevelStr, "")) {
            defoltUser.setLevelOfUser(LevelInt);
        } else {
            try {
                defoltUser.setLevelOfUser(Integer.parseInt(LevelStr));
            } catch (Exception e) {
                System.out.println("Niestety level of User nie jest liczbą i zostanie zamieniony na (0)");
                defoltUser.setLevelOfUser(0);
            }
        }
        return getStatikUserLevel();
    }


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
    public UserClass(String Name, String Surname, Integer LevelOfUser) {
        //Parametr Level może byc podany do funkcji jako null w takim razie będzie ustawiony na 0 odmyślnie
        if (Objects.equals(Name, "")) {
            setNameOfUser("Defult Name " + String.valueOf(listAllUsers.size()));
            System.out.println("Nie wolno podawać puste danne");
        } else {
            setNameOfUser(Name);
        }
        if (Objects.equals(Surname, "")) {
            setSurnameOfUser("Defult Surname " + String.valueOf(listAllUsers.size()));
            System.out.println("Nie wolno podawać puste danne");
        } else {
            setSurnameOfUser(Surname);
        }


        if (LevelOfUser == null) {
            setLevelOfUser(0);
        } else {
            setLevelOfUser(LevelOfUser);
        }
        System.out.println("Zostały podane takie danne do construktora Użytkownika: " + getNameOfUser() + " " + getSurnameOfUser() + " " + getLevelOfUser());
    }


    //Funkcja dodania użytkownika do listy z warunkem validacyjnym
    //Zwraca wartość typu Bolean jako podtwirdzenie poprawności działania

    public Boolean takeNewUserToListWithChek(UserClass User) {
        Integer siezeOfListBeforeOperation = listAllUsers.size();
        listAllUsers.add(User);
        Integer siezeOfListAfterOperation = listAllUsers.size();
        if (siezeOfListBeforeOperation >= siezeOfListAfterOperation) {
            System.out.println("Dodanie nowego użytkownika do listy nie powiodło się.");
            System.out.println("Liczba uzytkowników do: " + siezeOfListBeforeOperation);
            System.out.println("Liczba użytkowników po: " + siezeOfListAfterOperation);
            return Boolean.FALSE;
        } else {
            System.out.println("Powodzenie, nowy użytkownik został dodany do lokalnej listy.");
            return Boolean.TRUE;
        }

    }

    public String getNameAndSurnameForGUIByStatikUser() {
        String NameSurname = getStatikUserName() + " " + getStatikUserSurname();
        return NameSurname;
    }

    public Integer getLevelForGUIByStatikUser() {
        return getStatikUserLevel();
    }

    //realizacja funkcja sprawdzająca ilosc poprawnych odpowiedzi za perid wyznaczony timerem
    public static Integer counterAnswersFromUserByTime = 0;
    public static Integer counterCorrectAnswerFromUserByTime = 0;

    public static String resetCountrOfPointsWithPrint() {
        String resultOfResetFunktionString = "Powodzenie parametry counterAnswersFromUserByTime = 0; and counterCorrectAnswerFromUserByTime = 0; ";
        counterAnswersFromUserByTime = 0;
        counterCorrectAnswerFromUserByTime = 0;
        return "Poprawno/Błędnie = " + counterCorrectAnswerFromUserByTime + "/" + counterAnswersFromUserByTime;
    }

    public static String userAnsverCorektVsUncorektStringOutprint(Boolean ResultOfCheckFunktion) {
        String progreshnOfUserCorrectVsUncorect = "Poprawno/Błędnie = " + counterCorrectAnswerFromUserByTime + "/" + counterAnswersFromUserByTime;
        MathLogicClass Logika = new MathLogicClass();
        if (ResultOfCheckFunktion == Boolean.TRUE) {
            counterAnswersFromUserByTime += 1;
            counterCorrectAnswerFromUserByTime += 1;
            progreshnOfUserCorrectVsUncorect = "Poprawno/Błędnie = " + counterCorrectAnswerFromUserByTime + "/" + counterAnswersFromUserByTime;
        } else {
            counterAnswersFromUserByTime += 1;
            progreshnOfUserCorrectVsUncorect = "Poprawno/Błędnie = " + counterCorrectAnswerFromUserByTime + "/" + counterAnswersFromUserByTime;
        }

        return progreshnOfUserCorrectVsUncorect;
    }
}
