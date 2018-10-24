<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String message = "jstl 연습";
	request.setAttribute("message", message);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>${message}
<c:out value="서지원"/><br>
<c:out value="${ message}"/>

<!-- 값이 없을 경우 -->
<c:out value="${ message}"/>

</body>
</html>