<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>디폴트 객체 11개</title>
</head>
<body>

${"김기정" }
${'김기정' }
${10 }
${null }
${true }<br>
<!-- 출력까지 같이할 수 있음 -->

<%= 10 + 20 %>, ${10 + 20 } <br>
<%= 10 + "20" %>, ${10 + "20" } <br> <!-- el이 숫자에 더 우선순위가 높음 -->
<%-- <%= 10 * "20" %> --%>, ${10 * "20" } <br>
<%= 10 % 20 %>, ${10 % 20 } <br>
<%= 10 % 20 %>, ${10 mod 20 } <br>

${true && false } , ${true and false}<br>

${empty null }<br> <!-- 결과 : true -->
${empty "" }<br><!-- 결과 : true -->

 
</body>
</html>