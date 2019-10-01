<%@page import="java.util.Objects"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/imageForm</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/js-cookie/2.0.3/js.cookie.js"></script>
<style>
	img{
		width:100px;
		height: 100px;
	}
</style>
<body>
<%
 	String[] images = (String[])request.getAttribute("images");
	String imageName = (String)request.getAttribute("imageName");
%>
<form id="form1" action="<%=request.getContextPath() %>/image.do" method="post">
	<select name="image">
	<option value>이미지선택</option>
	<% 
	//한글일 경우, 모든 경로에서 보여줄 수 있도록 패스, age 는 이틀 (+ json 활용 (여러개의 항목을 목록화가능))
	
	for(String name : images ){ 
	%>
		<option><%=name %></option>
	<%
	}
	%>
	</select>
</form>
<div id = "imageArea">
	
</div>
<script type="text/javascript">
	var imageArea = $('#imageArea');
	var pattern = '<img src="<%=request.getContextPath() %>/image.do?image=%V" />';
	$("[name='image']").on("change",function(){
		var imageName = $(this).val();
		imageArea.append(pattern.replace("%V",imageName));
	});
	
	imageArea.on('click', "img",function(){
		$(this).remove();
	});
	$("[name='image']").val("<%=Objects.toString(imageName, "")%>");
	$("[name='image']").trigger("change");
	
</script>

</body>
</html>