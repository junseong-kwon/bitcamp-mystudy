<%@ page
    language="java" 
    contentType="text/html;charset=UTF-8" 
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ page import="bitcamp.myapp.vo.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp"/>

<h1>회원 조회</h1>

<%
User user = (User) request.getAttribute("user");
if (user == null) {
%>

<p>없는 회원입니다.</p>

<%
} else {
%>

<form action='/user/update' method="post">
    번호: <input name='no' readonly type='text' value='${user.no}'><br>
    이름: <input name='name' type='text' value='${user.name}'><br>
    이메일: <input name='email' type='email' value='${user.email}'><br>
    암호: <input name='password' type='password'><br>
    연락처: <input name='tel' type='tel' value='${user.tel}'><br>
    <button>변경</button>
    <button type='button' onclick='location.href="/user/delete?no=${user.no}"'>삭제</button>
</form>

<%
}
%>

</body>
</html>