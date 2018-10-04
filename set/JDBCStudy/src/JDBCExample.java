import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * JDBC API를 이용한 DBMS 연동
 * @author 서지원
 */
public class JDBCExample {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		
		String sql = "SELECT employee_id , last_name, salary \r\n" + 
				"FROM employees";

		// #1.JDBC 드라이버 로딩(객체생성)
//		Driver driver = new OracleDriver() ;
		// Class 클래스를 이용한 동적 객체 생성
//		Class.forName(driver).newInstance(); //정상적인 호출
		try {
			Class.forName(driver);// 오라클에서 허용해줌
//			System.out.println("JDBC 드라이버 생성 완료..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//#2. DBMS연결 
		Connection con = null;
		Statement stmt= null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, username, password);
//			System.out.println("DBMS 연결 완료..." + con);
			
			//#3. sql 서버 전송 및 결과집합 수신
			stmt = con.createStatement();
//			System.out.println(stmt);
			rs = stmt.executeQuery(sql);
			// connection, statement, resultSet = jdbc
//			System.out.println(rs);
			
			//#4. ResulrSet에서 데이터 인출
			while(rs.next()) {
//				rs.getString(1); //컬럼 순서
				String employeeId = rs.getString("employee_id");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				System.out.println(employeeId + ","+ lastName + ","+ salary);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(stmt !=null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
	
}
