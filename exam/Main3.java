package exam;

import java.sql.*;
import java.util.Scanner;

public class Main3 {

    public static String query = "SELECT * FROM messages JOIN users ON messages.user_id = users.id " +
            "WHERE users.id = ?";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/exam2?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            Scanner scann = new Scanner(System.in);
            System.out.println("Podaj ID użytkownika dla którego chcesz wyświetlić wszystkie wiadomości");
            while (!scann.hasNextInt()) {
                System.out.println("ID jest nieprawidłowe spróbuj ponownie");
                scann.nextLine();
            }
            int id_user = scann.nextInt();

            PreparedStatement preStat = conn.prepareStatement(query);
            preStat.setInt(1, id_user);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int idm = rs.getInt("messages.id");
                int u_id = rs.getInt("messages.user_id");
                String mess = rs.getString("messages.message");
                int idu = rs.getInt("users.id");
                String name = rs.getString("users.name");
                String email = rs.getString("users.email");
                String pass = rs.getString("users.password");
                System.out.println(idm + " " + u_id + " " + mess + " " + idu + " " + name + " " +
                        email + " " + pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
