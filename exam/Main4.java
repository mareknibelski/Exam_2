package exam;

import java.sql.*;
import java.util.Scanner;

public class Main4 {

    public static String query = "INSERT INTO items(name, description, price) VALUES (?, ?, ?)";

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        System.out.println("Podaj nazwę przedmiotu");
        String name = scann.nextLine();
        System.out.println("Dodaj opis przedmiotu");
        String description = scann.nextLine();
        System.out.println("Podaj cenę przedmiotu");
        while (!scann.hasNextDouble()) {
            System.out.println("Podaj prawidłową cenę przedmiotu");
            scann.nextLine();
        }
        double price = scann.nextDouble();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exam2?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            preStat.setString(1, name);
            preStat.setString(2, description);
            preStat.setDouble(3, price);
            preStat.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
