import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

/**
 * 
 * @author 서지원
 *
 */
public class ProcedureCallExample {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String sql = "{call getEmployee(?,?,?,?)}";

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, username, password);
			cstmt = con.prepareCall(sql);
			
			cstmt.setInt(1, 100);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			cstmt.execute();
			int employeeId = cstmt.getInt(2);
			String firstName = cstmt.getString(3);
			int salary = cstmt.getInt(4);
			
			System.out.println(employeeId + "\t" + firstName + "\t" + salary);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		

	}
}
