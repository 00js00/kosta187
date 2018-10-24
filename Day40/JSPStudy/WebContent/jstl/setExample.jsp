<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--태그만 활용하여 스코프 객체에 저장할 수 있다. --%>
<c:set var="message" value="JSTL <연습>입니다." scope="page"/>
<c:set var= "message" value="${message }"/>
<jsp:useBean id="dog" class="kr.or.kosta.jsp.el.Dog"/>
<c:set target="${ dog }" property="name" value="두리"></c:set>


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
<c:out value="${ message}" default="기번 메ㅔㅅ지 입ㄴ디ㅏ"/>
강아지 이름 : ${dog.name }

</body>
</html>


<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:out value="김기정"/><br>
${message }<br>
<c:out value="${message }" default="기본 메시지 입니다..."/><br>
<%--위의 두가지 태그의 차이점 
1. 꺽쇠가 있을 경우이 결과 창이 달라진다. 
2. EL은 있는 그대로 출력한다.
3. out 태그는 다 바꾸어 준다. 
4. out 태그 메시지 안에 오류 발생시, 
디폴트 값을 지정해주어서 오류를 막아줄 수 있다. 
 --%>
 
강아지 이름 : ${dog.name }
</body>
</html>