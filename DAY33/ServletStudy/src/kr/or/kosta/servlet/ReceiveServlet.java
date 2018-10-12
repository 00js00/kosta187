package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 에코
 */
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");

		// 요청 파라메터 수신
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String team = request.getParameter("teams");
		String[] hobbys = request.getParameterValues("hobby"); // 선택안하면 null
		Enumeration<String> paramNames = request.getParameterNames();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size: 20pt;'>");
		out.println("<h3>아이디 : " + userId + "<h3/>"); // 전달되는게 없으면 null & 값 입력안된거 오면 빈문자
		out.println("<h3>비번 : " + userPw + "<h3/>");
		out.println("<h3>팀 : " + team + "<h3/>");
		if (hobbys != null) {
			for (String hobby : hobbys) {
				out.println("<h3>취미 : " + hobby + "<h3/>");
			}
		}

		while (paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "=" + value);

		}
		out.println("</body>");
		out.println("</html>");
	}

}
