
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	Connection connection;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailInput = request.getParameter("email");
		String passwordInput = request.getParameter("password");

		Validation validate = new Validation();
		Boolean bool = validate.validateUser(emailInput, passwordInput);

		PrintWriter out = response.getWriter();

		if (bool == true) {
			out.println("<h1>Suceess!</h1>");
		} else {
			out.println("<h1>Failed!</h1>");
		}

	}

}
