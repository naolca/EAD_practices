package itsc;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
			private static final String DBurl =
			"jdbc:mysql://localhost:3306/usersdb";
			private static final String DBuser = "new_username";
			private static final String DBpassword = "new_password";
			
			@Override
				protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				String name = req.getParameter("name");
				String email = req.getParameter("email");
				String password = req.getParameter("password");
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(DBurl,DBuser,DBpassword);
					String query = "insert into users(name, email, password) values(?,?,?)";
					PreparedStatement preparedStatement = conn.prepareStatement(query);

					preparedStatement.setString(1, name);
					preparedStatement.setString(2, email);
					preparedStatement.setString(3, password);
					preparedStatement.executeUpdate();
					conn.close();

					resp.sendRedirect("confirmation.jsp");
					
				}
				catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
					
				}
			
}