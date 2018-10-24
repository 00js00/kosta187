<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="score" value="85" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%-- <%
int score = Integer.parseInt(request.getAttribute("score"));
if(score>=50){
 %>
	<%통과 %>
  <%
}
%> --%>

<c:if test="${score>=50 }">
통과
</c:if>

<c:if test="${empty param }"> <!-- parameter가 안왔을 경우 -->
  <c:set var="page" value="1"></c:set>
</c:if>
${page } <!-- 1을 안넣어서 안옴 -->


</body>
</html>


