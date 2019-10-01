<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
<!-- action="<%=request.getContentLength() %>/imagesFolderProcess" -->
<form  method="post">
<select name="filename" required >
	<option value>이미지선택</option>
<%
	 String[] imageFiles = (String[])request.getAttribute("imageFiles");
	 String[] targetFiles = (String[])request.getAttribute("targetFiles");
	 for(String file : imageFiles){
		%>
		<option><%=file%></option>
		<%
	}%>
</select>
	<!-- 타겟의 위치는 07  -->
	<input type="radio" value="COPY" name="command" required />복사
	<input type="radio" value="MOVE" name="command" required />이동
	<input type="radio" value="DELETE" name="command" required />삭제
	<input type="submit" value="명령처리" />
</form>
<ul>
	<%
	 for(String file : targetFiles){
		%>
		<li><%=file%></li>
		<%
	}%>
</ul>
</body>
</html>