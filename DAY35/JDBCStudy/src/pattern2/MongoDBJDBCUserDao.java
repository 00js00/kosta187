package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;

public class MongoDBJDBCUserDao extends JDBCUserDao {

	@Override
	public Connection getConnection() throws Exception {
		//mongoDB에 맞게 connection 생성 코드..
		return null;
		// 커넥션 풀 개념 적용
	}

}
