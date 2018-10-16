import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 동적 SQL 실행
 * 
 * @author 서지원
 *
 */
public class DynamicSQLExample {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "hr";
	String password = "hr";

	public void execute(String sql) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(sql);
			boolean exists = pstmt.execute();
			if (exists) {
				rs = pstmt.getResultSet();
				ResultSetMetaData rsm = rs.getMetaData();
				int columnCount = rsm.getColumnCount();
				
				for (int i = 1; i < columnCount; i++) {
					String columnNames = rsm.getColumnLabel(i);
					System.out.print(columnNames + "\t");
				}
				while (rs.next()) {
					System.out.println("");
					for (int i = 1; i < columnCount; i++) {
						String columnName = rsm.getColumnLabel(i);
						String column = rs.getString(columnName);
						System.out.print(column+ "\t"+ "\t");
					}

				}
				
			} else {
				int count = pstmt.getUpdateCount();
				System.out.println(count + "행이 변경되었습니다..");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	DynamicSQLExample e = new DynamicSQLExample();
	e.execute("SELECT employee_id , last_name, salary \r\n" + 
			"FROM employees ");
	}
}
