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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
			String driver = "com.mysql.cj.jdbc.Driver";
			String DBurl = "jdbc:mysql://localhost:3306/usersdb";
			String DBuser= "new_username";
			String DBpassword = "new_password";
			
			
			
			@Override
				protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// TODO Auto-generated method stub
				String email = req.getParameter("email");
				String password = req.getParameter("password");
					try {
						Class.forName(driver);
						Connection conn = DriverManager.getConnection(DBurl, DBuser, DBpassword);
						String query = "select * from users where email = ? AND password = ?";

						PreparedStatement preparesStatement =conn.prepareStatement(query);

						preparesStatement.setString(1, email);
						preparesStatement.setString(2, password);
						ResultSet res = preparesStatement.executeQuery();
						
						if(res.next()) {
							//authentication successful
							HttpSession session = req.getSession();
							session.setAttribute("username", res.getString("name"));
							conn.close();
							System.out.println("THis is doneeee!!!");
							resp.sendRedirect("welcome.jsp");
						}else {
							//authentication failed
							conn.close();
							resp.sendRedirect("login.jsp");
						}
	
					}
					catch(SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
	