package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + " : " + cookie.getValue());
				if (cookie.getName().equalsIgnoreCase("loginId")) {
					loginId = cookie.getValue();

				}
			}
		}

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/basic.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"header\">");
		out.println("<h1>My Website</h1>");
		out.println("<p>Resize the browser window to see the effect.</p>");
		out.println("</div>");
		out.println("<div class=\"topnav\">");
		out.println(
				"<a href=\"#\">Link</a> <a href=\"#\">Link</a> <a href=\"#\">Link</a> <a  href=\"#\" style=\"float: right\">Link</a>");
		out.println("</div>");
		out.println("<div class=\"row\">");
		out.println("<div class=\"leftcolumn\">");
		out.println("<div class=\"card\">");
		out.println("<h2>TITLE HEADING</h2>");
		out.println("<h5>Title description, Dec 7, 2017</h5>");
		out.println("<div class=\"fakeimg\" style=\"height: 200px;\">Image</div>");
		out.println("<p>Some text..</p>");
		out.println(
				"<p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>");
		out.println("</div>");
		out.println("<div class=\"card\">");
		out.println("<h2>TITLE HEADING</h2>");
		out.println("<h5>Title description, Sep 2, 2017</h5>");
		out.println("<div class=\"fakeimg\" style=\"height: 200px;\">Image</div>");
		out.println("<p>Some text..</p>");
		out.println(
				"<p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class=\"rightcolumn\">");
		out.println("<div class=\"card\">");
		out.println("<div>");
		if (loginId == null) {
			out.println("<form action=\"login.do\" method=\"post\">");
			out.println(
					"<input type=\"text\" id=\"userid\" name=\"userid\" placeholder=\"Identifier...\"> <input type=\"password\" id=\"userpw\" name=\"userpw\" placeholder=\"Password...\"> <input type=\"submit\" value=\"Login\">");
			out.println("</form>");
		} else {
			out.print("<p>" + loginId + "님 로그인 중 .. </p>");
			out.print("<button onclick=\"location.href='login.do';\">Logout</button>");
		}
		out.println("</div>");
		out.println("</div>");
		out.println("<div class=\"card\">");
		out.println("<h3>Popular Post</h3>");
		out.println("<div class=\"fakeimg\">");
		out.println("<p>Image</p>");
		out.println("</div>");
		out.println("<div class=\"fakeimg\">");
		out.println("<p>Image</p>");
		out.println("</div>");
		out.println("<div class=\"fakeimg\">");
		out.println("<p>Image</p>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class=\"card\">");
		out.println("<h3>Follow Me</h3>");
		out.println("<p>Some text..</p>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class=\"footer\">");
		out.println("<h2>Footer</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
