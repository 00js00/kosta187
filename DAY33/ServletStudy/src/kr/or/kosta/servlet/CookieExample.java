package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
public class CookieExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");

		Cookie[] cookies = request.getCookies();
		int cookieValue = 0;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equals("count")) {
					cookieValue = Integer.parseInt(cookie.getValue());
				}
			}
		}
		cookieValue++;
		out.println("<h2>" + cookieValue + "</h2>");
		Cookie cookie = new Cookie("count", String.valueOf(cookieValue));
		response.addCookie(cookie);

		out.println("</body>");
		out.println("</html>");
	}

}
