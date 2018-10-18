<%@page import="com.blog.user.UserDao"%>
<%@page import="com.blog.user.JdbcDaoFactory"%>
<%@page import="com.blog.user.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="com.blog.user.User" scope="request"/>
<jsp:setProperty property="*" name="user"/>
<%
DaoFactory factory = new JdbcDaoFactory();
UserDao dao = factory.getUserDao();
dao.create(user);
System.out.println("가입완료..");
%>
<jsp:forward page="registResult.jsp"/>
