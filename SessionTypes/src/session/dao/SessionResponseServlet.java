package session.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionResponseServlet
 */
@WebServlet("/SessionResponse")
public class SessionResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SessionResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		System.out.print(name);
		String password = (String) session.getAttribute("password");
		System.out.print(password);
		PrintWriter writer = response.getWriter();
		
		writer.print("<p>Your name is " + name + " and your password is " + password +" </p>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}
