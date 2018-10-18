<%@ page contentType="text/html; charset=utf-8"%>
<%
String loginId = null;
String checked = null;
Cookie[] cookies = request.getCookies();
System.out.println("받은 쿠키 : "+cookies);
if (cookies != null) {
  for (Cookie cookie : cookies) {
    System.out.println(cookie.getName() + " : " + cookie.getValue());
    if (cookie.getName().equalsIgnoreCase("loginId")) {
      loginId = cookie.getValue();
    }
    if(cookie.getName().equalsIgnoreCase("Check")){
      checked = cookie.getValue();
    }
  }
}

System.out.println("쿠키" + checked);
%>
<!DOCTYPE HTML>
<html lang="zxx">
<meta charset="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
  content="Full Screen Enroll Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/main.css" />
<link rel="stylesheet" href="<%=application.getContextPath() %>/assets/css/style.css" />
</head>
<body class="subpage">
  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/header.jsp" />
  <%-- 탑메뉴 종료 --%>
  <div>
    <div class="right-form-agile">
      <!-- content -->
      <div class="sub-main-w3">
        <h3>SIGN IN</h3>
        <form action="<%=application.getContextPath()%>/user/loginAction.jsp" method="post">
          <div class="form-style-agile">
            <label>Your Name</label>
            <div class="pom-agile">
            <%if(checked!=null){ %>
            <%-- 쿠키가 있을경우 --%>
                <input name="id" type="text"
                required id="chekedValue">
                <script type="text/javascript"> 
                document.getElementById("chekedValue").value='<%=checked%>';
                </script>
               <% } else { 
                 
               System.out.println(checked);
               %>
               <%-- 쿠키가 없는경우 --%>
              <input placeholder="Your Name" name="id" type="text"
                required>
               <% }%>
            </div>
          </div>
          <div class="form-style-agile">
            <label>Password</label>
            <div class="pom-agile">
              <input placeholder="Password" name="passwd"
                type="password" id="password" required="">
            </div>
          </div>
          <input type="submit" value="LOGIN" class="login" class="alt">
          
          <div class="4u 12u$(small)"
            style="float: right; margin-top: 2%;">
            <input type="checkbox" id="demo-priority-low"
              name="demo-priority" value="checked"> <label
              for="demo-priority-low">아이디 기억</label>
          </div>
        </form>
      </div>
    </div>
  </div>
  <%-- footer 시작 --%>
  <jsp:include page="/include/footer.jsp" />
  <%-- footer 종료 --%>
</body>
</html>