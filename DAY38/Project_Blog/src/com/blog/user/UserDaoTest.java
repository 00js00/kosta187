package com.blog.user;


import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {

	public static void main(String[] args) {
		DaoFactory factory = new JdbcDaoFactory();
		UserDao dao = factory.getUserDao();
//		User user = new User();
		try {
			
			System.out.println("**** 전체목록 테스트 ****");
			List<User> list =  dao.listAll();
			for (User user : list) {
				System.out.println(user);				
			}

//			user.setId("id");
//			user.setName("name");
//			user.setPasswd("passwd");
//			user.setEmail("email");
//			user.setRegdate("regdate");
//			dao.create(user);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}
		
		
		

	}

}
