package service;

import java.util.List;

import dao.UserDao;
import model.Login;
import model.Register;

public class UserService {

	private UserDao userDao = new UserDao();
	
	/**
	 * User Authorization 
	 */
	public Boolean verifyUser(String emailInput, String passwordInput) {
		List<Login> userList = userDao.getUsersList();
		
		for (Login element : userList) {
		  if(emailInput.equals(element.getEmail()) && passwordInput.equals(element.getPassword())) {
			  return true;
		  }
		}
		
		return false;
	}
	
	/**
	 * Create new user
	 */
	public void createUser(Register newUser) {
		userDao.createUser(newUser);
	}
	
}
