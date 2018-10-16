<%@ page contentType="text/html; charset=utf-8"%>
<%
String loginId = null;
Cookie[] cookies = request.getCookies();
System.out.println("받은 쿠키 : "+cookies);
if (cookies != null) {
  for (Cookie cookie : cookies) {
    System.out.println(cookie.getName() + " : " + cookie.getValue());
    if (cookie.getName().equalsIgnoreCase("loginId")) {
      loginId = cookie.getValue();
      
    }
  }
}

%>
<div class="rightcolumn">
      <div class="card">
        <div>
        <%
        if (loginId == null) {
        %>
          <form action="MainAction.jsp" method="post">
            <input type="text" id="userid" name="userid"
              placeholder="Identifier..."> <input
              type="password" id="userpw" name="userpw"
              placeholder="Password..."> <input type="submit"
              value="Login">
          </form>
          <%
          } else {
          %>
          <p><%= loginId %>님 로그인 중</p>
          <button onclick="location.href='MainAction.jsp';">Logout</button>
          <%
          }
          %>
        </div>
      </div>
      <div class="card">
        <h3>Popular Post</h3>
        <div class="fakeimg">
          <p>Image</p>
        </div>
        <div class="fakeimg">
          <p>Image</p>
        </div>
        <div class="fakeimg">
          <p>Image</p>
        </div>
      </div>
      <div class="card">
        <h3>Follow Me</h3>
        <p>Some text..</p>
      </div>
    </div>