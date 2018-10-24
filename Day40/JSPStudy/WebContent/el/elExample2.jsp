<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>디폴트 객체 11개</title>
</head>
<body>

<br>${pageScope }<br>
--------------------------------------------
<br>${requestScope }<br>
--------------------------------------------
<br>${sessionScope }<br>
--------------------------------------------
<br>${applicationScope }<br>
--------------------------------------------
<br>${param.name}<br> <!-- 값이 없으면 "" 으로 나옴 : null 없음  -->
--------------------------------------------
<br>${param["name"]}<br> <!-- 값이 없으면 "" 으로 나옴 : null 없음  -->
--------------------------------------------
<br>${paramValues.hobby[0]}<br> <!-- 배열로 받음 -->
<br>${paramValues.hobby[1]}<br> <!-- 배열로 받음 -->
--------------------------------------------
<br>${header['user-agent']}<br> 
--------------------------------------------
<br>${headerValues['user-agent']}<br>  
--------------------------------------------
<br>쿠키이름 : ${cookie.loginId.name}<br>
<br>쿠키값 : ${cookie.loginId.value}<br>
--------------------------------------------
<br><%=request.getMethod() %><br>
<br>${pageContext.request.method}<br>
-------------------------------------------- 

</body>
</html>