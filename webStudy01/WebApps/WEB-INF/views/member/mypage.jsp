<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<title>mypage</title>
</head>
<%
	MemberVO savedMember = (MemberVO)request.getAttribute("savedMember");
%>
<body>
<form>
	<table>
		<tr><td>아이디</td><td><%=savedMember.getMem_id() %></td></tr>
		<tr><td>이름</td><td><%=savedMember.getMem_name() %></td></tr>
		<tr><td>핸드폰</td><td><%=savedMember.getMem_hp() %></td></tr>
		<tr><td>이메일</td><td><%=savedMember.getMem_mail() %></td></tr>
		<tr><td>우편번호</td><td><%=savedMember.getMem_zip() %></td></tr>
		<tr><td>주소</td><td><%=savedMember.getMem_add1() %></td></tr>
		<tr><td>생일</td><td><%=savedMember.getMem_bir() %></td></tr>
		<tr><td>취미</td><td><%=savedMember.getMem_like() %></td></tr>
	</table>
	<input type="button" value="수정" />
</form>
</body>
</html>