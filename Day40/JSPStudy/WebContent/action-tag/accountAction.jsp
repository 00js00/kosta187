<%@ page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="account" class="kr.or.kosta.jsp.Account" scope="request"/>
<jsp:setProperty property="*" name="account"/>
<jsp:setProperty property="accountNum" param="num" name="account"/> <!--불러오는애랑 이름 다르게 설정하고 싶을 때 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
계좌번호 : <jsp:getProperty property="accountNum" name="account"/><br>
예금주명 :<jsp:getProperty property="accountOwner" name="account" /><br>
비밀번호 :<jsp:getProperty property="passwd" name="account" /><br>
잔액 : <jsp:getProperty property="restMoney" name="account"/><br>
</body>
</html>