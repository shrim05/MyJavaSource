<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>longForm</title>
</head>
<%
	String message = (String)session.getAttribute("message");
	//flash attribute (필요할 때 session 비우기)
	if(StringUtils.isNotBlank(message)){
		session.removeAttribute("message");
%>
		<script type="text/javascript">
			alert("<%=message%>");
		</script>
<%
	}
%>
<body>
<form method="post">
	<ul>
		<li>
			아이디: <input type="text" name="mem_id" />
		</li>
		<li>
			비밀번호: <input type="text" name="mem_pass" />
		</li>
			<input type="submit" value="로그인" />
	</ul>
</form>

</body>
</html>