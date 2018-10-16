package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");

		// USER DAO를 이용한 회원 가입 여부 체크
		// 무조건 회원이란 가정
		Cookie cookie = new Cookie("loginId", id);
//		cookie.setMaxAge(60*60*24*30);
		cookie.setPath("/");
		response.addCookie(cookie);
		response.sendRedirect("index.html");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + " : " + cookie.getValue());
				if (cookie.getName().equalsIgnoreCase("loginId")) {
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		response.sendRedirect("index.html");
	}
}
