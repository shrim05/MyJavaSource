<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="20kb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js">
</script>
<script type="text/javascript">
	$.getContextPath = function(){
		return "<%=request.getContextPath()%>";
		
	}
</script>
<style>
</style>
<%
	String path = (String)request.getAttribute("path");
%>
</head>
<body>
<div id="header">
<jsp:include page="/includee/header.jsp" />
<%-- <iframe src="<%=request.getContextPath() %>/includee/header.jsp"></iframe> --%>
</div>
<div id="leftMenu">
<jsp:include page="/includee/left.jsp" />
<%-- <iframe src="<%=request.getContextPath() %>/includee/left.jsp"></iframe> --%>
</div>
<div id="contents">

<%
	if(path!=null){
// 		pageContext.include(path); 이 방식은 해당 위치에 결과를 출력하기 위해 기존의 버퍼를 비운다. 따라서 모듈화작업에 적합하지 않음
 %>		 
<jsp:include page="<%= path%>" />
<%	
	
	}else{
%>
1.server side 모듈화 : acition tag
2.client side 모듈화 : iframe
<%		
	}
 %>  

</div>
<div id="footer">
<jsp:include page="/includee/footer.jsp" />
<%-- <iframe src="<%=request.getContextPath() %>/includee/footer.jsp"></iframe> --%>
</div>


</body>
</html>