<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome yo</title>
</head>
<body>
<form name="logoutForm" action="${pageContext.request.contextPath}/logout" method="post">

</form>
<%
	MemberVO authMember = (MemberVO)session.getAttribute("authMember");
	if(authMember==null){
%>
		<a href="<%=request.getContextPath() %>/login">로그인</a>
<%
	}else{
	%>
		<a href="<%=request.getContextPath()%>/mypage"><%=authMember.getMem_name()%> 님 </a><a href="#" onclick="document.logoutForm.submit();">로그아웃</a> 
<%	
	}
%>
</body>

</html>