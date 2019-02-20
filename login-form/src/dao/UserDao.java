package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	public List<User> getUsersList() {
		List<User> userList = new ArrayList<>();
		try {
			PreparedStatement ps = DbConnection.getConnection().prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userList.add(new User(rs.getString("email"), rs.getString("password")));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

}
