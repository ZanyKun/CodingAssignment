package session.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HFServlet")
public class HFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HFServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		out.println("<b>Welcome "+ name + ","+ "</b>" );

		out.println("<p>Let's display your information</p> ");

		out.println("<form action = './HFResponse' method = 'get' >");
		out.println("<input type = 'hidden'  name = 'name' value='"+name+"'>");
		out.println("<input type = 'hidden'  name = 'password' value='"+password+"'>");
		out.println("<input type = 'submit' value = 'Show Me'/>");
		out.println("</form>");
	}

}
