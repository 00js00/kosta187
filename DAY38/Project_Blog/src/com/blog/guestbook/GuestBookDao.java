package com.blog.guestbook;

import java.util.List;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * 
 * @author 서지원
 *
 */
public interface GuestBookDao {

	public void create(GuestBook guestbook) throws Exception;

	public List<GuestBook> listAll() throws Exception;

}
