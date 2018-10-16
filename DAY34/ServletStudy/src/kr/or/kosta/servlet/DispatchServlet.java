package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
public class DispatchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//디스패치 기술
		//response.sendRedirect(location);
		RequestDispatcher rd = request.getRequestDispatcher("/hello.do"); //path에 자기 컨테이너 안에 있는 애들만 가능! 외부 안됨
		// 서블릿 이름으로 인식해서 /servlet/servlet/hello.do 이렇게 인식함 === 자기 컨테이너 안으로 어차피 인식		
		//rd.forward(request, response);
		
		rd.include(request, response); //helloServlet이 만든거 가져온것 + but, dispatchServlet에는 한글 인코딩 안해놔서 오류남
		}

}
