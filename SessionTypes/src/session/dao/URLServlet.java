package session.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/URLServlet")
public class URLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public URLServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/URLResponse?name=" + name + "&password=" + password);
		dispatcher.forward(request, response);
		//response.sendRedirect("./URLResponse?name=" + name + "&password=" + password);
	}

}
