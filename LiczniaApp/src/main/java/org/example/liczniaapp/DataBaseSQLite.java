package org.example.liczniaapp;

import java.security.PublicKey;
import java.sql.*;
import java.sql.DriverManager;


public class DataBaseSQLite {
    public static void staticUserInitialiseFUnktion() {
    }

    //Genneracja bazy dannych
    private static final String URL = "jdbc:sqlite:GameUsers.db";

    //tworzenie połączenia z bazą dannych
    //Dlatego że tu mogą pojawiać wyjątki wszystko będzie realizowane na konstrukcji "TRY_CATCH"
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
//            System.out.println("Conection to DB was suksesful!");
        } catch (SQLException e) {
            System.out.println("Połączenie z bazą dannych nie powiodło się z powodu poniższego błędu:");
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createMainTable() {
        String sql = "Create TABLE Users (name varchar(30) UNIQUE, surname varchar(30) UNIQUE, lvl int)";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tablica Użytkowników została stworzona");
            DataBaseSQLite.addDefaultUser();

        } catch (SQLException e) {
            System.out.println("Tablica nie zostawa storzona dlatego że:");
            System.out.println(e.getMessage());
        }
    }

    public static void addDefaultUser() {
        String sql = "INSERT INTO Users(name,surname,lvl) VALUES('" + UserClass.getStatikUserName() + "','" + UserClass.getStatikUserSurname() + "'," + UserClass.getStatikUserLevel() + ")";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Domyślny użytkownik został dodany do tabeli w bazach dannych");
        } catch (SQLException e) {
            System.out.println("Donyślny użytkownik nie został dodany w DB: ");
            System.out.println(e.getMessage());
        }
    }

    public static void addUser(String Name, String Syrname, Integer Lvl) {
        String sql = "INSERT INTO Users (name, surname, lvl) VALUES(" + " ' " + Name + " ' " + "," + " ' " + Syrname + " ' " + "," + " ' " + Lvl + " ' " + ")";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("Dodanie nowego użytkownika w DB powidło się");
        } catch (SQLException e) {
            System.out.println("Dodnanie nonegu  użytkownika w DB nie powiodło(. Kod problemu:");
            System.out.println(e.getMessage());
            System.out.println("podane polecenie do SQLite: " + sql);
        }

    }
    public static int countLen = 0;
    public static Integer chekLenOfDBTable() throws SQLException {
        String sql = "SELECT COUNT(name) FROM Users;";
        try(Connection conn = connect();
        Statement stmt = conn.createStatement();)
        {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                countLen = rs.getInt(1);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Ilość uczestników: "+countLen);
        return countLen;
    }

    public static void delUser(String Name) throws SQLException {
//        String sql = "DELETE FROM Users WHERE name = '" + Name + "';";
        String sql = "DELETE FROM Users WHERE name = 'Nikita';";

        try (Connection conn = connect(); Statement pstmt = conn.createStatement()) {
            pstmt.execute(sql);
            System.out.println("Uzytkownik: " + Name + " Został usunięty z tabeli.");
            System.out.println("Polecenie SQL podane do realizacji: " + sql);
        } catch (SQLException e) {
            System.out.println("Usunięcie użytkownika: " + Name + " z DB nie powiodło z powodu:");
            System.out.println(e.getMessage());
            System.out.println("Polecenie SQL podane do realizacji: " + sql);
        }

    }

}
