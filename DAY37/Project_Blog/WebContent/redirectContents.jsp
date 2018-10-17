<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Generic - Projection by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="subpage">
  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/header.jsp" />
  <%-- 탑메뉴 종료 --%>
  <!-- Three -->
  <section id="three" class="wrapper">
    <div class="inner">
      <header class="align-center">
        <h2>답변 게시글 쓰기</h2>
      </header>
      <form action="#" method="post">
        <div class="field">
          <label for="message">Title</label> <input name="title"
            id="title" type="text" placeholder="[RE]답변입니다~">
        </div>
        <div class="field half first">
          <label for="name">Name</label> <input name="name" id="name"
            type="text" placeholder="Name" disabled="disabled">
        </div>
        <div class="field half">
          <label for="passwd">Password</label> <input name="passwd"
            id="passwd" type="password" placeholder="Password">
        </div>
        <div class="field">
          <label for="message">Message</label>
          <textarea name="message" id="message" rows="10"
            placeholder="Message"></textarea>
        </div>
        <div><input value="Send Message" class="button alt send"
          type="submit"></div>
      </form>
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