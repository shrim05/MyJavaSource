<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logInForm</title>
</head>
<!-- 	//flash attribute (필요할 때 session 비우기) -->
<c:if test="${not empty sessionScope.message }">
		<script type="text/javascript">
			alert("${sessionScope.message}");
		</script>
</c:if>
 <c:remove var="message" scope="session" />
	<c:set var="savedId" value="${cookie.idCookie.value}" />
<body>
<form method="post">
	<ul>
		<li>
			아이디: <input type="text" name="mem_id" value="${savedId}" />
		</li>
		<li>
			비밀번호: <input type="text" name="mem_pass" />
		</li>
			<input type="checkbox" name="idSave" value="idSave" 
				${not empty savedId?"checked":""}
			/> 아이디 기억하기
			<input type="submit" value="로그인" />
	</ul>
</form>
<a href="<%=request.getContextPath()%>/member/memberInsert.do">회원가입 </a> 

</body>
</html>