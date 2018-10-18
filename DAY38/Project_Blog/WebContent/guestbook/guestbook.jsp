<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.blog.guestbook.GuestBook"%>
<%@page import="com.blog.guestbook.GuestBookDao"%>
<%@page import="com.blog.user.JdbcDaoFactory"%>
<%@page import="com.blog.user.DaoFactory"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="guestbook" class="com.blog.guestbook.GuestBook"
  scope="request" />
<%
	DaoFactory factory = new JdbcDaoFactory();
	GuestBookDao dao = factory.getGuestBookDao();
	String user_id = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equalsIgnoreCase("loginId")) {
				user_id = cookie.getValue();
			}
		}
	}
	GuestBook guest = new GuestBook();
	guest.setUser_id(user_id);
	guest.setContents(request.getParameter("contents"));
	dao.create(guest);

	List<GuestBook> list = dao.listAll();
    for(int i=0; i<list.size();i++){
    	System.out.println();
    }
	System.out.println("등록완료..");
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Elements - Projection by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/assets/css/main.css" />
</head>
<body class="subpage">
  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/header.jsp" />
  <%-- 탑메뉴 종료 --%>
  <!-- Main -->
  <section id="main" class="wrapper">
    <div class="inner">
      <header class="align-center">
        <h2>Guest Book</h2>
        <p>Guest Book</p>
      </header>
      <form action="#" method="post">
        <div class="field">
          <textarea name="contents" id="message" rows="6"
            placeholder="로그인하시면 방명록 등록이 가능합니다."></textarea>
          <input type="submit" value="등록" class="button special"
            id="create">
        </div>
      </form>
      <div class="table-wrapper">
        <table>
          <thead>
            <tr>
              <th>작성자</th>
              <th>내용</th>
              <th>등록날짜</th>
            </tr>
          </thead>
          <tbody>
            <%
            	for (int i=0; i<list.size();i++) {
                %>
                    <tr><%=list[i].get %></tr>
                    <tr></tr>
                    <tr></tr>
                <%
            	}
            %>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="2"></td>
              <td>100.00</td>
            </tr>
          </tfoot>
        </table>
      </div>
    </div>
  </section>
  <%-- footer 시작 --%>
  <jsp:include page="/include/footer.jsp" />
  <%-- footer 종료 --%>
  <!-- Scripts -->
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/skel.min.js"></script>
  <script src="assets/js/util.js"></script>
  <script src="assets/js/main.js"></script>
</body>
</html>