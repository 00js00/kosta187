<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
  href="<%=application.getContextPath()%>/assets/css/main.css" />
<title></title>
</head>
<body class="subpage">
  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/header.jsp" />
  <%-- 탑메뉴 종료 --%>
  <section id="main" class="wrapper">
    <div class="inner">
      <header class="align-center">
        <h2>자유게시판</h2>
      </header>
      <div class="table-wrapper">
        <table>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>아이피</th>
              <th>조회</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>방그리게시글입니다</td>
              <td>bangry</td>
              <td>2018-10-18</td>
              <td>169.0.0.0</td>
              <td>16</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="w3-bar">
        <a href="#" class="w3-button">&#10094;&#10094;</a> <a href="#"
          class="w3-button">&#10094;</a> <a href="#" class="w3-button">1</a>
        <a href="#" class="w3-button">2</a> <a href="#"
          class="w3-button">3</a> <a href="#" class="w3-button">4</a> <a
          href="#" class="w3-button">5</a> <a href="#" class="w3-button">&#10095;</a>
        <a href="#" class="w3-button">&#10095;&#10095;</a>
      </div>
      <div>
        <input value="홈으로" class="button alt send" type="submit">
        <input value="글쓰기" class="button alt send" type="submit">
      </div>
      <div class="select-wrapper">
        <select name="demo-category" id="demo-category">
          <option value="">글제목</option>
          <option value="1">글내용</option>
          <option value="1">작성자</option>
        </select>
        <div>
        <input value="검색" class="button alt send" type="submit">
      </div>
      </div>
      
    </div>
  </section>
  <%-- footer 시작 --%>
  <jsp:include page="/include/footer.jsp" />
  <%-- footer 종료 --%>
</body>
</html>