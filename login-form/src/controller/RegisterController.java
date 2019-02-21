package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Register;
import service.UserService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailInput = request.getParameter("email");
		String passwordInput = request.getParameter("password");
		String dateInput = request.getParameter("dob");
		String addressInput = request.getParameter("address");

		Register newUser = new Register(emailInput, passwordInput, dateInput, addressInput);

		UserService userService = new UserService();

		userService.createUser(newUser);

		RequestDispatcher view = request.getRequestDispatcher("/index.html");
		view.forward(request, response);

	}
}
