<%@page import="kr.or.kosta.jsp.Account"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
Account acc = new Account("1111-1111-1111","서지원",1111,10000);
Class.forName("kr.or.kosta.jsp.Account").newInstance();
%>

<jsp:useBean id="account" class="kr.or.kosta.jsp.Account" scope="session"></jsp:useBean> <!-- Map의 키값 -->
<jsp:setProperty property="accountNum" name="account" value="1111-1111"/>
<jsp:setProperty property="accountOwner" name="account" value="지원"/>
<jsp:setProperty property="passwd" name="account" value="1111"/>
<jsp:setProperty property="restMoney" name="account" value="5000"/>
<!--<jsp:forward page="useBeanExample2.jsp"></jsp:forward>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

계좌번호 : <%=account.getAccountNum()%>
예금주명 : <%=account.getAccountOwner()%>
비밀번호 : <%=account.getPasswd()%>
잔액 : <%=account.getRestMoney()%>
<br>
계좌번호 : <jsp:getProperty property="accountNum" name="account"/><br>
예금주명 :<jsp:getProperty property="accountOwner" name="account" /><br>
비밀번호 :<jsp:getProperty property="passwd" name="account" /><br>
잔액 : <jsp:getProperty property="restMoney" name="account"/><br>
</body>
</html>