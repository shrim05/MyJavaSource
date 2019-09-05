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
<%! String rst = null;%>

<body>
<!-- action="<%=request.getContentLength() %>/imagesFolderProcess" -->
<form  method="post">
<select name="fileName">
<%
String result = (String)request.getAttribute("result");
if(result!=null){
	rst = result;
}

Map<String,String> imgMap = (Map)request.getAttribute("images");
// Entry<String,String> imgEntry = imgList.entrySet();
for(Entry<String,String> img : imgMap.entrySet()){
		String path = img.getKey();
		String fileName = img.getValue();
%>
	<option value=<%=path %>><%=fileName %></option>
<%
}
 %>
	<!-- 옵션들은 images 안의 파일들 -->
</select>
	<!-- 타겟의 위치는 07  -->
	<input type="radio" value="COPY" name="command" />복사
	<input type="radio" value="MOVE" name="command" />이동
	<input type="radio" value="DELETE" name="command" />삭제
	<input type="submit" value="명령처리" />
</form>
</body>
<script type="text/javascript">
	window.onload = function() {
		var result = "<%=rst%>";
		if(result!="null"){
			alert(result);
		}
	}

</script>
</html>