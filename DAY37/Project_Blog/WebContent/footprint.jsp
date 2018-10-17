<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<!--
	Projection by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>Elements - Projection by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="subpage">
  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/header.jsp" />
  <%-- 탑메뉴 종료 --%>
  <!-- Main -->
  <section id="main" class="wrapper">
    <div class="inner">
      <header class="align-center">
        <h2>Foot Print</h2>
        <p>Foot Print</p>
      </header>
      <div class="field">
        <textarea name="message" id="message" rows="6"
          placeholder="로그인하시면 방명록 등록이 가능합니다."></textarea>
        <input type="button" value="등록" class="button special"
          id="create">
      </div>
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
            <tr>
              <td>Item 1</td>
              <td>Ante turpis integer aliquet porttitor.</td>
              <td>29.99</td>
            </tr>
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