package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//message db에서 가져왔다고 가정
		String message="서블릿간의데이터공유입니다";
		
		ServletContext context = getServletContext();
		System.out.println(context.getServerInfo());
		System.out.println(context.getContextPath());
		
		context.setAttribute("message", message);
//		response.sendRedirect("hello.do"); //: 바로 hello.do로 이동
//		response.sendRedirect("/servlet/hello.do"); 도 가능
//		response.sendRedirect("/"+getServletContext()+"/hello.do"); 도 가능 : 동적으로 얻어옴
		String location = context.getInitParameter("Location");
		System.out.println(location);
	}

}
