<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>jsp가 제공하는 9개의 디폴트 객체들 .. </h2>
<%
String id = request.getParameter("id");
//response.sendRedirect("hello.jsp");
out.println("출력이요");

%>

아이디 : <%= id %><br>
WAS에 등록된 웹애플리케이션 이름 : <%= application.getContextPath() %> <!-- /jsp --><br>
요청 URI : <%= application.getServerInfo() %> <!--  Apache Tomcat/8.0.53  --><br>
location : <%= config.getInitParameter("location") %><br><!-- c:/a/b/xxx.xml -->
현재 페이지 : <%=this  %><br><!-- org.apache.jsp.defaultObject_jsp@e109366 -->
현재 페이지 : <%=page  %><br><!-- org.apache.jsp.defaultObject_jsp@e109366 -->
<%-- 예외 : <%=exception %> --%>
</body>
</html>