package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 생명주기 테스트를 위한 서블릿
 */
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int count;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LifecycleServlet() {
		System.out.println("LifecycleServlet() Calledd... ");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() Calledd... ");
		//super.init(config); // override 했을때 init() 불러오려면 이거 써야함
		count = 0;

	}
	//@Override
	public void init() throws ServletException {
		System.out.println("init() Calledd... "); // override 하면 이거 안불러옴

	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy() Calledd... ");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		count++;
		System.out.println("service( request,  response) Calledd... ");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet( request,  response) Calledd... ");
		System.out.println(request);
		System.out.println(response);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"); // html 을 보냄
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");

		out.println("<h2>당신은 " + count + " 번째 방문자입니다..</h2>");

		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost( request,  response) Calledd... ");
		doGet(request, response);
	}

}
