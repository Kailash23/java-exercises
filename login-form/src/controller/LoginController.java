package controller;

import service.UserAuthorization;
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/submit")
public class LoginController extends HttpServlet {
	
	// The serialVersionUID is a universal version identifier 
	// for a Serializable class.
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String emailInput = request.getParameter("email");
		String passwordInput = request.getParameter("password");

		UserAuthorization validate = new UserAuthorization();
		Boolean bool = validate.validateUser(emailInput, passwordInput);

		PrintWriter out = response.getWriter();

		if (bool == true) {
			out.println("<h1>Suceess!</h1>");
		} else {
			out.println("<h1>Failed!</h1>");
		}
	}
}
