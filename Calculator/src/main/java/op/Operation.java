package op;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Operation
 */
@WebServlet("/Operation")
public class Operation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Operation() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from the form
        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));
        String operation = request.getParameter("operation");

        // Determine which operation was selected and forward the request
        if ("add".equals(operation)) {
            request.setAttribute("number1", number1);
            request.setAttribute("number2", number2);
            request.getRequestDispatcher("/Addition").forward(request, response);
        } else if ("multiply".equals(operation)) {
        	
            request.setAttribute("number1", number1);
            request.setAttribute("number2", number2);
            request.getRequestDispatcher("/Multiplication").forward(request, response);
        }
    }

}
