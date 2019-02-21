package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Login;
import model.Register;

public class UserDao {

	public List<Login> getUsersList() {
		List<Login> userList = new ArrayList<>();
		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userList.add(new Login(rs.getString("email"), rs.getString("password")));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}
	
	public void createUser(Register newUser) {
		String email = newUser.getEmail();
		String password = newUser.getPassword();
		String dob = newUser.getDob();
		String address = newUser.getAddress();
		
		String query = "INSERT INTO user (email, password, dob, address) VALUES ('" + email + "','" + password + "', '" + dob + "', '" + address + "');";
		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement(query);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
