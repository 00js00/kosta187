package kr.or.kosta.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
public class CookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String id = "bangry"; //login 정보라고 생각
		String id = "방그리"; //login 정보라고 생각		
		id = URLEncoder.encode(id, "utf-8");
		Cookie cookie = new Cookie("loginId", id);
		
//		cookie.setMaxAge(3); // 저장 기간(초단위)
//		cookie.setDomain("http://www.namer.com"); //이 정보를 naver에도 보낼 수 있따
//		cookie.setPath("/"); // 사용범위 - / : 모든 위치에서 사용할 것임

		// 이거를 header에 넣어야 브라우저에 저장됨
//		response.setHeader("Set-Cookie", "................"); // addCookie안쓰고 하나하나 추가해줄때
		response.addCookie(cookie); 

		response.sendRedirect("hello2");
	}

}
