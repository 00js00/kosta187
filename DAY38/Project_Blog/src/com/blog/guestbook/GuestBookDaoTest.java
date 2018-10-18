package com.blog.guestbook;


import java.sql.SQLException;
import java.util.List;

import com.blog.user.DaoFactory;
import com.blog.user.JdbcDaoFactory;

public class GuestBookDaoTest {

	public static void main(String[] args) {
		DaoFactory factory = new JdbcDaoFactory();
		GuestBookDao dao = factory.getGuestBookDao();
//		GuestBook guestbook = new GuestBook();
		try {
			
			System.out.println("**** 전체목록 테스트 ****");
			List<GuestBook> list =  dao.listAll();
			for (GuestBook guestbook : list) {
				System.out.println(guestbook);				
			}

//			guestbook.setUser_id("아");
//			guestbook.setContents("좋은 내용 감사합니다.");
//			dao.create(guestbook);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}
		
		
		

	}

}
