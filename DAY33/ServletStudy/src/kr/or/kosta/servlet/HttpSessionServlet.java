package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet2
 */
public class HttpSessionServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = "김기정";
		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		session.setAttribute("userName", name);
		
		//response.sendRedirect("hello2");
	}

}
