package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static Connection connection;
	
	public static void createConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/info", "root", "root");
			System.out.println("Connection established!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	public static Connection getConnection() {
		createConnection();
		return connection;
	}
}
