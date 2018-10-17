<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html lang="zxx">
<meta charset="utf-8">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
  content="Full Screen Enroll Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/style.css" />
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
        <form action="#" method="post">
          <div class="form-style-agile">
            <label>Your Name</label>
            <div class="pom-agile">
              <input placeholder="Your Name" name="Name" type="text"
                required="">
            </div>
          </div>
          <div class="form-style-agile">
            <label>Password</label>
            <div class="pom-agile">
              <input placeholder="Password" name="Password"
                type="password" id="password" required="">
            </div>
          </div>
          <input type="submit" value="LOGIN" class="login" class="alt">
        </form>
      </div>
    </div>
  </div>
  <%-- footer 시작 --%>
  <jsp:include page="/include/footer.jsp" />
  <%-- footer 종료 --%>
</body>
</html>