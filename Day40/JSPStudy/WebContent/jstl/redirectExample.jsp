<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%
String url = "https://www.naver.com";
%>
<c:url var="url" value="https://www.naver.com">
  <c:param name="id" value="bangry"/>
  <c:param name="name"  value="김기정"/>
</c:url> <!-- url객체로 저장됨 -->

<a href="${url }">이동</a>
</body>
</html>


