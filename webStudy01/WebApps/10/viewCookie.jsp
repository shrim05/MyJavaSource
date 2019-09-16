<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다른경로 쿠키확인</title>
</head>
<body>
<h4>다른경로 쿠키확인</h4>
	<%
	Cookie[] cookies = request.getCookies();
		Cookie searched = null;
		if(cookies!=null){
			for(Cookie temp : cookies){
// 				if("testCookie".equals(temp.getName())){
// 					searched = temp;
// 					break;
// 				}
			%>
			<%= URLDecoder.decode(temp.getValue(),"UTF-8") %>
		<%
			}
		}
		%>
</body>
</html>