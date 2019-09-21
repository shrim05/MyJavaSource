<%@page import="kr.or.ddit.enums.CommandType"%>
<%@page import="java.util.Objects"%>
<%@page import="kr.or.ddit.servlet03.FileWrapper"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	li.active{
		background-color: blue;
	}
</style>
<h4>서버파일 매니저 file manager</h4>
<%
List<FileWrapper> leftFiles = (List<FileWrapper>)request.getAttribute("leftFiles");
List<FileWrapper> rightFiles = (List<FileWrapper>)request.getAttribute("rightFiles");
String leftSrc = request.getParameter("leftSrc");
String rightTarget = request.getParameter("rightTarget");
String srcFile = request.getParameter("srcFile");
%>
<form class="managerForm" action="?" id="serverFileForm">
	<input type="text" name="leftSrc" class="leftSrc" value="<%=Objects.toString(leftSrc,"") %>"  readonly />
	<input type="text" name="rightTarget" class="rightTarget" value="<%=Objects.toString(rightTarget,"") %>"  readonly />
</form>
<ul class="groupUL" id="leftArea">
	<%
		for(FileWrapper tmp :leftFiles){
		%>
		<li id="<%=tmp.getId()%>" class="<%=tmp.getResource().isDirectory()?"dir":"file"%>" ><%=tmp.getDisplayname() %></li>
		<%		
		}
	%>
</ul>

<form class="managerForm" action="?" method="post">
	<input type="text" name="leftSrc" class="leftSrc" value="<%=Objects.toString(leftSrc,"") %>"  readonly />
	<input type="text" name="rightTarget" class="rightTarget" value="<%=Objects.toString(rightTarget,"") %>"  readonly />
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

<ul class="groupUL" id="rightArea">
	<%
		for(FileWrapper tmp :rightFiles){
		%>
		<li id="<%=tmp.getId()%>" class="<%=tmp.getResource().isDirectory()?"dir":"file"%>" ><%=tmp.getDisplayname() %></li>
		<%		
		}
	%>
</ul>
<!-- 스티브사우더스의 웹사이트 최적화 원칙 -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/serverManager.js"></script>
