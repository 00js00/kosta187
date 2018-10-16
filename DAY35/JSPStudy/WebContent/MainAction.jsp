<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <%
  	if (request.getMethod().equals("POST")) {
  		String id = request.getParameter("userid");
  		String pw = request.getParameter("userpw");

  		Cookie cookieId = new Cookie("loginId", id);
  		Cookie cookiePw = new Cookie("loginPw", pw);
  		response.addCookie(cookieId);
  		response.addCookie(cookiePw);
  		response.sendRedirect("index_backup.jsp");
  	} else {
  		Cookie[] cookies = request.getCookies();
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
  		response.sendRedirect("index_backup.jsp");
  	}
  %>
</body>
</html>