<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="kr.or.kosta.jsp.dao.UserDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="kr.or.kosta.jsp.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.jsp.dao.DaoFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <%
  System.out.println("시작~~");
    if (request.getMethod().equals("POST")) {
      String id = request.getParameter("userid");
      String pw = request.getParameter("userpw");

      //UserDao를 이용한 회원 가입여부 체크
      DaoFactory factory = new JdbcDaoFactory();
      UserDao dao = factory.getUserDao();
      User user =dao.certify(id, pw);
      System.out.println("엥");
      if(user != null){
        Cookie cookieId = new Cookie("loginId", user.getId());
          Cookie cookiePw = new Cookie("loginPw", user.getPasswd());
          response.addCookie(cookieId);
          response.addCookie(cookiePw);
          response.sendRedirect(application.getContextPath()+"/user/index_backup.jsp");
          System.out.println("여기~~");
      } else {%>
              
              <script>
              alert("회원이 아닌가벼... ")
              history.back();</script>
            <%
              }
    } else {
      Cookie[] cookies = request.getCookies();
      System.out.println("저기~~");
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("loginId")) {
          cookie.setMaxAge(0);
          response.addCookie(cookie);
        }
        if (cookie.getName().equals("loginPw")) {
          cookie.setMaxAge(0);
          response.addCookie(cookie);
        }
      }
      System.out.println(application.getContextPath());
      response.sendRedirect(application.getContextPath()+"/user/index_backup.jsp");
    }
  %>
</body>
</html>