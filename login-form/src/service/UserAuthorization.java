package service;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserAuthorization {

	public Boolean validateUser(String emailInput, String passwordInput) {
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getUsersList();
		
		for (User element : userList) {
		  if(emailInput.equals(element.getEmail()) && passwordInput.equals(element.getPassword())) {
			  return true;
		  }
		}
		
		return false;
	}
}
