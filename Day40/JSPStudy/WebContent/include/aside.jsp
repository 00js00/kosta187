<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="rightcolumn">
      <div class="card">
      
      <c:choose>
        <c:when test="${empty cookie.loginId}">
            <form action="<%=application.getContextPath() %>/user/loginAction.jsp" method="post">
                <input type="text" id="userid" name="userid" placeholder="Identifier..."> 
                <input type="password" id="userpw" name="userpw" placeholder="Password..."> 
                <input type="submit" value="Login">
             </form>
        </c:when>
        <c:otherwise>
          <div>
          <p>${cookie.loginId.value}님 로그인 중</p>
          <button onclick="location.href='<%=application.getContextPath() %>/user/loginAction.jsp';">Logout</button>
        </div>
        </c:otherwise>      
      </c:choose>
      

      </div>
      <div class="card">
        <h3>Popular Post</h3>
        <div class="fakeimg">
          <p>Image</p>
        </div>
        <div class="fakeimg">
          <p>Image</p>
        </div>
        <div class="fakeimg">
          <p>Image</p>
        </div>
      </div>
      <div class="card">
        <h3>Follow Me</h3>
        <p>Some text..</p>
      </div>
    </div>