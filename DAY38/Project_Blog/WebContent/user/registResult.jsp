<%@ page contentType="text/html; charset=utf-8"%>
 <jsp:useBean id="user" class="com.blog.user.User" scope="request"/>
<!DOCTYPE HTML>
<html lang="zxx">
<meta charset="utf-8">
<head>
<title>Generic - Projection by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
        <h3>!SUCCESS!</h3>
        <h5>Now You Can ENJOY SU's HOME for FREE</h5>
        <div class="success">
          <p>회원등록이 정상적으로 완료되었습니다.</p>
          <p>가입하신 회원 정보는 아래와 같습니다.</p>
        </div>
        <div class="info">
          <p>아이디 : <%=user.getId()%></p>
          <p>이름 : <%=user.getName() %></p>
          <p>이메일 : <%=user.getEmail() %></p>
        </div>
        <div class="success">
          <p>"홈으로" 버튼을 클릭하시면 홈페이지로 이동합니다.</p>
        </div>
        <button type="button" onclick="location.href='..<% application.getContextPath();%>/index.jsp';"
          class="abc">홈으로</button>
      </div>
    </div>
  </div>
  <%-- footer 시작 --%>
  <jsp:include page="/include/footer.jsp" />
  <%-- footer 종료 --%>
</body>
</html>