import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author 서지원
 *
 */
public class DQLExample {

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";

		String sql = "SELECT E.employee_id     id, \r\n" + "       E.last_name       ename, \r\n"
				+ "       E.salary          salary, \r\n"
				+ "       TO_CHAR(E.hire_date, 'YYYY-MM-DD HH24:MI:SS')       hiredate, \r\n"
				+ "       D.department_name dname \r\n" + "FROM   employees E \r\n" + "       join departments D \r\n"
				+ "         ON E.department_id = D.department_id ";

		Class.forName(driver).newInstance();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		con = DriverManager.getConnection(url, username, password);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String id = rs.getString("id");
			String ename = rs.getString("ename");
			int salary = rs.getInt("salary");
//			Date hiredate = rs.getDate("hiredate");//날짜의 포맷은 자바에서 결정하는 것 X
			// oracle의 to_char로 하는 것
			String hiredate = rs.getString("hiredate"); // db를 to _char 해서 가져왔으니까 string으로 받아야함
			String dname = rs.getString("dname");
			System.out.println(id + ", " + ename + ", " + salary + ", " + hiredate + ", " + dname);
		}
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}
}
