package controller;

import service.UserService;
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	// The serialVersionUID is a universal version identifier
	// for a Serializable class.
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailInput = request.getParameter("email");
		String passwordInput = request.getParameter("password");

		UserService userService = new UserService();
		Boolean bool = userService.verifyUser(emailInput, passwordInput);

		PrintWriter out = response.getWriter();

		if (bool) {

			RequestDispatcher view = request.getRequestDispatcher("/register.html");
			view.forward(request, response);

		} else {
			out.println("<h1>Invalid admin details!</h1>");
		}
	}
}
