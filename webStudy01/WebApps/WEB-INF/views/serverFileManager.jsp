<%@page import="kr.or.ddit.enums.CommandType"%>
<%@page import="java.util.Objects"%>
<%@page import="kr.or.ddit.servlet03.FileWrapper"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>serverFileManager</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<style type="text/css">
	li.active{
		background-color: blue;
	}
</style>

<body>
<h4>서버파일 매니저</h4>
<%
List<FileWrapper> leftFiles = (List<FileWrapper>)request.getAttribute("leftFiles");
List<FileWrapper> rightFiles = (List<FileWrapper>)request.getAttribute("rightFiles");
String leftSrc = request.getParameter("leftSrc");
String rightTarget = request.getParameter("rightTarget");
String srcFile = request.getParameter("srcFile");
%>
<form id="serverFileForm">
	<input type="text" name="leftSrc" id="leftSrc" value="<%=Objects.toString(leftSrc,"") %>"  readonly />
	<input type="text" name="rightTarget" id="rightTarget" value="<%=Objects.toString(rightTarget,"") %>"  readonly />
</form>
<ul id="leftArea">
	<%
		for(FileWrapper tmp :leftFiles){
		%>
		<li id="<%=tmp.getId()%>" class="<%=tmp.getResource().isDirectory()?"dir":"file"%>" ><%=tmp.getDisplayname() %></li>
		<%		
		}
	%>
</ul>

<form action="?" method="post">
	<input type="text" name="leftSrc" id="leftSrc" value="<%=Objects.toString(leftSrc,"") %>"  readonly />
	<input type="text" name="rightTarget" id="rightTarget" value="<%=Objects.toString(rightTarget,"") %>"  readonly />
	<input type="text" readonly name="srcFile" id="srcFile" value="<%=Objects.toString(srcFile, "") %>" />

	<%
		for(CommandType command : CommandType.values()){
	%>
			<input type="radio" name="command" value="<%=command.name() %>" required />
			<%=command.name() %>
	<%		
		}
	%>
	<input type="submit" value="전송">
</form>

<ul id="rightArea">
	<%
		for(FileWrapper tmp :rightFiles){
		%>
		<li id="<%=tmp.getId()%>" class="<%=tmp.getResource().isDirectory()?"dir":"file"%>" ><%=tmp.getDisplayname() %></li>
		<%		
		}
	%>
</ul>

</body>
<script type="text/javascript">
	var leftSrc =$('#leftSrc');
	var rightTarget = $('#rightTarget')
	var serverFileForm = $('#serverFileForm');
	var srcFile = $('#srcFile');
	$('li').css({cursor:"pointer"});
	$(".dir").on("dblclick", function(){
		if($(this).parent().prop("id")=='leftArea'){
			leftSrc.val($(this).prop("id"));
		}else{
			rightTarget.val($(this).prop("id"));
		}
		serverFileForm.submit();
	});
	$("#leftArea>.file").on("click",function(){
		$(this).siblings("li").removeClass("active");		
		$(this).toggleClass("active");
		if($(this).hasClass("active")){
			srcFile.val($(this).prop("id"));
		}else{
			srcFile.val("");
		}
	});
</script>
</html>