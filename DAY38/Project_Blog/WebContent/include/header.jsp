<%@ page contentType="text/html; charset=utf-8"%>
<%
	String loginId = null;
	Cookie[] cookies = request.getCookies();
	System.out.println("받은 쿠키 : " + cookies);
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			if (cookie.getName().equalsIgnoreCase("loginId")) {
				loginId = cookie.getValue();

			}
		}
	}
%>
<link rel="stylesheet" href="assets/css/style.css" type="text/css"
  media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="assets/css/fontawesome-all.css">
<header id="header">
  <div class="inner">
    <a href="<%=application.getContextPath()%>/index.jsp" class="logo"><strong>HOME</strong></a>
    <nav id="nav">
      <a
        href="<%=application.getContextPath()%>/guestbook/guestbook.jsp">방명록</a>
      <a href="<%=application.getContextPath()%>/board/mainBoard.jsp">자유게시판</a>
      <%
      	if (loginId == null) {
      %>
      <a href="<%=application.getContextPath()%>/user/login.jsp">로그인</a>
      <a href="<%=application.getContextPath()%>/user/regist.jsp">회원가입</a>
      <%
      	} else {
      %>
      <a href="<%=application.getContextPath()%>/user/loginAction.jsp">로그아웃</a>
      <%
      	}
      %>
    </nav>
    <a href="#navPanel" class="navPanelToggle"><span
      class="fa fa-bars"></span></a>
  </div>
</header>