<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/sessionDesc.jsp</title>
</head>
<body>
<h2>HttpSession</h2>
<pre>
생성시점 : <%=new Date(session.getCreationTime()) %>
세션아이디: <%= session.getId() %>
세션의 라이프사이클 : 집에서 추가
</pre>
</body>
</html>