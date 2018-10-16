package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
public class ServletConfigServlet extends HttpServlet {
	
	String driver ;
	@Override
		public void init(ServletConfig config) throws ServletException {
		driver = config.getInitParameter("driver");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println(driver);
	}

}
