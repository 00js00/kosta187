<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
List<String> teams = new ArrayList<String>();
teams.add("한화 이글즈");
teams.add("두산 베어즈");
teams.add("sk 라이언스");

request.setAttribute("teams", teams);

List<User> users = new ArrayList<User>();
users.add(new User("bangry1","서지원","1111","bangry@naver.com","2002"));
users.add(new User("bangry2","서지원","1111","bangry@naver.com","2002"));
users.add(new User("bangry3","서지원","1111","bangry@naver.com","2002"));
users.add(new User("bangry4","서지원","1111","bangry@naver.com","2002"));
request.setAttribute("users", users);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<c:forEach var="i" begin="1" end="10" step="1"> <!-- end : 10포함, step: 기본 1 -->
  ${i } : 서지원 입니다 <br>
</c:forEach>

<table border=1>
  <c:forEach var="i" begin="2" end="9">
    <tr>
    <c:forEach var="j" begin="1" end="9">
      <td> ${i }*${j } = ${i*j } </td>
    </c:forEach>
    </tr>
  </c:forEach>      
</table>

<select>
  <c:forEach var="team" items="${teams }">
    <option>${team }</option>
  </c:forEach>
</select>


<table border="1">
  <tr>
  <td>번호</td>
  <td>아이디</td>
  <td>이름</td>
  <td>비밀번호</td>
  <td>이메일</td>
  <td>가입일자</td>
  </tr>
  <c:choose>
    <c:when test="${not empty users }">
      <c:forEach var="user" items="${users }" varStatus="status">
        <tr>
        <td>${status.count} </td>
        <td>${user.id }</td>
        <td>${user.name }</td>
        <td>${user.passwd }</td>
        <td>${user.email }</td>
        <td>${user.regdate }</td>
        </tr>    
      </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
          <td colspan="5">회원이 존재하지 않습니다</td>    
        </tr>
    </c:otherwise>
  </c:choose>
</table>

<%
String ssn = "680313-1234567";
request.setAttribute("ssn", ssn);
%>
<c:forTokens var="token" items="${ssn }" delims="-">
  ${token },
</c:forTokens>

</body>
</html>


