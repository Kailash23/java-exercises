import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validation {
	
	Connection connection;
	
	public void getConnection() {
		DbConnection dbCon = new DbConnection();
		dbCon.createConnection();
		connection = dbCon.getConnection();
	}
	
	public Boolean validateUser(String emailInput, String passwordInput) {
		getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				if(email.equals(emailInput) && password.equals(passwordInput)) {
					return true;
				}
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
