<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/errorProcess.jsp</title>
</head>
<body>
<h4>에러 처리 방법</h4>
<%
	if(1==1)
	throw new IOException("강제 발생");
// 	throw new NullPointerException("강제 발생");
%>
<pre>
	1. 지역적(한페이지 안에서 에러 발생 => 모든 페이지에 에러처리해야하는 귀찮음이 있음)
		: jsp 페이지 하나를 대상. page 지시자 -> errorPage속성
		
	2. 전역적(어플리케이션 자체) (web.xml -> error-page 속성 설정)
		: 웹어플리케이션을 대상.
		1) 발생예외 타입별 처리 (exception-type)
		2) 상태코드별 처리(error-code)
</pre>
</body>
</html>