package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp2.BasicDataSource;

public class OracleJDBCUserDao extends JDBCUserDao {
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "hr";
	private static final String password = "hr";
	@Override
	public Connection getConnection() throws Exception {
//		Class.forName(driver).newInstance();
//		return DriverManager.getConnection(url, username, password);
//		return UserConnectionPool.getInstance().getConnection();
		
		// 아파치..
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10); // 최대 만들어지는 갯수
		dataSource.setMaxIdle(7);

		return dataSource.getConnection();
		// 커넥션 풀 개념 적용
	}

}
