package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main1 {
	private static final String QUERY1 = "CREATE TABLE IF NOT EXISTS users(" +
			"id int AUTO_INCREMENT," +
			"name varchar(60)," +
			"email varchar(60) unique," +
			"password varchar(60)," +
			"PRIMARY KEY(id)" +
			")";
	private static final String QUERY2 = "CREATE TABLE IF NOT EXISTS messages(" +
			"id int AUTO_INCREMENT," +
			"user_id int NOT NULL," +
			"message text," +
			"PRIMARY KEY(id)," +
			"FOREIGN KEY(user_id)" +
			"REFERENCES users(id)" +
			")";
	private static final String QUERY3 = "CREATE TABLE IF NOT EXISTS items(" +
			"id int AUTO_INCREMENT," +
			"name varchar(40)," +
			"description text," +
			"price decimal(7, 2)," +
			"PRIMARY KEY(id)" +
			")";
	private static final String QUERY4 = "CREATE TABLE IF NOT EXISTS orders(" +
			"id int AUTO_INCREMENT," +
			"description text," +
			"created date," +
			"user_id int NOT NULL," +
			"PRIMARY KEY(id)," +
			"FOREIGN KEY(user_id)" +
			"REFERENCES users(id)" +
			")";
	private static final String QUERY5 = "CREATE TABLE IF NOT EXISTS items_orders(" +
			"id int AUTO_INCREMENT," +
			"item_id int NOT NULL," +
			"order_id int NOT NULL," +
			"PRIMARY KEY(id)," +
			"FOREIGN KEY(item_id) REFERENCES items(id)," +
			"FOREIGN KEY(order_id) REFERENCES orders(id)" +
			")";
	
	public static void main(String[] args){

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/exam2?serverTimezone=UTC",
				"root",
				"coderslab"
		)) {
			PreparedStatement preStat1 = conn.prepareStatement(QUERY1);
			preStat1.executeUpdate();

			PreparedStatement preStat2 = conn.prepareStatement(QUERY2);
			preStat2.executeUpdate();

			PreparedStatement preStat3 = conn.prepareStatement(QUERY3);
			preStat3.executeUpdate();

			PreparedStatement preStat4 = conn.prepareStatement(QUERY4);
			preStat4.executeUpdate();

			PreparedStatement preStat5 = conn.prepareStatement(QUERY5);
			preStat5.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
