<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html lang="zxx">
<meta charset="utf-8">
<head>
<title>Generic - Projection by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
        <h3>SIGNUP NOW</h3>
        <h5>ENJOY SU's HOME FREE by CREATING Account!</h5>
        <form action="#" method="post">
          <div class="form-style-agile">
            <ul>
              <li style="display: inline-block; width: 60%;"><label>ID</label>
                <div class="pom-agile">
                  <input placeholder="ID" name="ID" type="text"
                    required="" class="ID">
                </div></li>
              <li style="display: inline-block;"><input type="button" value="Check ID" class="alt"></li>
            </ul>
          </div>
          <div class="form-style-agile">
            <label>Password</label>
            <div class="pom-agile">
              <input placeholder="Password" name="Password"
                type="password" id="password" required="">
            </div>
          </div>
          <div class="form-style-agile">
            <label>Confirm Password</label>
            <div class="pom-agile">
              <input placeholder="Confirm Password"
                name="Confirm Password" type="password" id="password2"
                required="">
            </div>
          </div>
          <div class="form-style-agile">
            <label>Your Name</label>
            <div class="pom-agile">
              <input placeholder="Your Name" name="Name" type="text"
                required="">
            </div>
          </div>
          <div class="form-style-agile">
            <label>Email</label>
            <div class="pom-agile">
              <input placeholder="Email" name="Email" type="email"
                required="">
            </div>
          </div>
          <div class="12u$">
            <div></div>
            <ul class="actions">
              <li><input type="reset" value="Reset" class="alt" /></li>
              <li><input type="submit" value="Submit" class="alt"></li>
            </ul>
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