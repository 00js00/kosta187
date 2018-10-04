package pattern3;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class UserDaoTest {
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "hr";
	private static final String password = "hr";
	public static void main(String[] args) {
		JDBCUserDao dao = new JDBCUserDao();
		BasicDataSource dataSource = new BasicDataSource();
		
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10); // 최대 만들어지는 갯수
		dataSource.setMaxIdle(7);
		dao.setDataSource(dataSource);
		List<User> list;
//		List<Map<String,String>> listMap;
		try {
//			dao.create(user);
//			System.out.println("회원가입 완료");

//			User usr = dao.read("bangry");
//			if (usr == null) {
//				System.out.println("존재하지 않는 사용자 아이디입니다");
//			} else {
//				System.out.println("=============조회된 회원정보입니다===============");
//				System.out.println(usr.toString());
//			}
			
//			dao.delete("bangry");
//			System.out.println("삭제 완료");
			
			list = dao.listAll();
			for (User users : list) {
				System.out.println(users);
			}

//			User temp = dao.certify("bangry", "1111");
//			System.out.println(temp.toString());
////			
//			user.setId("bangry");
//			user.setName("서지원");
//			dao.update(user);
//			System.out.println("수정완료");
			
//			listMap= dao.employeeList();
//			for (Map<String, String> map : listMap) {
//				System.out.println(map);
//			}
			
		} catch (Exception e) {
			System.out.println("에러남");
			System.out.println(e.getMessage());
			System.out.println();
//			SQLException ex = (SQLException) e;
//			System.out.println(ex.getErrorCode());
			e.printStackTrace();
		}
	}

}
