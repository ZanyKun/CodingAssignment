package session.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie nameCookie = new Cookie("name", request.getParameter("name"));
		Cookie passwordCookie = new Cookie("password", request.getParameter("password"));
		nameCookie.setMaxAge(30);
		passwordCookie.setMaxAge(30);
		response.addCookie(nameCookie);
		response.addCookie(passwordCookie);
		
		//response.sendRedirect("./CookieResponse");
		RequestDispatcher dispatch = request.getRequestDispatcher("./CookieResponse");
		dispatch.forward(request, response);
				
	}
}

//Cookies will be saved on the browser

