package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";

	String sql = "SELECT employee_id , last_name, salary \r\n" + "FROM employees";

	Connection con;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			/*
			 * while(rs.next()) { String employeeId = rs.getString("employee_id"); String
			 * lastName = rs.getString("last_name"); int salary = rs.getInt("salary");
			 * System.out.println(employeeId + ","+ lastName + ","+ salary); }
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size: 20pt;'>");

		out.println("<table border='1' width='50%'>");
		try {
			while (rs.next()) {
				int id = rs.getInt("employee_id");
				String name = rs.getString("last_name");
				int salary = rs.getInt("salary");
				out.println("<tr>");
				out.println("<td>" + id + "</td><td>" + name + "</td><td>" + salary + "</td>");
				out.println("</tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");

	}

	@Override
	public void destroy() {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
