package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 마임타입 이해를 위한 서블릿
 */
public class MIMEServlet extends HttpServlet {
	// 메모리에 저장할 때 클래스가 바뀔 때마다 충돌을 막기 위해 구분해주려고 ~ : 냅둬도 되고 추가해도 되고
	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/*
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	} 상속되어있음 */ 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf-8");
		// Content-Type:text/plain; charset=utf-8
		PrintWriter out = response.getWriter();
		out.println("일반적인 텍스트 입니다... ");
		
	}

}
