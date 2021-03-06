package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import kr.or.kosta.dao.JDBCUserDao;
import kr.or.kosta.dao.User;

/**
 * Servlet implementation class HelloServlet2
 */
public class DatabaseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JDBCUserDao dao;
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "hr";
	private static final String password = "hr";

	@Override
	public void init() throws ServletException {
		dao = new JDBCUserDao();
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10); // 최대 만들어지는 갯수
		dataSource.setMaxIdle(7);
		dao.setDataSource(dataSource);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> list;
		try {
			list = dao.listAll();

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Programming</title>");
			out.println("<meta charset=\"utf-8\">");
			out.println("</head>");
			out.println("<body style='font-size: 20pt;'>");

			out.println("<table border='1' width='50%'>");
			for (User user : list) {
				System.out.println(user);
			}
			out.println("</table>");

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
