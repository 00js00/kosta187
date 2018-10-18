<%@page import="com.blog.user.User"%>
<%@page import="com.blog.user.UserDao"%>
<%@page import="com.blog.user.JdbcDaoFactory"%>
<%@page import="com.blog.user.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <%
  	System.out.println("login ACtion 시작~~");
  	if (request.getMethod().equals("POST")) {
  		String id = request.getParameter("id");
  		String pw = request.getParameter("passwd");

  		//UserDao를 이용한 회원 가입여부 체크
  		DaoFactory factory = new JdbcDaoFactory();
  		UserDao dao = factory.getUserDao();
  		User user = dao.certify(id, pw);

  		if (user != null) {
  			Cookie cookieId = new Cookie("loginId", user.getId());
  			System.out.println("체크 : " + request.getParameter("demo-priority"));
  			Cookie[] cookies = request.getCookies();
  			for (Cookie cookie : cookies) {
  				if (request.getParameter("demo-priority") != null) {
  					String check = request.getParameter("id");
  					Cookie cookieCheck = new Cookie("Check", user.getId());
  					cookieCheck.setPath("/");
  					cookieCheck.setMaxAge(60 * 60 * 24 * 30);
  					response.addCookie(cookieCheck);
  				} else if (cookie.getName().equals("Check")
  						&& (request.getParameter("demo-priority") == null)) {
  					cookie.setMaxAge(0);
  					cookie.setPath("/");
  					response.addCookie(cookie);
  				}

  			}
  			cookieId.setPath("/");
  			response.addCookie(cookieId);
  			response.sendRedirect(application.getContextPath() + "/index.jsp");
  			System.out.println(application.getContextPath() + "/index.jsp");
  			System.out.println("여기~~");
  		} else {
  %>
  <script>
			alert("회원이 아닌가벼... ")
			history.back();
		</script>
  <%
  	}
  	} else {
  		Cookie[] cookies = request.getCookies();
  		System.out.println("저기~~");
  		for (Cookie cookie : cookies) {
  			if (cookie.getName().equals("loginId")) {
  				cookie.setMaxAge(0);
  				cookie.setPath("/");
  				response.addCookie(cookie);
  			}
  			/* if (cookie.getName().equals("Check") && (request.getParameter("demo-priority") != "checked")) {
  				cookie.setMaxAge(0);
  				cookie.setPath("/");
  				response.addCookie(cookie);
  			} */
  		}
  		System.out.println(application.getContextPath());
  		response.sendRedirect(application.getContextPath() + "/index.jsp");
  	}
  %>
</body>
</html>