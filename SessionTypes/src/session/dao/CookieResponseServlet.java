package session.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieResponse")
public class CookieResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieResponseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c: cookies) {
			if(c.getName().equals("name")) {
				writer.print("<p>Your name is " + c.getValue() + "</p>");
			}
			
			if(c.getName().equals("password")) {
				writer.print("<p>Your password is " + c.getValue() + "</p>");
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
