<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
  <h2>JSP가 제공하는 4개의 스코프(컨텍스트)객체들 ..</h2>
  <%
  	pageContext.setAttribute("message", "pageContext 스코프객체입니다"); //오로지 이 페이지 안에서만 사용가능 (나만의 개인정보)
     
  	request.setAttribute("message", "request 스코프객체입니다");
    //application.getRequestDispatcher("/scopeObject2.jsp").forward(request, response); //scopeObject2에도 권한 부여
    
	session.setAttribute("message", "session 스코프객체입니다");
    
	application.setAttribute("message", "application 스코프객체입니다");
  %>
  pageContext 정보 : <%= pageContext.getAttribute("message") %><br>
  request 정보 :  <%=request.getAttribute("message")%><br>
  session 정보 :  <%=session.getAttribute("message")%><br>
  application 정보 :  <%=application.getAttribute("message")%><br>
 <%=pageContext.findAttribute("이름") %> <!-- 4가지 스코프 전부 탐험 -->
</body>
</html>