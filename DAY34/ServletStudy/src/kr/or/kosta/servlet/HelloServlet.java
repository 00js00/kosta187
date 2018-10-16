package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 최초 작성 서블릿
 * 
 * @author 서지원
 *
 */

public class HelloServlet extends HttpServlet /* implements Servlet */ {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 웹 클라이언트로 동적 출력하고자 하는 데이터 생성
		Calendar now = Calendar.getInstance();
		//String nowString = null;
		String nowString = String.format("%1$tF %1$tT", now);
		//nowString.length();
		
		//응답 메시지의 헤더에 컨텐츠 유형 설정 - 한글로 만들기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
//		이렇게 할 수도 있음
//		String html = "<html>";
//				html += "</html>";
//		
		
		out.println("<html>"); // html 을 보냄
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");

		out.println("<h2>오늘은 " + nowString + " 입니다..</h2>");
		//ServletContextServlet에서 공유
		out.println("<h2>공유 데이터 " + getServletContext().getAttribute("message") + " 입니다..</h2>");

		out.println("</body>");
		out.println("</html>");
	}
}
