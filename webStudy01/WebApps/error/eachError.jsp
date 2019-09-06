<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error/eachError.jsp</title>
</head>
<body>
<h2>환잉꽌잉~ 에러페이지데스</h2>
<pre>
	<% exception.getMessage();  %>
	<% ErrorData ed =  pageContext.getErrorData(); %>
	에러발생위치: <%= ed.getRequestURI() %>
	에러상태코드: <%= ed.getStatusCode() %>
	에러 : <%= ed.getThrowable() %>
	익스플로러에서는 500byte 미만에서는 내가 만든 에러페이지를 버린다네..
	그래서 그 이상 데이터 만들기 위해서 의미없는 문장을 써주는 중~~
	
	
</pre>
</body>
</html>