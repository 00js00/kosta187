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
        <h2>게시글 상세</h2>
      </header>
      <div class="table-wrapper">
        <table class="alt">
          <tbody>
            <tr>
              <td class="bold">글제목</td>
              <td colspan="3">철수입니다</td>
            </tr>
            <tr>
              <td class="bold">작성자</td>
              <td>Vis ac commodo adipiscing arcu aliquet.</td>
              <td class="bold">작성일</td>
              <td>Vis ac commodo adipiscing arcu aliquet.</td>
            </tr>
            <tr>
              <td class="bold">아이피</td>
              <td>Vis ac commodo adipiscing arcu aliquet.</td>
              <td class="bold">조회수</td>
              <td>Vis ac commodo adipiscing arcu aliquet.</td>
            </tr>
          </tbody>
          <tfoot>
          </tfoot>
        </table>
      </div>
      <div class="box">
        <p>
          <br>d
          <br>d
          <br>d
          <br>d
          <br>d
        </p>
      </div>
      <div>
        <input value="글목록" class="button alt send" type="submit">
        <input value="답글쓰기" class="button alt send" type="submit">
        <input value="글수정" class="button alt send" type="submit">
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