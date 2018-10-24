<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body style="font-size: 20pt;">
  <%--저는 못찾아요.. --%>
  <!-- 저 여기 있어요 -->
  <%
  	//Java Servlet 쓰는 곳 - web contain에서 돌아감
  	String message = "이넘이 jsp실행과정 입니다.."; // 지역코드가 됨
  	Calendar today = Calendar.getInstance();
  	out.println(today.toString());
  %>
  <br>
  ========================================================================================================
  <br>
  <%
  	out.println("jsp 별거 아니예요");
  %>
  <br>
  ========================================================================================================
  <br>
  <%
  	out.println("jsp 별거 아니예요");
  %>
  <%-- 선언문 --%>
  <%! 
  	int counter;
  //안됨
  /*    public void printMessage(String message){
      out.println(message);  
    }*/
  %>
  
  <%
  String msg = "조금 쉬었다 합시다..";
  //out.println(msg);  
  %>
  메시지 : <%= msg %> 입니다.. 
  
  
</body>
</html>