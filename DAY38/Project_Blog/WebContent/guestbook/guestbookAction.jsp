<%@page import="com.blog.guestbook.GuestBook"%>
<%@page import="com.blog.guestbook.GuestBookDao"%>
<%@page import="com.blog.user.JdbcDaoFactory"%>
<%@page import="com.blog.user.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="guestbook" class="com.blog.guestbook.GuestBook"
  scope="request" />
<%
	DaoFactory factory = new JdbcDaoFactory();
	GuestBookDao dao = factory.getGuestBookDao();
	GuestBook guest = new GuestBook();
	String user_id = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase("loginId")) {
				user_id = cookie.getValue();
			}
		}
	}
	guest.setUser_id(user_id);
	guest.setContents(request.getParameter("contents"));
	dao.create(guest);
	System.out.println("등록완료..");
%>
<jsp:forward page="guestbook.jsp" />