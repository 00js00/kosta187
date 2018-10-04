package pattern;

import java.util.List;
import java.util.Map;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao dao = new JDBCUserDao();
		List<Map<String,String>> list;
		User user = new User();
		user.setId("bangry");
		user.setName("김기정");
		user.setPasswd("1111");
		user.setEmail("bangry313@naver.com");
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
			
			
//			for (int i = 0; i < dao.listAll().size(); i++) {
//				System.out.println(dao.listAll().get(i));
//			}
//			
//			User temp = dao.certify("bangry", "1111");
//			System.out.println(temp.toString());
////			
//			user.setId("bangry");
//			user.setName("서지원");
//			dao.update(user);
//			System.out.println("수정완료");
			
			list= dao.employeeList();
			for (Map<String, String> map : list) {
				System.out.println(map);
			}
			
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
