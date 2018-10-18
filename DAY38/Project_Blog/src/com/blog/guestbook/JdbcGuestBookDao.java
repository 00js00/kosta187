package com.blog.guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JdbcGuestBookDao implements GuestBookDao {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(GuestBook guestbook) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO guestbook(guestbook_id, user_id, contents)\r\n" + 
				"VALUES (GUESTBOOK_SEQ.NEXTVAL, ?, ?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guestbook.getUser_id());
			pstmt.setString(2, guestbook.getContents());
			pstmt.executeUpdate();
			System.out.println("create완료");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public List<GuestBook> listAll() throws Exception {
		List<GuestBook> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT guestbook_id, \r\n" + "       user_id, \r\n" + "       CONTENTS, \r\n"
				+ "       To_char(regdate, 'YYYY/MM/DD HH24:MI DAY') regdate \r\n" + "FROM   guestbook \r\n"
				+ "ORDER  BY guestbook_id DESC";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<GuestBook>();
			while (rs.next()) {
				GuestBook guestbook = createGuestBook(rs);
				list.add(guestbook);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	private GuestBook createGuestBook(ResultSet rs) throws SQLException {
		GuestBook guestbook = new GuestBook();
		guestbook.setGuestbook_id(rs.getInt("guestbook_id"));
		guestbook.setUser_id(rs.getString("user_id"));
		guestbook.setContents(rs.getString("contents"));
		guestbook.setRegdate(rs.getString("regdate"));
		return guestbook;
	}

}
